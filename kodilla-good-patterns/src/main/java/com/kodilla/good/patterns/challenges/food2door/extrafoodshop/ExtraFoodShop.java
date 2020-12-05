package com.kodilla.good.patterns.challenges.food2door.extrafoodshop;

import com.kodilla.good.patterns.challenges.food2door.*;

public class ExtraFoodShop implements Producer {

    private ExtraFoodShopInformationService extraFoodShopInformationService = new ExtraFoodShopInformationService();
    private ExtraFoodShopOrderRepository extraFoodShopOrderRepository = new ExtraFoodShopOrderRepository();

    @Override
    public void differenceInProcess(OrderDto orderDto) {
        orderDto.getOrder().getSupplier().setSupplierID(orderDto.getOrder().getSupplier().getSupplierID()+10000000);
        extraFoodShopOrderRepository.sendToRepository(orderDto);
        extraFoodShopInformationService.inform(orderDto);
        System.out.println(orderDto.getOrder());
    }

    @Override
    public void process(Order order) { differenceInProcess(Producer.commonProcess(order)); }
}
