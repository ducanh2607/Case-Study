package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.model.FriendRequest;
import com.example.besocialnetwork.repository.IFriendRequestRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class FriendRequestService implements ICRUDService<FriendRequest, Long> {
    private final IFriendRequestRepository friendRequestRepository;

    public FriendRequestService(IFriendRequestRepository friendRequestRepository) {
        this.friendRequestRepository = friendRequestRepository;
    }

    @Override
    public Iterable<FriendRequest> findAll() {
        return this.friendRequestRepository.findAll();
    }

    @Override
    public Optional<FriendRequest> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public FriendRequest save(FriendRequest friendRequest) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {
    }

}
