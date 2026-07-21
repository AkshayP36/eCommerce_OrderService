package com.akshay.eCommerce.orderService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseModel {
    private String number;
    private String street;
    private String city;
    private String pincode;
    private String landmark;
    private String state;
    private Boolean isDefault;

    @ManyToMany(mappedBy = "addresses")
    private List<Customer> customers;
}
