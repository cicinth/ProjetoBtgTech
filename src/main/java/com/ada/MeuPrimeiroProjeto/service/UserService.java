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
import java.util.Optional;


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
        user.setActive(true);
        User userEntity = userRepository.save(user);
        return UserConvert.toResponse(userEntity);
    }

    public UserResponse getUserById(Integer id){
        Optional<User> userResponse =  userRepository.findById(id);
        if(userResponse.isPresent()){
            return UserConvert.toResponse(userResponse.get());
        } else {
            throw new RuntimeException("nao encontrado");
        }
    }

    public UserResponse getUserByEmail(String email){
        return UserConvert.toResponse(userRepository.findByEmail(email).get());
    }

    public List<UserResponse> getAllByName(String name){
        return UserConvert.toResponseList(userRepository.findAllByName(name));
    }

    public void deleteUser(Integer id){
        User user = userRepository.findById(id).orElseThrow();
        user.setActive(false);
        userRepository.save(user);
    }

    public UserResponse updateUser(Integer id, UserRequest userRequest){
        User user = UserConvert.toEntity(userRequest);
        user.setId(id);
        return UserConvert.toResponse(userRepository.save(user));
    }

}
