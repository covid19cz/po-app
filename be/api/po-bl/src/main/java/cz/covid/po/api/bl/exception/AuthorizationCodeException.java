package cz.covid.po.api.bl.exception;

import lombok.Getter;

/**
 * Error indicating sms authorization is too old / used / incorrect / ...
 * - status 400
 */
@Getter
public class AuthorizationCodeException extends BusinessException {

    private AuthorizationErrorCode errorCode;

    public AuthorizationCodeException(String message, AuthorizationErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public enum AuthorizationErrorCode {
        ERROR_CODE_TOO_OLD, ERROR_CODE_ALREADY_USED, ERROR_CODE_TOO_MANY_ATTEMPTS, ERROR_CODE_INCORRECT
    }
}
