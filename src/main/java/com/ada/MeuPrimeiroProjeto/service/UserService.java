package com.ada.MeuPrimeiroProjeto.service;

import com.ada.MeuPrimeiroProjeto.controller.dto.UserRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.UserResponse;
import com.ada.MeuPrimeiroProjeto.model.User;
import com.ada.MeuPrimeiroProjeto.repository.UserRepository;
import com.ada.MeuPrimeiroProjeto.utils.UserConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Page<UserResponse> getUsers(int page, int size, String direction){
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(direction), "name");
        Page<User> users = userRepository.findAll(pageRequest);
        return UserConvert.toResponsePage(users);

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
