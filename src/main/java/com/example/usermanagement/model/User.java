package com.example.usermanagement.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Column(columnDefinition = "varchar(255) default ''")
    private String address;

    @Column(columnDefinition = "varchar(255) default ''")
    private String role;
}
