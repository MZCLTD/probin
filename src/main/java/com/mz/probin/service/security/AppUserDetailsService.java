package com.mz.probin.service.security;

import com.mz.probin.entities.security.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = this.userManager.getUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username/password combination is invalid!");
        }

        user.setPassword(this.userManager.getPasswordByUsername(username));

        Set<SimpleGrantedAuthority> authorities = new HashSet<>(1);
        authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));

        user.setAuthorities(authorities);

        return user;
    }

}
