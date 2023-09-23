package com.ada.MeuPrimeiroProjeto.controller.dto;

import com.ada.MeuPrimeiroProjeto.model.TypeProduct;
import lombok.Getter;


@Getter
public class ProductRequest {
    private String name;
    private Double price;
    private Integer typeId;
}
