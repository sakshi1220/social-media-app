package io.reflectoring.demo.models;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String caption;
    private String image;
    private String Video;
    private User user;
    private List<User> liked = new ArrayList<>();
    
    public Post() {
    }
    public Post( String caption, String image, String video, User user, LocalDateTime createdAt, List<User> liked) {
        this.caption = caption;
        this.image = image;
        Video = video;
        this.user = user;
        this.createdAt = createdAt;
        this.liked=liked;
    }
    public String getCaption() {
        return caption;
    }
    public List<User> getLiked() {
        return liked;
    }
    public void setLiked(List<User> liked) {
        this.liked = liked;
    }
    public void setCaption(String caption) {
        this.caption = caption;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getVideo() {
        return Video;
    }
    public void setVideo(String video) {
        Video = video;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    private LocalDateTime createdAt;
}
