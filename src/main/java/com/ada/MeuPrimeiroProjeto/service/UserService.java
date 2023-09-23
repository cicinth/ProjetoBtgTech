package com.ada.MeuPrimeiroProjeto.service;

import com.ada.MeuPrimeiroProjeto.controller.dto.UserRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.UserResponse;
import com.ada.MeuPrimeiroProjeto.model.User;
import com.ada.MeuPrimeiroProjeto.repository.UserRepository;
import com.ada.MeuPrimeiroProjeto.utils.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserResponse> getUsers(){
        List<User> users = userRepository.findAll();
        return UserConvert.toResponseList(users);

    }

    public UserResponse saveUser(UserRequest userDTO){
        User user = UserConvert.toEntity(userDTO);
        User userEntity = userRepository.save(user);
        return UserConvert.toResponse(userEntity);
    }

    public UserResponse getUserById(Integer id){
        return UserConvert.toResponse(userRepository.findById(id).get());
    }

    public UserResponse getUserByEmail(String email){
        return UserConvert.toResponse(userRepository.findByEmail(email).get());
    }

    public List<UserResponse> getAllByName(String name){
        return UserConvert.toResponseList(userRepository.findAllByName(name));
    }

}
