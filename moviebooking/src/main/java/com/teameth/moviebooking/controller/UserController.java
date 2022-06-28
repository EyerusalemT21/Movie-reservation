
package com.teameth.moviebooking.controller;

import com.teameth.moviebooking.domain.Location;
import com.teameth.moviebooking.domain.User;
import com.teameth.moviebooking.reservation.MyUserDetailService;
import com.teameth.moviebooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

   @Autowired

   UserService userService;


@Autowired
    MyUserDetailService myUserDetailService;

   //@Autowired




    @RequestMapping("/user")
    public List<User> getAllLocations(){
        return userService.getAllUser();
    }

    @RequestMapping(method = RequestMethod.POST ,value="/user")
    public void saveNewUser(@RequestBody User user){
        userService.saveUser(user);
    }
    @RequestMapping("/user/{username}")
    public User getAllUsers(@PathVariable String username){
        return userService.getByUsername(username);
    }



}

