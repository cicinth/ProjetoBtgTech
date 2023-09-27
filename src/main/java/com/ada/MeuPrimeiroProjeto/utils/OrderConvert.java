package com.ada.MeuPrimeiroProjeto.utils;

import com.ada.MeuPrimeiroProjeto.controller.dto.OrderRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.OrderResponse;
import com.ada.MeuPrimeiroProjeto.controller.dto.ProductResponse;
import com.ada.MeuPrimeiroProjeto.model.Order;
import com.ada.MeuPrimeiroProjeto.model.Product;
import com.ada.MeuPrimeiroProjeto.model.User;

import java.util.ArrayList;
import java.util.List;

public class OrderConvert {

    public static Order toEntity(OrderRequest orderRequest, User user, List<Product> products){
        Order order = new Order();
        order.setTotalPrice(orderRequest.getTotalPrice());
        order.setUser(user);
        order.setProducts(products);
        return order;
    }

    public static OrderResponse toResponse(Order order){
        OrderResponse ordersResponse = new OrderResponse();
        ordersResponse.setId(order.getId());
        ordersResponse.setUser(order.getUser());
        ordersResponse.setProducts(order.getProducts());
        ordersResponse.setTotalPrice(order.getTotalPrice());
        return ordersResponse;
    }

    public static List<OrderResponse> toResponseList(List<Order> orders){
        List<OrderResponse> ordersResponse = new ArrayList<>();
        for(Order order: orders){
            ordersResponse.add(toResponse(order));
        }

        return ordersResponse;
    }
}
