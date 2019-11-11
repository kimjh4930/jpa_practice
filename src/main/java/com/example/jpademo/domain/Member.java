package com.example.jpademo.domain;

import lombok.Getter;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private int age;

    @ManyToOne( fetch = LAZY ,cascade = ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    //---관관계편의 메소드--//
    public void addOrder (Order order){
        this.orders.add(order);
        order.setMember(this);
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
