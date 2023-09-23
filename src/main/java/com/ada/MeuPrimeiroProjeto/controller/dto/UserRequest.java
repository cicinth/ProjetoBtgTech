package com.ada.MeuPrimeiroProjeto.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequest {
    private String name;
    private String email;
    private Integer password;
}
