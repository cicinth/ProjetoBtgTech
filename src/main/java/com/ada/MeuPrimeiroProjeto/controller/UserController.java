package com.ada.MeuPrimeiroProjeto.controller;

import com.ada.MeuPrimeiroProjeto.model.User;
import com.ada.MeuPrimeiroProjeto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    
    @PostMapping("/user")
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }


    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/user/name/{name}")
    public List<User> getAllUserByName(@PathVariable String name, @PathVariable Integer id){
        return userService.getAllByName(name);
    }



}

