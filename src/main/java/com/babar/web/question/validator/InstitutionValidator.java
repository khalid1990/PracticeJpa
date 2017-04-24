package com.babar.web.question.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author babar
 * @since 4/24/17.
 */
public class InstitutionValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
