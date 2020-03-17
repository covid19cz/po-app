package cz.covid.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Value("${api.service.username}")
    private String apiServiceUsername;

    @Value("${api.service.password}")
    private String apiServicePassword;


    /**
     * {noop} means no password encryption is used by Spring Security (default is bcrypt)
     **/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(apiServiceUsername)
                .password("{noop}" + apiServicePassword)
                .roles("API_USER");
    }

    /**
     * Basic auth for 'api/**' path, no csrf, no session
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

}
