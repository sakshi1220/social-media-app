package io.reflectoring.demo.services;

import java.util.List;

import io.reflectoring.demo.models.Post;

public interface PostService {

    public Post createPost(Post post, Integer userId) throws Exception;

    String deletePost(Integer postId, Integer userId) throws Exception;

    List<Post> findPostByUserId(Integer userId);

    Post findPostById(Integer postId) throws Exception;
    
    List<Post> findAllPost();

    Post savePost(Integer postId, Integer userId) throws Exception;

    Post likePost(Integer postId, Integer userId) throws Exception;


}
