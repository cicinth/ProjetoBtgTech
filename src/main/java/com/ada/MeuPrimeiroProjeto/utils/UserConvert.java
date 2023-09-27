package com.ada.MeuPrimeiroProjeto.utils;

import com.ada.MeuPrimeiroProjeto.controller.dto.UserRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.UserResponse;
import com.ada.MeuPrimeiroProjeto.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.ArrayList;
import java.util.List;

public class UserConvert {

    public static User toEntity(UserRequest userDTO){
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public static UserResponse toResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setName(user.getName());
        userResponse.setEmail(user.getEmail());

        return userResponse;

    }

    public static List<UserResponse> toResponseList(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = UserConvert.toResponse(user);
            userResponses.add(userResponse);
        }
        return userResponses;
    }

    public static Page<UserResponse> toResponsePage(Page<User> users){
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse userResponse = UserConvert.toResponse(user);
            userResponses.add(userResponse);
        }
        return new PageImpl<>(userResponses);
    }


}
