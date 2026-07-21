package com.akshay.eCommerce.orderService.repository;

import com.akshay.eCommerce.orderService.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
