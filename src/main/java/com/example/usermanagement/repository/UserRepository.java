package com.example.usermanagement.repository;

import com.example.usermanagement.model.AppUser;
import com.example.usermanagement.model.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
//    @Query("SELECT user_id, username, password, email FROM User")
//    List<AppUser> findAllUsers();

//    @Query("SELECT u.user_id, u.username, u.password, u.email, roles " +
//            "FROM User u INNER JOIN user_role rl " +
//            "ON u.user_id = rl.user_id")
    Optional<AppUser> findAllByUsername(String username);

//    Optional<UserResponse> getAllByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
