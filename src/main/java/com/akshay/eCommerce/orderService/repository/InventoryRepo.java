package com.akshay.eCommerce.orderService.repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByItem(Item item);

    Inventory save(Inventory inventory);
}