package io.reflectoring.demo.services;

import java.util.List;

import io.reflectoring.demo.models.User;

public interface UserServices {

    public User registerUser(User user);

    public User findUserbyId(Integer userId) throws Exception;

    public User followUser(Integer userId1, Integer userId2)throws Exception;

    public User updateUser(User user, Integer userId) throws Exception;

    public List<User> searchUser(String query);

}
