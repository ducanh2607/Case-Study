package com.example.besocialnetwork.controller;

import com.example.besocialnetwork.DTO.UsersDTO;
import com.example.besocialnetwork.model.Users;
import com.example.besocialnetwork.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<Users>> findAll(){
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/list-friend/{id}")
    public ResponseEntity<List<UsersDTO>> findAllFriend(@PathVariable Long id){

        return new ResponseEntity<>(this.userService.findAllFriend(id), HttpStatus.OK);
    }
    @GetMapping("/count-friend/{id}")
    public ResponseEntity<Integer> countFriend(@PathVariable Long id){
        return new ResponseEntity<>(this.userService.countFriend(id), HttpStatus.OK);
    }



}
