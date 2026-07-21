package com.akshay.eCommerce.orderService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Item extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Boolean isPremium;

    @OneToOne(mappedBy = "item")
    private Inventory inventory;
}
