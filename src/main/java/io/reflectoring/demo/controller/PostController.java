package io.reflectoring.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.reflectoring.demo.models.Post;
import io.reflectoring.demo.response.Apiresponse;
import io.reflectoring.demo.services.PostService;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/posts/user/{userId}")
    public ResponseEntity<Post> createPost(@RequestBody Post post, @PathVariable Integer userId) throws Exception{
        Post createdPost= postService.createPost(post, userId);
        return new ResponseEntity<>(createdPost,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/posts/user/{userId}/{postId}")
    public ResponseEntity<Apiresponse> deletePost(@PathVariable Integer postId, @PathVariable Integer userId) throws Exception{
        String message= postService.deletePost(postId, userId);
        Apiresponse resp= new Apiresponse(message,true);
        return new ResponseEntity<Apiresponse>(resp,HttpStatus.OK);
    }
}
