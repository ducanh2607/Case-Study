package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPostRepository extends JpaRepository<Post, Long> {
    @Query(value = "select distinct p.* from post as p left join  friend_request as fr on p.user_id = fr.user_receive_id or p.user_id = fr.user_request_id left join  users_roles as u on p.user_id = u.users_id where ((fr.user_receive_id = :userId or fr.user_request_id = :userId) and fr.status = true and post_status_id != 3) or (p.user_id = :userId) or (u.roles_id = 1 and p.post_status_id != 3);",nativeQuery = true)
    Iterable<Post> findAllPostNewFeed(@Param("userId")Long userId);
}
