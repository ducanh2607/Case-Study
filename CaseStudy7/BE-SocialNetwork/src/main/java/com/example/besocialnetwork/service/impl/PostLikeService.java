package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.model.PostLike;
import com.example.besocialnetwork.repository.IPostLikeRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostLikeService implements ICRUDService<PostLike, Long> {
    private final IPostLikeRepository postLikeRepository;

    public PostLikeService(IPostLikeRepository postLikeRepository) {
        this.postLikeRepository = postLikeRepository;
    }

    @Override
    public Iterable<PostLike> findAll() {
        return this.postLikeRepository.findAll();
    }

    @Override
    public Optional<PostLike> findById(Long aLong) {
        return this.postLikeRepository.findById(aLong);
    }

    @Override
    public PostLike save(PostLike postLike) {
        return this.postLikeRepository.save(postLike);
    }

    @Override
    public void deleteById(Long aLong) {
        this.postLikeRepository.deleteById(aLong);

    }
    public Iterable<PostLike> findAllByPostId(Long id){
        return this.postLikeRepository.findAllByPostId(id);
    }
    public void deleteByUserIdAndPostId(Long id, Long aLong){
        this.postLikeRepository.deleteByUserIdAndPostId(id, aLong);
    }
}
