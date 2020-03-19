package cz.covid.po.api.bl.exception;

import org.springframework.security.oauth2.common.exceptions.ClientAuthenticationException;

public class AuthenticationException extends ClientAuthenticationException {

    private String errorCode;

    public AuthenticationException(String msg, Throwable t, String errorCode) {
        super(msg, t);
        this.errorCode = errorCode;
    }

    public AuthenticationException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    @Override
    public String getOAuth2ErrorCode() {
        return errorCode;
    }
}
