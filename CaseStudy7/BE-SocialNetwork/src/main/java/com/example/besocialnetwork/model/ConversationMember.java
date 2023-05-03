package com.example.besocialnetwork.model;

import com.example.besocialnetwork.model.Conversation;
import com.example.besocialnetwork.model.Users;
import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConversationMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "conversation_id")
    private Conversation conversation;
}
