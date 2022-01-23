package com.example.usermanagement.services;

import com.example.usermanagement.model.AppUser;
import com.example.usermanagement.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        get user in db

//        for (com.example.usermanagement.model.User u : userService.getAllUsers()) {
//            if (username.equals(u.getUsername())) {
//                System.out.println(u.getUsername());
//                return new User(u.getUsername(), u.getPassword(), new ArrayList<>());
//            }
//
//        }
//        throw new UsernameNotFoundException("Username " + username + " not found");

//        return new User("foo", "foo", new ArrayList<>());

        AppUser user = null;
        user = userService.findByUsername(username).get();
//        List<Role> roles = roleService.findByName()
        System.out.println(user);
//        orElseThrow(
//                () -> new UsernameNotFoundException("User Not Found with username " + username)
//        );

        return UserDetailsImpl.build(user);
    }
}