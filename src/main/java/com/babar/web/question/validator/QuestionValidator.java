package com.babar.web.question.validator;

import com.babar.web.question.model.QuestionPaperCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author babar
 * @since 3/15/17.
 */
@Component
public class QuestionValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return QuestionPaperCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
