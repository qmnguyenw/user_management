package com.example.usermanagement.services;

import com.example.usermanagement.model.User;
import com.example.usermanagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public String save(User user) {
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
        User tempUser = findById(id);

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
    public User findById(Long id) {
        Optional<User> result = userRepository.findById(id);

        User user = null;

        if (result.isPresent()) {
            user = result.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
        return user;
    }
}
