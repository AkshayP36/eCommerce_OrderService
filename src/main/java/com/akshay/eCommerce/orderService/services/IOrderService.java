package com.akshay.eCommerce.orderService.services;

import com.akshay.eCommerce.orderService.exceptions.ShortInventoryException;
import com.akshay.eCommerce.orderService.models.Order;

import java.util.Map;

public interface IOrderService {
    Order createOrder(Map<Long,Long> itemQuantityMap, Long customerId) throws ShortInventoryException;
}
