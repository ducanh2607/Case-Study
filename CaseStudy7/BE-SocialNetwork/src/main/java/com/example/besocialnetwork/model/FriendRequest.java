package com.example.besocialnetwork.model;

import com.example.besocialnetwork.model.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userRequest_id")
    private Users usersRequest;
    @ManyToOne
    @JoinColumn(name = "userReceive_id")
    private Users usersReceive;
    private boolean status;
}
