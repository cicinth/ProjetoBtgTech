package com.ada.MeuPrimeiroProjeto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double totalPrice;

    @ManyToOne
    private User user;

    @ManyToMany()
    private List<Product> products;

}
