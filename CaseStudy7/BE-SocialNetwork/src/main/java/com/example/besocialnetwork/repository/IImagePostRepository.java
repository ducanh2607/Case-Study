package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.ImagePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IImagePostRepository extends JpaRepository<ImagePost, Long> {
    Iterable<ImagePost> findAllByPostId(Long along);
}
