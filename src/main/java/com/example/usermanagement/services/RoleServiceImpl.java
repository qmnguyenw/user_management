package com.example.usermanagement.services;

import com.example.usermanagement.model.ERole;
import com.example.usermanagement.model.Role;
import com.example.usermanagement.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Optional<Role> findByName(ERole name) {
        return roleRepository.findByName(name);
    }
}
