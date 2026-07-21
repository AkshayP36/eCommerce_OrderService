package com.akshay.eCommerce.orderService.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends BaseModel{
    // private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "CUSTOMERS_ADDRESSES",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    @Fetch(FetchMode.SUBSELECT)
    private List<Address> addresses;

    private String email;

    private String password;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}