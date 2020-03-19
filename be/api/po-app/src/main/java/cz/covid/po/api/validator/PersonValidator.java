package cz.covid.po.api.validator;

import cz.covid.po.api.bl.exception.MultiValidationException;
import cz.covid.po.api.generated.dto.PersonRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class PersonValidator {
    private static final String LETTERS_AND_DASH_REGEXP = "^[a-zA-Z-\\s]*$";
    private static final String EMAIL_REGEXP = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private MultiValidationException.ExceptionBuilder exception = new MultiValidationException.ExceptionBuilder();

    public void validatePerson(PersonRequest personRequest) {
        if (!personRequest.getFirstname().matches(LETTERS_AND_DASH_REGEXP)) {
            exception.addError("Person.firstname is not valid");
        }

        if (!personRequest.getSurname().matches(LETTERS_AND_DASH_REGEXP)) {
            exception.addError("Person.surname is not valid");
        }

        if (!personRequest.getEmail().matches(EMAIL_REGEXP)) {
            exception.addError("Person.email is not valid");
        }

        if (exception.hasError()) {
            throw exception.build();
        }
    }
}
