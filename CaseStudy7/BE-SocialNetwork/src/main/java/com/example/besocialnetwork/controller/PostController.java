package com.example.besocialnetwork.controller;

import com.example.besocialnetwork.model.ImagePost;
import com.example.besocialnetwork.model.Post;
import com.example.besocialnetwork.service.impl.ImagePostService;
import com.example.besocialnetwork.service.impl.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
    private final PostService postService;
    private final ImagePostService imagePostService;

    public PostController(PostService postService, ImagePostService imagePostService) {
        this.postService = postService;
        this.imagePostService = imagePostService;
    }

    @PostMapping("/create")
    public ResponseEntity<Post> create(@RequestBody Post post){
        return new ResponseEntity<>(this.postService.save(post), HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<Iterable<Post>> findAll(){
        return new ResponseEntity<>(this.postService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/create/img")
    public ResponseEntity<ImagePost> create(@RequestBody ImagePost[] imagePosts){
        for (ImagePost imagePost: imagePosts){
            this.imagePostService.save(imagePost);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/all/new_feed/{id}")
    public ResponseEntity<Iterable<Post>> findAllPostNewFeed(@PathVariable Long id){
        return new ResponseEntity<>(this.postService.findAllPostNewFeed(id), HttpStatus.OK);
    }
    @GetMapping("img/{id}")
    public ResponseEntity<Iterable<ImagePost>> findAllImagePostByPostId(@PathVariable Long id){
        return new ResponseEntity<>(this.imagePostService.findAllByPostId(id), HttpStatus.OK);
    }

}
