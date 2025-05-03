package io.reflectoring.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reflectoring.demo.models.Post;
import io.reflectoring.demo.models.User;
import io.reflectoring.demo.repository.PostRepository;
import io.reflectoring.demo.repository.UserRepository;

@Service
public class PostServiceImplementation implements PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserServices userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public Post createPost(Post post, Integer userId) throws Exception {
        User user = userService.findUserbyId(userId);
       Post newPost= new Post();
       newPost.setCaption(post.getCaption());
       newPost.setImage(post.getImage());
    //    newPost.setCreatedAt(new LocalDateTime.now);
    newPost.setVideo(post.getVideo());
    newPost.setUser(user);
       return newPost;
    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception  {
        Post post= findPostById(postId);
        User user= userService.findUserbyId(userId);
        if(post.getUser().getId()!=user.getId()){
            throw new Exception("You can delete another user's post");
        }
        postRepository.deleteById(postId);
        return "post delete successfully";
    }

    @Override
    public List<Post> findPostByUserId(Integer userId) {
        return postRepository.findPostByUserId(userId);
    }

    @Override
    public Post findPostById(Integer postId) throws Exception {
        Optional<Post> post= postRepository.findById(postId);
        if(post.isEmpty()){
             throw new Exception("Post not found");
        } 
        return post.get();
    }

    @Override
    public List<Post> findAllPost() {
       return postRepository.findAll();
    }

    @Override
    public Post savePost(Integer postId, Integer userId) throws Exception {
        Post post= findPostById(postId);
        User user= userService.findUserbyId(userId);
        if(user.getSavedPosts().contains(post)){
            user.getSavedPosts().remove(post);
        }
        else{
            user.getSavedPosts().add(post);
        }
         userRepository.save(user);
         return post;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws Exception {
        Post post= findPostById(postId);
        User user= userService.findUserbyId(userId);
        if(post.getLiked().contains(user)){
            post.getLiked().remove(user);
        }
        else{
        post.getLiked().add(user);
        postRepository.save(post);
        }
        return post;
    }

}
