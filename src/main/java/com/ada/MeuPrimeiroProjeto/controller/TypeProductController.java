package com.ada.MeuPrimeiroProjeto.controller;

import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductResponse;
import com.ada.MeuPrimeiroProjeto.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TypeProductController {

    @Autowired
    TypeProductService typeProductService;

    @GetMapping("/type-product")
    public List<TypeProductResponse> getAllTypeProduct(){
        return typeProductService.getAllTypeProducts();
    }

    @PostMapping("/type-product")
    public TypeProductResponse saveTypeProduct(@RequestBody TypeProductRequest typeProductRequest){
        return typeProductService.saveTypeProduct(typeProductRequest);
    }
}
