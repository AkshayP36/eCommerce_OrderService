package com.akshay.eCommerce.orderService.exceptions;

public class ShortInventoryException extends Exception {
    public ShortInventoryException(String message) {
        super(message);
    }
}
