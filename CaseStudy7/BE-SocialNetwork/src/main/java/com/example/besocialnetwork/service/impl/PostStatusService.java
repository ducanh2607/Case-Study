package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.model.PostStatus;
import com.example.besocialnetwork.repository.IPostStatusRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostStatusService implements ICRUDService<PostStatus, Long> {
    private final IPostStatusRepository postStatusRepository;

    public PostStatusService(IPostStatusRepository postStatusRepository) {
        this.postStatusRepository = postStatusRepository;
    }

    @Override
    public Iterable<PostStatus> findAll() {
        return this.postStatusRepository.findAll();
    }

    @Override
    public Optional<PostStatus> findById(Long aLong) {
        return this.postStatusRepository.findById(aLong);
    }

    @Override
    public PostStatus save(PostStatus postStatus) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
