package com.akshay.eCommerce.orderService.services;

import com.akshay.eCommerce.orderService.exceptions.ShortInventoryException;
import com.akshay.eCommerce.orderService.models.*;
import com.akshay.eCommerce.orderService.repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemDetailRepo itemDetailRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderStateTimeMappingRepo orderStateTimeMappingRepo;

    @Transactional
    public Order createOrder(Map<Long,Long> itemQuantityMap, Long customerId) throws ShortInventoryException {
        Order order = new Order();
        Double totalCost = 0D;
        List<ItemDetail> items = new ArrayList<>();
        List<OrderStateTimeMapping> orderTimeline = new ArrayList<>();

        //Step1: check if customer exists
        Optional<Customer> customerCheck = customerRepo.findById(customerId);
        if(customerCheck.isEmpty()) return null;
        order.setCustomer(customerCheck.get());


        //Item and total price
        for(Map.Entry<Long, Long> entry: itemQuantityMap.entrySet()){
            Long temp_ItemId = entry.getKey();
            Long temp_Quantity = entry.getValue();


            //Find an item details
            Optional<Item> temp_Item = itemRepo.findById(temp_ItemId);
            if(temp_Item.isEmpty()) return null;

            //Check if item available in inventory?
            Optional<Inventory> temp_inventory = inventoryRepo.findByItem(temp_Item.get());
            if(temp_inventory.isEmpty()) return null;
            if(temp_inventory.get().getCount()<temp_Quantity) throw new ShortInventoryException(
                    "Ordered Quantity is not Available");
            temp_inventory.get().setCount(temp_inventory.get().getCount()-temp_Quantity);//decreasing inventory by quantity
            inventoryRepo.save(temp_inventory.get());

            //calculate total price
            totalCost += temp_Item.get().getPrice() * temp_Quantity;

            //creating Item details now
            ItemDetail temp_ItenDetails = new ItemDetail();
            temp_ItenDetails.setItem(temp_Item.get());
            temp_ItenDetails.setQuantity(temp_Quantity);
            temp_ItenDetails.setOrder(order);

            items.add(temp_ItenDetails);

        }

        //save ItemDetails
        itemDetailRepo.saveAll(items);

        //Set order fields
        order.setItems(items);
        order.setTotalCost(totalCost);
        //now saving order in database also
        order = orderRepo.save(order);

        //creating timemapping
        OrderStateTimeMapping mapping = new OrderStateTimeMapping();
        mapping.setOrderState(OrderState.CONFIRMED);
        mapping.setDate(new Date());
        mapping.setOrder(order);
        mapping = orderStateTimeMappingRepo.save(mapping);

        //Add mapping to order timeline
        orderTimeline.add(mapping);
        order.setOrderTimeline(orderTimeline);

        return order;
    }
}
