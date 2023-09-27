package com.ada.MeuPrimeiroProjeto.controller;


import com.ada.MeuPrimeiroProjeto.controller.dto.ProductRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.ProductResponse;
import com.ada.MeuPrimeiroProjeto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public List<ProductResponse> getAllProduct(
            @RequestParam(name = "typeProduct", required = false) Integer typeProduct
    ){
        return productService.getAllProduct(typeProduct);
    }

    @PostMapping
    public ProductResponse saveProduct(@RequestBody ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }
}
