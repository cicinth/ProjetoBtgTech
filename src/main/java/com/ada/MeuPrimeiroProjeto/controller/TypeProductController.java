package com.ada.MeuPrimeiroProjeto.controller;

import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductResponse;
import com.ada.MeuPrimeiroProjeto.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type-product")
public class TypeProductController {

    @Autowired
    TypeProductService typeProductService;

    @GetMapping
    public List<TypeProductResponse> getAllTypeProduct(){
        return typeProductService.getAllTypeProducts();
    }

    @PostMapping
    public TypeProductResponse saveTypeProduct(@RequestBody TypeProductRequest typeProductRequest){
        return typeProductService.saveTypeProduct(typeProductRequest);
    }
}
