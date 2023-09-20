package com.ada.MeuPrimeiroProjeto.service;

import com.ada.MeuPrimeiroProjeto.model.User;
import com.ada.MeuPrimeiroProjeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUser(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

}
