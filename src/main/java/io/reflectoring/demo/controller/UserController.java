package io.reflectoring.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import io.reflectoring.demo.models.User;
import io.reflectoring.demo.repository.UserRepository;
import io.reflectoring.demo.services.UserServices;
@RestController
public class UserController {
    @Autowired
     UserServices userService;
    @Autowired
    UserRepository userRepository;
     @PostMapping("/addUser")
     public User createUser(@RequestBody User user){
        User user1= userService.registerUser(user);
        return user1;
        
     }
    @GetMapping("/getAllUsers/{userId}")
    public User getUsersById(@PathVariable("userId") Integer Id) throws Exception{
        
        User user1= userService.findUserbyId(Id);
        return user1;
       
    }
    @GetMapping("/getAllUsers")
    public List<User> getUsers(){
        
       List<User> users= userRepository.findAll();
      
        return users;
    }
   
    @PutMapping("/users/{userId}")
    public User updateUser(@RequestBody User user, @PathVariable Integer userId) throws Exception{
        User udatedUser= userService.updateUser( user, userId);
        return udatedUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Integer userId) throws Exception{
       Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()){
            throw new Exception("user doesn't exist");
        }
        userRepository.delete(user.get());
        return "user Deleted";
    }
    @PutMapping("/user/{userId1}/{userId2}")
    public User follwerHandler(@PathVariable Integer userId1, @PathVariable Integer userId2)throws Exception{
        User user= userService.followUser(userId1, userId2);
        return user;
    }
    @GetMapping("/user/search")
    public List<User> searchUser(@RequestParam("query") String query){
        List<User> users=userService.searchUser(query);
        return users;
    }
}