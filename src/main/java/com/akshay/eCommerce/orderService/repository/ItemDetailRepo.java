package com.akshay.eCommerce.orderService.repository;

import com.akshay.eCommerce.orderService.models.ItemDetail;
import com.akshay.eCommerce.orderService.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemDetailRepo extends JpaRepository<ItemDetail,Long> {
    ItemDetail save(ItemDetail itemDetail);
    Optional<ItemDetail> findByOrder(Order order);
}

