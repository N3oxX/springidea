package com.mtzperez.springidea.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("david".equals(username)) {
            return new User("david", "$2a$10$UvM83hZa1U0ifU5GT7LKheqCzs6wbQd7gLy6tWZcDXV4BRwzoOhje", new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found");
        }


    }
}