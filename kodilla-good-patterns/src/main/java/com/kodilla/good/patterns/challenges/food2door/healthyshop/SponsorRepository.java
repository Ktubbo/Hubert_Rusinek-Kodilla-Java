package com.kodilla.good.patterns.challenges.food2door.healthyshop;

import com.kodilla.good.patterns.challenges.food2door.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.OrderRepository;

public class SponsorRepository implements OrderRepository {
    @Override
    public void sendToRepository(OrderDto orderDto) {
        System.out.println("Order is saved in sponsor repository.");
    }
}
