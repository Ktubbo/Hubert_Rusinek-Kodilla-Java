package com.kodilla.good.patterns.challenges.food2door.glutenfreeshop;

import com.kodilla.good.patterns.challenges.food2door.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.OrderRepository;

public class GlutenFreeShopOrderRepository implements OrderRepository {
    @Override
    public void sendToRepository(OrderDto orderDto) {
        System.out.println("Order was made.");
    }
}
