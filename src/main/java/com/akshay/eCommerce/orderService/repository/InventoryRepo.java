package com.akshay.eCommerce.orderService.repository;

import com.akshay.eCommerce.orderService.models.Inventory;
import com.akshay.eCommerce.orderService.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findByItem(Item item);

    Inventory save(Inventory inventory);
}