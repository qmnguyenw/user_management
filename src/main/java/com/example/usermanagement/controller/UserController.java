package com.example.usermanagement.controller;

import com.example.usermanagement.model.AppUser;
import com.example.usermanagement.model.UserResponse;
import com.example.usermanagement.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public @ResponseBody
    Iterable<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/list")
    public ResponseEntity<?> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public @ResponseBody
    AppUser getDetailUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody
    String deleteDetailUser(@PathVariable("id") Long id) {
        return userService.deleteById(id);
    }

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam List<String> roles
    ) {
        AppUser u = new AppUser();
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
//        u.setRoles();
//        TODO: check role - add role to user

        return userService.save(u);

    }

}
