package com.example.besocialnetwork.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private String content;
    private LocalDateTime creationTime;
    @ManyToOne
    @JoinColumn(name = "postStatus_id")
    private PostStatus postStatus;


}
