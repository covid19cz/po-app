package cz.covid.po.api.bl.exception;

/**
 * Parent for all exceptions in the system.
 */
public abstract class AbstractException extends RuntimeException {
    public AbstractException(String message) {
        super(message);
    }

    public AbstractException(String message, Throwable cause) {
        super(message, cause);
    }
}
