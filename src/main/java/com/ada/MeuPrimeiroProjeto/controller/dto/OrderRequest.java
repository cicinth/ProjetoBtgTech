package com.ada.MeuPrimeiroProjeto.controller.dto;

import lombok.Getter;
import java.util.List;


@Getter
public class OrderRequest {
    private Double totalPrice;
    private Integer userId;
    private List<Integer> productsIds;
}
