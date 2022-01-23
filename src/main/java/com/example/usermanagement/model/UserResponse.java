package com.example.usermanagement.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    Long user_id;
    String username;
    String email;
}
