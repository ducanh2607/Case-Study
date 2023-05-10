package com.example.besocialnetwork.controller;

import com.example.besocialnetwork.model.ImagePost;
import com.example.besocialnetwork.model.Post;
import com.example.besocialnetwork.model.PostLike;
import com.example.besocialnetwork.service.impl.ImagePostService;
import com.example.besocialnetwork.service.impl.PostCommentService;
import com.example.besocialnetwork.service.impl.PostLikeService;
import com.example.besocialnetwork.service.impl.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/post")
@CrossOrigin("*")
public class PostController {
    private final PostService postService;
    private final ImagePostService imagePostService;
    private final PostCommentService postCommentService;
    private final PostLikeService postLikeService;

    public PostController(PostService postService, ImagePostService imagePostService, PostCommentService postCommentService, PostLikeService postLikeService) {
        this.postService = postService;
        this.imagePostService = imagePostService;
        this.postCommentService = postCommentService;
        this.postLikeService = postLikeService;
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
    @PostMapping("/like_post")
    public ResponseEntity<PostLike> likePost(@RequestBody PostLike postLike){
        return new ResponseEntity<>(this.postLikeService.save(postLike),HttpStatus.CREATED);
    }
    @GetMapping("/find_like/post/{id}")
    public ResponseEntity<Iterable<PostLike>> findLikeByPost(@PathVariable Long id){
        return  new ResponseEntity<>(this.postLikeService.findAllByPostId(id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id){
        Optional<Post> postCheck = this.postService.findById(id);
        return postCheck.map(post -> new ResponseEntity<>(post, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @DeleteMapping("/delete/like/user/{userId}/post/{postId}")
    public ResponseEntity<String> deletePostLikeByUserIdAndPostId(@PathVariable Long userId, @PathVariable Long postId){
        this.postLikeService.deleteByUserIdAndPostId(userId, postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }






}
