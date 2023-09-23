package com.ada.MeuPrimeiroProjeto.utils;

import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.TypeProductResponse;
import com.ada.MeuPrimeiroProjeto.model.TypeProduct;

import java.util.ArrayList;
import java.util.List;

public class TypeProductConvert {

    public static TypeProduct toEntity(TypeProductRequest typeProductRequest){
        TypeProduct typeProduct = new TypeProduct();
        typeProduct.setName(typeProductRequest.getName());
        return typeProduct;
    }

    public static TypeProductResponse toResponse(TypeProduct typeProduct){
        TypeProductResponse typeProductResponse =  new TypeProductResponse();
        typeProductResponse.setId(typeProduct.getId());
        typeProductResponse.setName(typeProduct.getName());
        return typeProductResponse;
    }

    public static List<TypeProductResponse> toResponseList(List<TypeProduct> typesProducts){
        List<TypeProductResponse> typesProductResponses = new ArrayList<>();
        for(TypeProduct typeProduct: typesProducts){
            typesProductResponses.add(toResponse(typeProduct));
        }

        return typesProductResponses;
    }
}
