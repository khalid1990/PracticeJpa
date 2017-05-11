package com.babar.web.question.validator;

import com.babar.web.question.model.InstitutionCommand;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author babar
 * @since 4/24/17.
 */
public class InstitutionValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return InstitutionCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        InstitutionCommand command = (InstitutionCommand) target;
    }
}
