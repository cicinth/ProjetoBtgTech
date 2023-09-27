package com.ada.MeuPrimeiroProjeto.controller.dto;

import com.ada.MeuPrimeiroProjeto.model.Product;
import com.ada.MeuPrimeiroProjeto.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderResponse {
    private Integer id;
    private Double totalPrice;
    private User user;
    private List<Product> products;
}
