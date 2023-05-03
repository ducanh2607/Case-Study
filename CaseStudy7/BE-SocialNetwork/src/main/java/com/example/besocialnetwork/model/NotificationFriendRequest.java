package com.example.besocialnetwork.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationFriendRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userSend_id")
    private Users userSend;
    @ManyToOne
    @JoinColumn(name = "userReceive_id")
    private Users userReceive;
    @ManyToOne
    @JoinColumn(name = "notificationType_id")
    private NotificationType notificationType;
}
