package com.ada.MeuPrimeiroProjeto.controller;


import com.ada.MeuPrimeiroProjeto.controller.dto.ProductRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.ProductResponse;
import com.ada.MeuPrimeiroProjeto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/product")
    public ProductResponse saveProduct(@RequestBody ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }
}
