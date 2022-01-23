package com.example.usermanagement.services;

import com.example.usermanagement.model.ERole;
import com.example.usermanagement.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(ERole name);
}
