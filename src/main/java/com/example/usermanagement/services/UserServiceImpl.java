package com.example.usermanagement.services;

import com.example.usermanagement.model.SuccessResponse;
import com.example.usermanagement.model.AppUser;
import com.example.usermanagement.model.UserResponse;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(
                new SuccessResponse(
                        200,
                        "done",
                        userRepository.findAll()
                )
        );
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<AppUser> userList = userRepository.findAll();
        List<UserResponse> users = new ArrayList<>();

        for (AppUser i : userList) {
            UserResponse userResponse = new UserResponse();
            userResponse.setUser_id(i.getId());
            userResponse.setUsername(i.getUsername());
            userResponse.setEmail(i.getEmail());

            System.out.println(userResponse);

            users.add(userResponse);
        }
        return users;
    }

    @Override
    public String save(AppUser user) {
        try {
            userRepository.save(user);
            return "Add successful";
        } catch (Exception e) {
            e.printStackTrace();
            return "Add fail";
        }
    }

    @Override
    public String deleteById(Long id) {
        AppUser tempUser = findById(id);

        // throw exception if null

        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + id);
        }

        try {
            userRepository.deleteById(id);
            return "Deleted user id - " + id;
        } catch (Exception e) {
            return "Deleted fail!";
        }
    }

    @Override
    public AppUser findById(Long id) {
        Optional<AppUser> result = userRepository.findById(id);

        AppUser user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return user;
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return userRepository.findAllByUsername(username);
    }

    @Override
    public Optional<UserResponse> getAllByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
