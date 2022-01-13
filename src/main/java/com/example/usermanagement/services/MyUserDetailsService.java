package com.example.usermanagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        get user in db

        for (com.example.usermanagement.model.User u : userService.getAllUsers()) {
            if (username.equals(u.getUsername())) {
                System.out.println(u.getUsername());
                return new User(u.getUsername(), u.getPassword(), new ArrayList<>());
            }

        }
        throw new UsernameNotFoundException("Username " + username + " not found");
//        return new User("foo", "foo", new ArrayList<>());
    }
}