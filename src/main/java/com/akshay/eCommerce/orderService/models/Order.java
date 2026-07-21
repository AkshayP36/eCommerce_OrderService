package com.akshay.eCommerce.orderService.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ORDERS")
public class Order extends BaseModel {
    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<ItemDetail> items;

    private Double totalCost;

    @OneToMany(mappedBy = "order")
    private List<OrderStateTimeMapping> orderTimeline;
}

