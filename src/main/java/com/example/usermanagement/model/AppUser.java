package com.example.usermanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
//@Table(name = "app_user")
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    @Column(columnDefinition = "varchar(255) default ''")
    private String email;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(  name = "user_role",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
//    private Set<Role> roles = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> appUserRole = new HashSet<>();
}
