package cz.covid.po.api.bl.service;

import cz.covid.po.api.bl.dto.CustomUser;
import cz.covid.po.api.bl.exception.AuthenticationException;
import cz.covid.po.api.domain.model.Operator;
import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.domain.model.User;
import cz.covid.po.api.domain.repository.OperatorRepository;
import cz.covid.po.api.domain.repository.PersonRepository;
import cz.covid.po.api.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    public static final int MAX_INVALID_ATTEMPTS = 10;
    
    private final OperatorRepository operatorRepository;
    private final PersonRepository personRepository;
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));

        switch (user.getRole()) {
            case ADMIN:
                return signOperator(user);
            case CLIENT:
                return signClient(user);
            default:
                throw new UsernameNotFoundException("Invalid authority for user " + username);
        }
    }

    private CustomUser signOperator(User user) {
        Operator operator = operatorRepository.findByUserId(user.getId())
                .orElseThrow(() -> new UsernameNotFoundException("Operator " + user.getLogin() + " not found"));

        if (user.getInvalidLoginAttempts() >= MAX_INVALID_ATTEMPTS) {
            throw new AuthenticationException("too many wrong attempts", "TO_MANY_WRONG_ATTEMPTS");
        }

        return CustomUser.operator(user.getLogin(), user.getPassword(), operator.isActive(), user.getId(), user.getRole());
    }

    private CustomUser signClient(User user) {
        Person person = personRepository.findByUserId(user.getId())
                .orElseThrow(() -> new UsernameNotFoundException("Person " + user.getLogin() + " not found"));

        if (user.getInvalidLoginAttempts() >= MAX_INVALID_ATTEMPTS) {
            throw new AuthenticationException("too many wrong attempts", "TO_MANY_WRONG_ATTEMPTS");
        }

        return CustomUser.client(user.getLogin(), user.getPassword(), person.getUid(), user.getId());
    }
}
