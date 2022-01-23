package com.example.usermanagement.services;

import com.example.usermanagement.model.AppUser;
import com.example.usermanagement.model.UserResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    ResponseEntity<?> getUsers();

    public List<UserResponse> getAllUsers();

    public String save(AppUser user);

    public String deleteById(Long id);

    public AppUser findById(Long id);

    public Optional<AppUser> findByUsername(String username);

    public Boolean existsByUsername(String username);

    public Boolean existsByEmail(String email);

    Optional<UserResponse> getAllByUsername(String username);

}
