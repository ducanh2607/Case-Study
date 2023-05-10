package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostLikeRepository extends JpaRepository<PostLike, Long> {
}
