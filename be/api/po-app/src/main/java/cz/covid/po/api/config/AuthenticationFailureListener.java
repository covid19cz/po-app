package cz.covid.po.api.config;

import cz.covid.po.api.bl.service.LoginAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private final LoginAttemptService loginAttemptService;

    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        if (e.getSource() instanceof UsernamePasswordAuthenticationToken) {
            String username = (String) ((UsernamePasswordAuthenticationToken) e.getSource()).getPrincipal();
            loginAttemptService.loginFailed(username);
        }
    }
}
