package com.babar.web.user.service;

import com.babar.db.entity.User;
import com.babar.security.QBankUserDetails;
import com.babar.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author babar
 * @since 9/9/17.
 */
@Repository
public class QBankUserDetailsService implements UserDetailsService{

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUserByEmail(email);

        /*I was autowiring UserService inside QBankUserDetails class to get the roles
        * for the logged in user. But as I was instantiating the userDetails object here,
        * autowiring inside was not supposed to work. So I am declaring a collection of
        * granted authorities (roles) inside QBankUserDetails and setting up the values here.
        * */
        QBankUserDetails userDetails = new QBankUserDetails(user);
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<Role> roles = userService.getRoles(user);

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        userDetails.setAuthorities(authorities);

        return userDetails;
    }
}
