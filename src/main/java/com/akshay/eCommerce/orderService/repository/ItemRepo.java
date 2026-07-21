package com.akshay.eCommerce.orderService.repository;

import com.akshay.eCommerce.orderService.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends JpaRepository<Item,Long> {
}
