package com.akshay.eCommerce.orderService.repository;

import java.util.Optional;

@Repository
public interface OrderStateTimeMappingRepo extends JpaRepository<OrderStateTimeMapping,Long> {
    Optional<OrderStateTimeMapping> findByOrder(Order order);
}
