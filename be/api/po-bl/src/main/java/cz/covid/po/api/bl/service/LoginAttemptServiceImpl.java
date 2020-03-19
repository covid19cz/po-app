package cz.covid.po.api.bl.service;

import cz.covid.po.api.domain.model.User;
import cz.covid.po.api.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LoginAttemptServiceImpl implements LoginAttemptService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void loginFailed(String username) {
        userRepository.findByLogin(username).ifPresent(this::incrementAttempts);
    }

    @Override
    @Transactional
    public void success(String username) {
        userRepository.findByLogin(username).ifPresent(this::clearAttempts);
    }

    private void incrementAttempts(User user) {
        user.setInvalidLoginAttempts(user.getInvalidLoginAttempts() + 1);
    }

    private void clearAttempts(User user) {
        user.setInvalidLoginAttempts(0);
    }
}
