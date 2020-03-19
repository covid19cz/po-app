package cz.covid.po.api.bl.exception;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class MultiValidationException extends AbstractException {
    private List<String> validationErrors;


    private MultiValidationException(String message, ExceptionBuilder builder) {
        super(message);
        this.validationErrors = builder.validationErrors;
    }

    public static class ExceptionBuilder {
        private List<String> validationErrors;

        public ExceptionBuilder() {
            this.validationErrors = new ArrayList<>();
        }

        public ExceptionBuilder addError(String error) {
            if (validationErrors == null) {
                validationErrors = new ArrayList<>();
            }
            validationErrors.add(error);
            return this;
        }

        public boolean hasError() {
            return this.validationErrors.size() > 0;
        }

        public MultiValidationException build() {
            return new MultiValidationException("Validation failed", this);
        }
    }
}
