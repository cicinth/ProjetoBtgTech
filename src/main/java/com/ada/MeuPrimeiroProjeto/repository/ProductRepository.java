package com.ada.MeuPrimeiroProjeto.repository;

import com.ada.MeuPrimeiroProjeto.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
