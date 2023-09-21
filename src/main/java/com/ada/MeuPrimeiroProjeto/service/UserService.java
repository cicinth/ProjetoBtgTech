package com.ada.MeuPrimeiroProjeto.service;

import com.ada.MeuPrimeiroProjeto.model.User;
import com.ada.MeuPrimeiroProjeto.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }

    public Optional<User> getUserById(Integer id){
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public List<User> getAllByName(String name){
        return userRepository.findAllByName(name);
    }

}
