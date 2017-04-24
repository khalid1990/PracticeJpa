package com.babar.web.question.validator;

import com.babar.web.question.model.QuestionOptionCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author babar
 * @since 3/15/17.
 */
public class QuestionOptionValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return QuestionOptionCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
