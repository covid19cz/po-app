package cz.covid.po.api.filter;

import cz.covid.po.api.bl.service.AuthService;
import cz.covid.po.api.bl.service.LoginService;
import cz.covid.po.api.domain.model.enumeration.AuthRole;
import cz.covid.po.api.generated.dto.ErrorMessageDto;
import cz.covid.po.api.helper.UidExtractorHelper;
import cz.covid.po.api.integration.common.util.JsonMapperUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Log4j2
@Component
@RequiredArgsConstructor
public class AuthFilter extends OncePerRequestFilter {

    private final AuthService authService;
    private final LoginService loginService;
    private final UidExtractorHelper uidExtractorHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        AuthRole loggedUserRole = authService.getLoggedUserRole();
        if (loggedUserRole == null) {
            filterChain.doFilter(request, response);
        } else {
            switch (loggedUserRole) {
                case ADMIN:
                case ANONYM:
                    filterChain.doFilter(request, response);
                    break;
                case CLIENT:
                    Long loggedUserIdJwt = authService.getLoggedUserId();
                    UUID loggedPersonUidJwt = authService.getPersonUid();

                    // this is because one time password
                    loginService.resetPassword(loggedUserIdJwt);
                    Optional<String> personUidOpt = uidExtractorHelper.getPersonUid(request.getRequestURI());

                    if (personUidOpt.isPresent() && loggedPersonUidJwt != null && !personUidOpt.get().equals(loggedPersonUidJwt.toString())) {
                        log.error("Access to person={} by userId={} is forbidden", personUidOpt, loggedUserIdJwt);
                        writeToResponse(response, HttpStatus.FORBIDDEN,
                                new ErrorMessageDto().errorCode(ErrorMessageDto.ErrorCodeEnum.UNAUTHORIZED));
                    } else {
                        filterChain.doFilter(request, response);
                    }
                    break;
                default:
                    log.error("Unknown role: {} ", loggedUserRole);
                    writeToResponse(response, HttpStatus.FORBIDDEN,
                            new ErrorMessageDto().errorCode(ErrorMessageDto.ErrorCodeEnum.UNAUTHORIZED));
            }
        }
    }

    private void writeToResponse(HttpServletResponse response, HttpStatus httpStatus, ErrorMessageDto errorMessageDto) throws IOException {
        response.setStatus(httpStatus.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        PrintWriter writer = response.getWriter();
        writer.write(JsonMapperUtil.toJson(errorMessageDto));
    }
}
