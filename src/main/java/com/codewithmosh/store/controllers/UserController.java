package com.codewithmosh.store.controllers;



import org.springframework.web.bind.annotation.RestController;

import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.UserRepository;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;



@AllArgsConstructor 
@RestController 
public class UserController {
    private final UserRepository userRepository;
    // @RequestMapping("/users", method=RequestMethod.GET)
    @GetMapping("/users")  
    public Iterable<User> getAllUsers(){
        return  userRepository.findAll();
    }
    
}
