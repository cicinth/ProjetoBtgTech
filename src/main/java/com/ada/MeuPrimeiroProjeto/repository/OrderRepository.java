package com.ada.MeuPrimeiroProjeto.repository;

import com.ada.MeuPrimeiroProjeto.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM ORDERS WHERE USER_ID = :userId", nativeQuery = true)
    List<Order> findAllByUser(Integer userId);

    @Query(value = "SELECT order FROM Order order JOIN order.products product WHERE product.id = :productId")
    List<Order> findAllByProduct(Integer productId);

}
