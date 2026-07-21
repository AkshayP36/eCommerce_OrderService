package com.akshay.eCommerce.orderService.repository;

import com.akshay.eCommerce.orderService.models.Order;
import com.akshay.eCommerce.orderService.models.OrderStateTimeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderStateTimeMappingRepo extends JpaRepository<OrderStateTimeMapping,Long> {
    Optional<OrderStateTimeMapping> findByOrder(Order order);
}
