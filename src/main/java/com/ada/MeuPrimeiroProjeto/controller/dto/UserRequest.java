package com.ada.MeuPrimeiroProjeto.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
@AllArgsConstructor
public class UserRequest {
    @NotBlank()
    @Length(min = 3, max = 35)
    private String name;
    @Email
    private String email;

    private String password;

}
