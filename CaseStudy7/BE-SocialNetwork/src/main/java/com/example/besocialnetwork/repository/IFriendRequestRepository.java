package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFriendRequestRepository extends JpaRepository<FriendRequest, Long> {
}
