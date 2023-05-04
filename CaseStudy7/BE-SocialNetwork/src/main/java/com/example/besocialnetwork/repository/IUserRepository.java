package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {
     Optional<Users> findUsersByUsername(String name);
     Optional<Users> findUsersByUsernameOrEmail(String username, String email);
     @Query(value = "select u.username from Users as u")
     Iterable<String> findAllUsername();
     @Query(value = "select u.email from Users as u")
     Iterable<String> findAllEmail();
     @Query(value = "select u.phone from Users as u")
     Iterable<String> findAllPhone();
     @Query(value = "SELECT u.* FROM users u INNER JOIN friend_request fr ON u.id = fr.user_request_id OR u.id = fr.user_receive_id WHERE fr.status = true AND (fr.user_request_id = :userId OR fr.user_receive_id = :userId) AND u.id != :userId",nativeQuery = true)
     List<Users> findAllFriend(@Param("userId") Long userId);
     @Query(value ="SELECT count(u.id) as count FROM users u INNER JOIN friend_request fr ON u.id = fr.user_request_id OR u.id = fr.user_receive_id WHERE fr.status = true AND (fr.user_request_id = :userId OR fr.user_receive_id = :userId) AND u.id != :userId", nativeQuery = true)
     public Integer countFriend(@Param("userId") Long userId);

}
