package com.akshay.eCommerce.orderService.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    //Add your APIs here
    @PostMapping()
    public Order createOrder(@RequestBody CreateOrderRequestDto request) throws ShortInventoryException {
        return orderService.createOrder(request.getItemQuantityMap(), request.getCustomerId());
    }


    @ExceptionHandler(ShortInventoryException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleShortInventoryException(
            ShortInventoryException exception
    ) {
        return exception.getMessage();
    }
}
