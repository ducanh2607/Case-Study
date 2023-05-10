package com.example.besocialnetwork.service.impl;

import com.example.besocialnetwork.model.ImagePost;
import com.example.besocialnetwork.repository.IImagePostRepository;
import com.example.besocialnetwork.service.ICRUDService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImagePostService implements ICRUDService<ImagePost, Long> {
    private final IImagePostRepository imagePostRepository;

    public ImagePostService(IImagePostRepository imagePostRepository) {
        this.imagePostRepository = imagePostRepository;
    }

    @Override
    public Iterable<ImagePost> findAll() {
        return this.imagePostRepository.findAll();
    }

    @Override
    public Optional<ImagePost> findById(Long aLong) {
        return this.imagePostRepository.findById(aLong);
    }

    @Override
    public ImagePost save(ImagePost imagePost) {
        return this.imagePostRepository.save(imagePost);
    }

    @Override
    public void deleteById(Long aLong) {
        this.imagePostRepository.deleteById(aLong);
    }
    public Iterable<ImagePost> findAllByPostId(Long along){
        return this.imagePostRepository.findAllByPostId(along);
    }
}
