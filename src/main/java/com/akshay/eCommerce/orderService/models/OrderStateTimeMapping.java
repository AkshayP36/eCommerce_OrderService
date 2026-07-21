package com.akshay.eCommerce.orderService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderStateTimeMapping extends BaseModel {

    private OrderState orderState = OrderState.CONFIRMED;

    private Date date = new Date();

    @ManyToOne
    private Order order;
}
