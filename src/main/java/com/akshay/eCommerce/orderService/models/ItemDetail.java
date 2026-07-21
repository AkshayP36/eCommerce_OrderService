package com.akshay.eCommerce.orderService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetail extends BaseModel {
    @ManyToOne
    private Item item;

    private Long quantity;

    @ManyToOne
    private Order order;
}
