package com.ada.MeuPrimeiroProjeto.controller;

import com.ada.MeuPrimeiroProjeto.controller.dto.UserRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.UserResponse;
import com.ada.MeuPrimeiroProjeto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/user")
    public UserResponse saveUser(@RequestBody UserRequest userDTO){
        return userService.saveUser(userDTO);
    }

    @GetMapping("/user/{id}")
    public UserResponse getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/user/email/{email}")
    public UserResponse getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/user/name/{name}")
    public List<UserResponse> getAllUserByName(@PathVariable String name, @PathVariable Integer id){
        return userService.getAllByName(name);
    }



}

