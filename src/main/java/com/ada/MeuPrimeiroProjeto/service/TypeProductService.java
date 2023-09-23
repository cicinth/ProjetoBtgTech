package com.ada.MeuPrimeiroProjeto.service;

import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductResponse;
import com.ada.MeuPrimeiroProjeto.model.TypeProduct;
import com.ada.MeuPrimeiroProjeto.repository.TypeProductRepository;
import com.ada.MeuPrimeiroProjeto.utils.TypeProductConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductService {

    @Autowired
    TypeProductRepository typeProductRepository;

    public List<TypeProductResponse> getAllTypeProducts(){
        return TypeProductConvert.toResponseList(typeProductRepository.findAll());
    }

    public TypeProductResponse saveTypeProduct(TypeProductRequest typeProductRequest){
        TypeProduct typeProduct = typeProductRepository.save(
                TypeProductConvert.toEntity(typeProductRequest)
        );
        return TypeProductConvert.toResponse(typeProduct);
    }
}
