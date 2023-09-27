package com.ada.MeuPrimeiroProjeto.controller;

import com.ada.MeuPrimeiroProjeto.controller.dto.OrderRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.OrderResponse;
import com.ada.MeuPrimeiroProjeto.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest){
        return orderService.saveOrder(orderRequest);
    }


    @GetMapping
    public List<OrderResponse> getOrder(
            @RequestParam(name = "userId", required = false) Integer userId,
            @RequestParam(name = "productId", required = false) Integer productId
    ){
       return orderService.getAllOrders(userId, productId);
    }



}
