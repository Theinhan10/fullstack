package com.example.fullstackbackend.controller;

import com.example.fullstackbackend.model.User;
import com.example.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//used to indicate that the class is a RESTful controller.
@RestController
public class UserController {

    //used for automatic dependency injection.
    //your UserRepository interface, it extends JpaRepository<User, Long>, which is a dependency
    @Autowired
    private UserRepository userRepository;

    //Posting the user entity into database and returning as User entity
    // Declares a method named newUser that handles the HTTP POST requests.
    // The method takes a User object (newUser) as a request body parameter.
    @PostMapping("/user")
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }


    //Getting all user and return as list
    @GetMapping("/users")
    List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //hello


}
