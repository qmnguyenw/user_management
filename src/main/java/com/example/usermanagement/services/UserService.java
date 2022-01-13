package com.example.usermanagement.services;

import com.example.usermanagement.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public String save(User user);

    public String deleteById(Long id);

    public User findById(Long id);
}
