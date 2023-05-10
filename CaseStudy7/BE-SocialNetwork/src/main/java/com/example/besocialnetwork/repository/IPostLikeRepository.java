package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.PostLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IPostLikeRepository extends JpaRepository<PostLike, Long> {
    Iterable<PostLike> findAllByPostId(Long id);
    @Transactional
    void deleteByUserIdAndPostId(Long id, Long aLong);
}
