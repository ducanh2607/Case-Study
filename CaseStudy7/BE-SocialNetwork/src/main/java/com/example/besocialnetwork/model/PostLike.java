package com.example.besocialnetwork.model;

import com.example.besocialnetwork.model.Post;
import com.example.besocialnetwork.model.Users;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

}
