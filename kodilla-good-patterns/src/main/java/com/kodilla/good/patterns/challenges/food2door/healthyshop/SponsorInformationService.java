package com.kodilla.good.patterns.challenges.food2door.healthyshop;

import com.kodilla.good.patterns.challenges.food2door.Food2DoorInformationService;
import com.kodilla.good.patterns.challenges.food2door.OrderDto;

public class SponsorInformationService implements Food2DoorInformationService {

    @Override
    public void inform(OrderDto orderDto) {
        System.out.println("Information sent to sponsor.");
    }

}
