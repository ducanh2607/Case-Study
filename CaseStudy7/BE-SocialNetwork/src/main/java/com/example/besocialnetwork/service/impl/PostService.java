package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.model.Post;
import com.example.besocialnetwork.repository.IPostRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements ICRUDService<Post, Long> {
    private final IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Iterable<Post> findAll() {
        return this.postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long aLong) {
        return this.postRepository.findById(aLong);
    }

    @Override
    public Post save(Post post) {
        return this.postRepository.save(post);
    }

    @Override
    public void deleteById(Long aLong) {
        this.postRepository.deleteById(aLong);
    }
    public Iterable<Post> findAllPostNewFeed(Long aLong){
        return this.postRepository.findAllPostNewFeed(aLong);
    }
}
