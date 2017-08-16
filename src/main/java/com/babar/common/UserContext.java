package com.babar.common;

import com.babar.security.Role;

import java.util.Arrays;
import java.util.List;

import static com.babar.security.Role.*;
/**
 * @author babar
 * @since 7/25/17.
 */
public class UserContext {

    public static List<Role> getProfileRoles() {
        return Arrays.asList(
                INSTITUTION_CREATE,
                INSTITUTION_UPDATE,
                INSTITUTION_SUBMIT,
                INSTITUTION_APPROVE,
                INSTITUTION_RETURN,
                INSTITUTION_DELETE,

                QUESTION_PAPER_CREATE,
                QUESTION_PAPER_UPDATE,
                QUESTION_PAPER_SUBMIT,
                QUESTION_PAPER_APPROVE,
                QUESTION_PAPER_RETURN,
                QUESTION_PAPER_DELETE,

                QUESTION_CREATE,
                QUESTION_UPDATE,
                QUESTION_SUBMIT,
                QUESTION_APPROVE,
                QUESTION_RETURN,
                QUESTION_DELETE
            );
    }
}
