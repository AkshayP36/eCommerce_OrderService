package com.akshay.eCommerce.orderService.repository;

import com.akshay.eCommerce.orderService.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    Order save(Order order);
}
