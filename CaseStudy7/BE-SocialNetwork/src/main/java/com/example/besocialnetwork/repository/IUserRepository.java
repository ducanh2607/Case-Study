package com.example.besocialnetwork.repository;

import com.example.besocialnetwork.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Pattern;
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

}
