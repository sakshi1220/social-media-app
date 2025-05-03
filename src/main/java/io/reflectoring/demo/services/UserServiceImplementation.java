package io.reflectoring.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.reflectoring.demo.models.User;
import io.reflectoring.demo.repository.UserRepository;

@Service
public class UserServiceImplementation implements UserServices {
    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setId(user.getId());
        User saveUser = userRepository.save(newUser);
        return saveUser;
    }

    @Override
    public User findUserbyId(Integer userId) throws Exception {
       Optional<User> user1=  userRepository.findById(userId);
        
        if(user1.isPresent()){
            return user1.get();
        }

        throw new Exception("user doesnt exist"+ userId);
    }

    @Override
    public User followUser(Integer userId1, Integer userId2) throws Exception {
        // TODO Auto-generated method stub
        User user1 = findUserbyId(userId1);
        User user2 = findUserbyId(userId2);
        user2.getFollowers().add(user1.getId());
        user1.getFollowing().add(user2.getId());
        userRepository.save(user1);
        userRepository.save(user2);
        return user1;
    }

    @Override
    public User updateUser(User user, Integer userId) throws Exception {
        Optional<User> user1 = userRepository.findById(userId);
        
        if(user1.isEmpty()){
            throw new Exception("user does not exist");
        }
        
        User oldUser=user1.get();
        if(user.getFirstName()!=null){
            oldUser.setFirstName(user.getFirstName());
    }
        if(user.getLastName()!=null){
            oldUser.setLastName(user.getLastName()); 
    }
    User updatedUser= userRepository.save(oldUser);
        return updatedUser;
    }

    @Override
    public List<User> searchUser(String query) {
       List<User> user= userRepository.searchUser(query);
        return user;
      
    }

}
