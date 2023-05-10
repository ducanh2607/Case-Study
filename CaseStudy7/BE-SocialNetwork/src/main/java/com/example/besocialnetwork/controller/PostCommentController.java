package com.example.besocialnetwork.controller;

import com.example.besocialnetwork.model.PostComment;
import com.example.besocialnetwork.service.impl.PostCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/post_comment")
public class PostCommentController {
    private final PostCommentService postCommentService;

    public PostCommentController(PostCommentService postCommentService) {
        this.postCommentService = postCommentService;
    }
    @GetMapping("/all/post/{id}")
    public ResponseEntity<Iterable<PostComment>> findAllByPostId(@PathVariable Long id){
        return new ResponseEntity<>(this.postCommentService.findAllByPostId(id), HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<PostComment> create(@RequestBody PostComment postComment){
        return new ResponseEntity<>(this.postCommentService.save(postComment), HttpStatus.CREATED);
    }
}
