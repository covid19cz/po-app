package cz.covid.po.api.config;

import cz.covid.po.api.bl.service.LoginAttemptService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private final LoginAttemptService loginAttemptService;

    public void onApplicationEvent(AuthenticationSuccessEvent e) {
        if (e.getSource() instanceof UsernamePasswordAuthenticationToken) {
            Object principal = ((UsernamePasswordAuthenticationToken) e.getSource()).getPrincipal();
            if (principal instanceof User) {
                loginAttemptService.success(((User) principal).getUsername());
            }
        }
    }
}
