package com.akshay.eCommerce.orderService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Inventory extends BaseModel {
    @OneToOne
    private Item item;

    private Double count;

    private Double orderingCost;

    private Double stockOutCost;
}
