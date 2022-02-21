package com.teachmeskills.visaction.model;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrder;
    private int cost;
    private String startDate;
    private String validPeriod;

    public Order() {
    }
}
