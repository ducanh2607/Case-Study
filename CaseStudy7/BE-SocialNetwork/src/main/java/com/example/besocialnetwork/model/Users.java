package com.example.besocialnetwork.model;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String username;
    @Size(min = 6,  message = "Password has at least 6 characters")
    private String password;
    @Pattern(regexp = "^(.+)@(\\S+)$")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone required 10 numbers")
    private String phone;

    private LocalDate birthday;
    private boolean status = false;

    private boolean active = true;
    private String gender;
    private Integer showFriend = 0;
    private Integer commentPermission = 0;
    private String avatar;
    private String address;
    private String hobby;
    @ManyToMany(targetEntity = Role.class,fetch = FetchType.EAGER)
    private Set<Role> roles;
}
