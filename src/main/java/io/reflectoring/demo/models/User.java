package io.reflectoring.demo.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// @Table(name = "users")
public class User {
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private List<Integer> followers = new ArrayList<>();
    private List<Integer> following=new ArrayList<>();
    private List<Post> savedPosts= new ArrayList<>();
    public List<Integer> getFollowers() {
        return followers;
    }
    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }
    public List<Integer> getFollowing() {
        return following;
    }
    public void setFollowing(List<Integer> following) {
        this.following = following;
    }
    public User(){}
    public User(Integer Id, String firstName, String lastName, List<Integer> followers, List<Integer> following,List<Post> savedPosts) {
        this.id=Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.followers = followers;
        this.following = following;
        this.savedPosts = savedPosts;
    }
    
      
    
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public List<Post> getSavedPosts() {
        return savedPosts;
    }
    public void setSavedPosts(List<Post> savedPosts) {
        this.savedPosts = savedPosts;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer Id) {
        this.id = Id;
    }

    
}
