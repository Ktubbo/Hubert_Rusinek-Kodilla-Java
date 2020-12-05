package com.kodilla.good.patterns.challenges.food2door.healthyshop;

import com.kodilla.good.patterns.challenges.food2door.*;

public class HealthyShop implements Producer{


    private HealthyShopInformationService healthyShopInformationService = new HealthyShopInformationService();
    private HealthyShopOrderRepository healthyShopOrderRepository = new HealthyShopOrderRepository();

    @Override
    public void differenceInProcess(OrderDto orderDto) {
        healthyShopOrderRepository.sendToRepository(orderDto);
        healthyShopInformationService.inform(orderDto);
    }

    @Override
    public void process(Order order) { differenceInProcess(Producer.commonProcess(order)); }
}

