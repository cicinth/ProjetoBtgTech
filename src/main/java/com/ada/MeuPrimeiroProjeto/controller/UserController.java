package com.ada.MeuPrimeiroProjeto.controller;

import com.ada.MeuPrimeiroProjeto.controller.dto.UserRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.UserResponse;
import com.ada.MeuPrimeiroProjeto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping
    public ResponseEntity<Page<UserResponse>>getUsers(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0"
            ) int page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "10"
            ) int size,
            @RequestParam(
                    value = "direction",
                    required = false,
                    defaultValue = "ASC"
            ) String direction

    ){

        return ResponseEntity.ok(userService.getUsers(page, size, direction));
    }

    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userDTO){

        UserResponse user =  userService.saveUser(userDTO);
        return ResponseEntity.created(URI.create("/user/"+user.getId())).body(user);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public UserResponse getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/name/{name}")
    public List<UserResponse> getAllUserByName(@PathVariable String name, @PathVariable Integer id){
        return userService.getAllByName(name);
    }

}

