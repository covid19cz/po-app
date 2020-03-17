package cz.covid.po.api.integration.common.exception;

import cz.covid.po.api.integration.common.enumeration.IntegrationSystem;

/**
 * The Integration error indicates that there was problem with another system integration.
 */
public class IntegrationException extends RuntimeException {

    private final IntegrationSystem integrationSystem;

    public IntegrationException(String message, Throwable cause, IntegrationSystem integrationSystem) {
        super(message, cause);
        this.integrationSystem = integrationSystem;
    }

    public IntegrationException(String message, IntegrationSystem integrationSystem) {
        super(message);
        this.integrationSystem = integrationSystem;
    }
}
