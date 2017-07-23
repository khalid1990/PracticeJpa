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
                INSTITUTION_DELETE
                );
    }
}
