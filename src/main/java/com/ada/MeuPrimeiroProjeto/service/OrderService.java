package com.ada.MeuPrimeiroProjeto.service;

import com.ada.MeuPrimeiroProjeto.controller.dto.OrderRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.OrderResponse;
import com.ada.MeuPrimeiroProjeto.model.Order;
import com.ada.MeuPrimeiroProjeto.model.Product;
import com.ada.MeuPrimeiroProjeto.model.User;
import com.ada.MeuPrimeiroProjeto.repository.OrderRepository;
import com.ada.MeuPrimeiroProjeto.repository.ProductRepository;
import com.ada.MeuPrimeiroProjeto.repository.UserRepository;
import com.ada.MeuPrimeiroProjeto.utils.OrderConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    public OrderResponse saveOrder(OrderRequest orderRequest){
        User user = userRepository.findById(orderRequest.getUserId()).get();

        List<Product> products = new ArrayList<>();

        List<Integer> productsId = orderRequest.getProductsIds();

        for(Integer id: productsId){
            Product product = productRepository.findById(id).get();
            products.add(product);
        }

        Order order = OrderConvert.toEntity(orderRequest, user, products);


        return OrderConvert.toResponse(orderRepository.save(order));
    }

    public List<OrderResponse>  getAllOrders(Integer userId, Integer productId){
        if( userId != null ){
            return getAllByUser(userId);
        } else if(productId != null){
            return getAllByProduct(productId);
        } else {
            return OrderConvert.toResponseList(orderRepository.findAll());
        }
    }

    public List<OrderResponse> getAllByUser(Integer userId){
        return OrderConvert.toResponseList(orderRepository.findAllByUser(userId));
    }

    public List<OrderResponse> getAllByProduct(Integer productId){
        return OrderConvert.toResponseList(orderRepository.findAllByProduct(productId));
    }
}
