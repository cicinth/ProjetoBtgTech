package com.ada.MeuPrimeiroProjeto.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {
    @GetMapping("/")
    public String healtCheck(){
        return "Application Running";
    }
}
