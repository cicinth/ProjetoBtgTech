package com.ada.MeuPrimeiroProjeto.controller;

import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductResponse;
import com.ada.MeuPrimeiroProjeto.service.TypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/type-product")
public class TypeProductController {

    @Autowired
    TypeProductService typeProductService;

    @GetMapping
    public ResponseEntity<List<TypeProductResponse>>getAllTypeProduct(){
        return ResponseEntity.ok(typeProductService.getAllTypeProducts());
    }

    @PostMapping
    public ResponseEntity<TypeProductResponse> saveTypeProduct(@RequestBody TypeProductRequest typeProductRequest){
        TypeProductResponse typeProductResponse = typeProductService.saveTypeProduct(typeProductRequest);
        return ResponseEntity.created(
                URI.create("/type-product/"+typeProductResponse.getId())
        ).body(typeProductResponse);
    }

    @DeleteMapping("/{id}")
    public void deleteTypeProduct(@PathVariable Integer id){
        typeProductService.deleteTypeProduct(id);
    }
}
