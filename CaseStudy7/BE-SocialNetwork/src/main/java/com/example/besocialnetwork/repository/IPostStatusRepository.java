package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.PostStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostStatusRepository extends JpaRepository<PostStatus, Long> {
}
