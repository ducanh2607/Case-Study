package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {
}
