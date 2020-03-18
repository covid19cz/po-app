package cz.covid.po.api.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import cz.covid.po.api.domain.model.enumeration.AuthRole;
import cz.covid.po.api.filter.AuthFilter;
import cz.covid.po.api.generated.dto.ErrorMessageDto;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

@Configuration
@Profile("!test")
@EnableResourceServer
@RequiredArgsConstructor
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

    private final AuthFilter authFilter;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
        resources.authenticationEntryPoint(new PoAuthorizationEntryPoint());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .anonymous().authorities(List.of(AuthRole.ANONYM.toGrantedAuthority()))
                .and().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/api/*/authorizations/*").permitAll()
                .antMatchers("/api/*/**").hasAnyAuthority(AuthRole.ADMIN.toString(), AuthRole.CLIENT.toString())
                .anyRequest().authenticated()
                .and()
                .addFilterAfter(authFilter, FilterSecurityInterceptor.class);
    }

    static class PoAuthorizationEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws ServletException {
            try {
                response.setContentType("application/json");
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                ObjectMapper mapper = new ObjectMapper();
                mapper.writeValue(response.getOutputStream(), new ErrorMessageDto().message(authException.getMessage()).errorCode(ErrorMessageDto.ErrorCodeEnum.UNKNOWN));
            } catch (Exception e) {
                throw new ServletException("Error during authorization", e);
            }
        }
    }

}
