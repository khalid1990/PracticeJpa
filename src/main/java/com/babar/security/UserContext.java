package com.babar.security;

import com.babar.db.entity.User;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author babar
 * @since 9/11/17.
 */
public class UserContext {

    public static User getLoggedInUser() {
        return getLoggedInUserDetails().getUser();
    }

    public static List<Role> getLoggedInUserAuthorities() {
        List<Role> roles = new ArrayList<>();

        for (GrantedAuthority authority : getLoggedInUserDetails().getAuthorities()) {
            String roleStr = authority.getAuthority();
            Role role = Role.getRoleByName(roleStr);

            if (role != null) {
                roles.add(role);
            }
        }

        return roles;
    }

    private static QBankUserDetails getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken) {
            return null;
        }

        return (QBankUserDetails) authentication.getPrincipal();
    }
}
