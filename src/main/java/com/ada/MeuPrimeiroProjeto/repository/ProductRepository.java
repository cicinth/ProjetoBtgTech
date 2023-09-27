package com.ada.MeuPrimeiroProjeto.repository;

import com.ada.MeuPrimeiroProjeto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.type.id = :type")
    List<Product> findProductByType(@Param("type") Integer typeProduct);
}
