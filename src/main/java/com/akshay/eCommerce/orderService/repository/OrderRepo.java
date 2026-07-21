package com.akshay.eCommerce.orderService.repository;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long> {
    Order save(Order order);
}
