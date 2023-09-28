package com.ada.MeuPrimeiroProjeto.controller;

import com.ada.MeuPrimeiroProjeto.controller.dto.UserRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.UserResponse;
import com.ada.MeuPrimeiroProjeto.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<UserResponse> saveUser(
            @Valid @RequestBody UserRequest userDTO
    ){
        UserResponse user =  userService.saveUser(userDTO);
        return ResponseEntity.created(URI.create("/user/"+user.getId())).body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Integer id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email){
        return  ResponseEntity.ok(userService.getUserByEmail(email));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<UserResponse>> getAllUserByName(@PathVariable String name, @PathVariable Integer id){
        return ResponseEntity.ok(userService.getAllByName(name));
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id){
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(
            @PathVariable Integer id,
            @RequestBody UserRequest userRequest
    ){
        return  ResponseEntity.ok(userService.updateUser(id, userRequest));
    }
}

