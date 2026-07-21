package com.akshay.eCommerce.orderService.services;

import java.util.Map;

public interface IOrderService {
    Order createOrder(Map<Long,Long> itemQuantityMap, Long customerId) throws ShortInventoryException;
}
