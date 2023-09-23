package com.ada.MeuPrimeiroProjeto.service;


import com.ada.MeuPrimeiroProjeto.controller.dto.ProductRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.ProductResponse;
import com.ada.MeuPrimeiroProjeto.model.Product;
import com.ada.MeuPrimeiroProjeto.model.TypeProduct;
import com.ada.MeuPrimeiroProjeto.repository.ProductRepository;
import com.ada.MeuPrimeiroProjeto.repository.TypeProductRepository;
import com.ada.MeuPrimeiroProjeto.utils.ProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    TypeProductRepository typeProductRepository;

    public ProductResponse saveProduct(ProductRequest productRequest){
        TypeProduct typeProduct = typeProductRepository.findById(productRequest.getTypeId()).get();
        Product product = ProductConvert.toEntity(productRequest, typeProduct);
        return  ProductConvert.toResponse(productRepository.save(product));
    }

    public List<ProductResponse> getAllProduct(){
        return ProductConvert.toResponseList(productRepository.findAll());
    }
}
