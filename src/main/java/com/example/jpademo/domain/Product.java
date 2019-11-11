package com.example.jpademo.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Long id;

    private String name;

    private int price;

    private int stockAmount;

    @OneToMany(mappedBy = "product")
    private List<Order> orders = new ArrayList<>();

    //-- 연관관계 편의메소드 --//
    public void addOrder (Order order){
        this.orders.add(order);
        order.setProduct(this);
    }
}
