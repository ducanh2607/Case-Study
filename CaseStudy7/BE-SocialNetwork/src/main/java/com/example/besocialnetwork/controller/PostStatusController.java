package com.example.besocialnetwork.controller;

import com.example.besocialnetwork.model.PostStatus;
import com.example.besocialnetwork.service.impl.PostStatusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/post_status")
@CrossOrigin("*")
public class PostStatusController {
    private final PostStatusService postStatusService;

    public PostStatusController(PostStatusService postStatusService) {
        this.postStatusService = postStatusService;
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<PostStatus>> findAll(){
        return new ResponseEntity<>(this.postStatusService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<PostStatus> findById(@PathVariable Long id){
        Optional<PostStatus> postStatusCheck = this.postStatusService.findById(id);
        return postStatusCheck.map(postStatus -> new ResponseEntity<>(postStatus, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
