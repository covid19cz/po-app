package cz.covid.po.api.validator;

import cz.covid.po.api.bl.exception.MultiValidationException;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@Component
@RequestScope
public class PhoneValidator {
    private static final String PHONE_REGEXP = "^\\+[0-9]*$";
    private static final List<String> SUPPORTED_PREFIXES = List.of("+420", "+421");
    private MultiValidationException.ExceptionBuilder exception = new MultiValidationException.ExceptionBuilder();

    public void validatePhone(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone is missing");
        }
        if (!phoneNumber.matches(PHONE_REGEXP) || phoneNumber.length() < 4) {
            exception.addError("Invalid phone number");
        }

        final String phonePrefix = phoneNumber.substring(0, 4);
        if (!SUPPORTED_PREFIXES.contains(phonePrefix)) {
            exception.addError("Unsupported dialing code");
        }

        if (exception.hasError()) {
            throw exception.build();
        }
    }
}
