package com.ada.MeuPrimeiroProjeto.service;

import com.ada.MeuPrimeiroProjeto.controller.dto.OrderRequest;
import com.ada.MeuPrimeiroProjeto.controller.dto.OrderResponse;
import com.ada.MeuPrimeiroProjeto.model.Order;
import com.ada.MeuPrimeiroProjeto.model.Product;
import com.ada.MeuPrimeiroProjeto.model.QOrder;
import com.ada.MeuPrimeiroProjeto.model.User;
import com.ada.MeuPrimeiroProjeto.repository.OrderRepository;
import com.ada.MeuPrimeiroProjeto.repository.ProductRepository;
import com.ada.MeuPrimeiroProjeto.repository.UserRepository;
import com.ada.MeuPrimeiroProjeto.utils.OrderConvert;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    EntityManager entityManager;

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

    public Page<OrderResponse> getAllOrders(
            Predicate predicate,
            Pageable pageable
    ){
        Page<Order> orders = orderRepository.findAll(predicate, pageable);

        return OrderConvert.toResponsePage(orders);
    }

    public List<OrderResponse> getAllByUser(Integer userId){
        return OrderConvert.toResponseList(orderRepository.findAllByUser(userId));
    }

    public List<OrderResponse> getAllByProduct(Integer productId){
        return OrderConvert.toResponseList(orderRepository.findAllByProduct(productId));
    }
    public List<OrderResponse> getAllByPrice(Double minValue, Double maxValue){
        JPAQuery<Order> query = new JPAQuery<>(entityManager);
        QOrder qOrder = QOrder.order;

        List<Order> orders = query.from(qOrder).where(qOrder.totalPrice.between(minValue, maxValue)).fetch();
        return OrderConvert.toResponseList(orders);
    }
}
