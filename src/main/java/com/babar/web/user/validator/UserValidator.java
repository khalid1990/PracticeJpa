package com.babar.web.user.validator;

import com.babar.web.user.model.UserCommand;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author babar
 * @since 5/23/17.
 */
@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /*validation logics need to be implemented for ChangePassword feature*/
    }
}
