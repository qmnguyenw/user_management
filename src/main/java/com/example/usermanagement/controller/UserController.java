package com.example.usermanagement.controller;

import com.example.usermanagement.model.User;
import com.example.usermanagement.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    User getDetailUser(@PathVariable("id") Long id) {
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
            @RequestParam String address,
            @RequestParam String role
    ) {
        User u = new User();
        u.setUsername(username);
        u.setPassword(password);
        u.setAddress(address);
        u.setRole(role);

        return userService.save(u);

    }

}
