package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostCommentRepository extends JpaRepository<PostComment, Long> {
}
