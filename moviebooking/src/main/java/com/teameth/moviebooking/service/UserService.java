
package com.teameth.moviebooking.service;

import com.teameth.moviebooking.domain.Location;
import com.teameth.moviebooking.domain.User;
import com.teameth.moviebooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }
    public void saveUser(User user){
        userRepository.save(user);
    }
    public User getByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User getUserById(Integer userid){
        return userRepository.findById(userid).get();
    }
}

