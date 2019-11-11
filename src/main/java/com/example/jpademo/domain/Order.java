package com.example.jpademo.domain;

import lombok.Getter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Table(name = "orders")
@Getter
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne(fetch = LAZY, cascade = ALL)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public void setMember(Member member) {
        this.member = member;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
