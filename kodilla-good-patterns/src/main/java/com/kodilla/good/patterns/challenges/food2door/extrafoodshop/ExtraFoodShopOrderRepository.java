package com.kodilla.good.patterns.challenges.food2door.extrafoodshop;

import com.kodilla.good.patterns.challenges.food2door.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.OrderRepository;

public class ExtraFoodShopOrderRepository implements OrderRepository {

    private OrderDto orderDto;

    @Override
    public void sendToRepository(OrderDto orderDto) {
        System.out.println("Order was made.");
    }

}
