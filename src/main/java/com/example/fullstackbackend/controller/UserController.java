package com.example.fullstackbackend.controller;

import com.example.fullstackbackend.exception.UserHandlerException;
import com.example.fullstackbackend.exception.UserNotFoundException;
import com.example.fullstackbackend.model.User;
import com.example.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//used to indicate that the class is a RESTful controller.
@RestController
@CrossOrigin("http://localhost:3000/")
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


    @GetMapping("/user/{id}")
    User getUserByID(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}")
    User updateUser(@RequestBody User newUser, @PathVariable Long id){
        return userRepository.findById(id)
                .map(user -> {
                    user.setEmail(newUser.getUsername());
                    user.setUsername(newUser.getUsername());
                    user.setName(newUser.getName());
                    return userRepository.save(user);
                }).orElseThrow(()-> new UserNotFoundException(id));


    }

    @DeleteMapping("/user/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
        return "User with id " + id + " has been deleted success.";
    }


}
