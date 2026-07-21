package com.akshay.eCommerce.orderService.repository;

import java.util.Optional;

@Repository
public interface ItemDetailRepo extends JpaRepository<ItemDetail,Long> {
    ItemDetail save(ItemDetail itemDetail);
    Optional<ItemDetail> findByOrder(Order order);
}

