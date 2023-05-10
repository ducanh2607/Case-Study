package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.model.PostComment;
import com.example.besocialnetwork.repository.IPostCommentRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostCommentService implements ICRUDService<PostComment, Long> {
    private final IPostCommentRepository postCommentRepository;

    public PostCommentService(IPostCommentRepository postCommentRepository) {
        this.postCommentRepository = postCommentRepository;
    }

    @Override
    public Iterable<PostComment> findAll() {
        return this.postCommentRepository.findAll();
    }

    @Override
    public Optional<PostComment> findById(Long aLong) {
        return this.postCommentRepository.findById(aLong);
    }

    @Override
    public PostComment save(PostComment postComment) {
        return this.postCommentRepository.save(postComment);
    }

    @Override
    public void deleteById(Long aLong) {
        this.postCommentRepository.deleteById(aLong);
    }
    public Iterable<PostComment> findAllByPostId(Long id){
        return this.postCommentRepository.findAllByPostId(id);
    }
}
