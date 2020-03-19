package cz.covid.po.api.bl.service;

import cz.covid.po.api.bl.component.MessageProvider;
import cz.covid.po.api.bl.constant.OauthConstants;
import cz.covid.po.api.bl.exception.AuthorizationCodeException;
import cz.covid.po.api.bl.exception.BusinessException;
import cz.covid.po.api.bl.exception.NotFoundException;
import cz.covid.po.api.bl.util.DateTimeUtil;
import cz.covid.po.api.domain.model.Authorization;
import cz.covid.po.api.domain.model.Person;
import cz.covid.po.api.domain.model.User;
import cz.covid.po.api.domain.model.enumeration.AuthRole;
import cz.covid.po.api.domain.model.enumeration.AuthorizationState;
import cz.covid.po.api.domain.repository.AuthorizationRepository;
import cz.covid.po.api.domain.repository.PersonRepository;
import cz.covid.po.api.domain.repository.UserRepository;
import cz.covid.po.api.integration.profisms.service.ProfiSmsSender;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private static final int CLIENT_PASS_LENGTH = 16;

    private final AuthorizationRepository authorizationRepository;
    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final MessageProvider messageProvider;
    private final PasswordEncoder passwordEncoder;
    private final ProfiSmsSender profiSmsSender;
    @Value("${app.login.sms-code.length}")
    private int codeLength;
    @Value("${app.login.sms-code.validity}")
    private int smsCodeValidSec;
    @Value("${app.login.sms-code.max-attempts}")
    private int maxCodeAttempts;
    @Value("${app.login.sms-code.max-send}")
    private int maxSmsSend;
    @Value("${app.login.sms-code.block-time}")
    private int blockTime;
    @Value("${app.login.sms-code.enabled}")
    private boolean smsEnabled;
    @Value("${app.login.sms-code.default}")
    private String defaultSmsCode;

    @Override
    @Transactional
    public void sendAuthSms(final UUID personUid) {
        Person person = personRepository.getByUid(personUid).orElseThrow();

        String code;
        if (smsEnabled) {
            checkSmsAttempts(person);
            code = RandomStringUtils.randomNumeric(codeLength);
        } else {
            code = defaultSmsCode;
        }
        log.debug("SMS auth code for personUid={} is {}", personUid, code);

        createAuthorization(person, code);

        profiSmsSender.sendSms(person.getPhoneNumber(), messageProvider.getMessage("app.sms.authorizationCode", code));
    }

    @Override
    @Transactional(noRollbackFor = AuthorizationCodeException.class)
    public String verifyCode(UUID clientUid, String code) {
        Person person = personRepository.getByUid(clientUid).orElseThrow();

        Authorization authorization =
                authorizationRepository.findFirstByPersonOrderByCreatedAtDesc(person).orElseThrow(() -> new NotFoundException(NotFoundException.createSystemMessage("uid", clientUid, Authorization.class)));
        try {
            checkSmsCode(code, authorization);
        } catch (AuthorizationCodeException e) {
            if (e.getErrorCode() == AuthorizationCodeException.AuthorizationErrorCode.ERROR_CODE_TOO_OLD) {
                sendAuthSms(clientUid);
            }
            throw e;
        } finally {
            incrementAttempts(authorization);
        }

        User user = Optional.ofNullable(person.getUser())
                .orElseGet(() -> createUser(person));

        return updateUserPass(user);
    }

    @Override
    public void resetPassword(Long userId) {
        userRepository.findById(userId).ifPresent(user -> {
            if (!StringUtils.equals(user.getPassword(), OauthConstants.AUTH_DEFAULT_PASS)) {
                user.setPassword(OauthConstants.AUTH_DEFAULT_PASS);
                userRepository.save(user);
            }
        });
    }

    private void checkSmsAttempts(Person client) {
        OffsetDateTime time = DateTimeUtil.utc().minusSeconds(blockTime);
        List<Authorization> authsAfterTime = authorizationRepository.findAfterTimeDesc(client.getId(), time);

        int count = 0;
        for (Authorization authorization : authsAfterTime) {
            if (authorization.getState() != AuthorizationState.USED) {
                count++;
            } else {
                break;
            }
        }

        if (count >= maxSmsSend) {
            log.info("Send sms limit for clientId={} exceeded", client.getId());
            throw new BusinessException("Send sms limit for client exceeded");
        }
    }

    private User createUser(Person person) {
        User user = new User();
        user.setLogin(person.getUid().toString());
        user.setRole(AuthRole.CLIENT);
        user.setPassword(OauthConstants.AUTH_DEFAULT_PASS);
        userRepository.save(user);
        person.setUser(user);
        personRepository.save(person);
        return user;
    }

    private String updateUserPass(User user) {
        String password = RandomStringUtils.randomAlphanumeric(CLIENT_PASS_LENGTH);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        return password;
    }

    private void createAuthorization(Person person, String code) {
        Authorization authorization = new Authorization();
        authorization.setPerson(person);
        authorization.setCode(code);
        authorizationRepository.save(authorization);
    }

    private void checkSmsCode(String smsCode, Authorization authorization) {
        if (authorization.getState() == AuthorizationState.USED) {
            throw new AuthorizationCodeException("Sms code already used", AuthorizationCodeException.AuthorizationErrorCode.ERROR_CODE_ALREADY_USED);
        }

        if (authorization.getState() == AuthorizationState.INVALIDATED) {
            throw new AuthorizationCodeException("To many attempts sms code", AuthorizationCodeException.AuthorizationErrorCode.ERROR_CODE_TOO_MANY_ATTEMPTS);
        }

        if (!StringUtils.equals(smsCode, authorization.getCode())) {
            throw new AuthorizationCodeException("Wrong inserted sms code", AuthorizationCodeException.AuthorizationErrorCode.ERROR_CODE_INCORRECT);
        }

        OffsetDateTime smsValidUntil = authorization.getCreatedAt().plusSeconds(smsCodeValidSec);
        if (DateTimeUtil.utc().isAfter(smsValidUntil)) {
            authorization.setState(AuthorizationState.EXPIRED);
            throw new AuthorizationCodeException("Sms code expired", AuthorizationCodeException.AuthorizationErrorCode.ERROR_CODE_TOO_OLD);
        }

        authorization.setState(AuthorizationState.USED);
        authorizationRepository.save(authorization);
    }

    private void incrementAttempts(Authorization authorization) {
        authorization.setAttempts(authorization.getAttempts() + 1);
        if (authorization.getState() == null && authorization.getAttempts() >= maxCodeAttempts) {
            authorization.setState(AuthorizationState.INVALIDATED);
        }
        authorizationRepository.save(authorization);
    }
}
