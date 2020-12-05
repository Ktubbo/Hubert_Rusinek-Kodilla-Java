package com.kodilla.good.patterns.challenges.food2door.glutenfreeshop;
import com.kodilla.good.patterns.challenges.food2door.Order;
import com.kodilla.good.patterns.challenges.food2door.OrderDto;
import com.kodilla.good.patterns.challenges.food2door.Producer;
import com.kodilla.good.patterns.challenges.food2door.healthyshop.SponsorInformationService;
import com.kodilla.good.patterns.challenges.food2door.healthyshop.SponsorRepository;

public class GlutenFreeShop implements Producer {


    private GlutenFreeShopInformationService glutenFreeShopInformationService = new GlutenFreeShopInformationService();
    private GlutenFreeShopOrderRepository glutenFreeShopOrderRepository = new GlutenFreeShopOrderRepository();
    private SponsorInformationService sponsorInformationService = new SponsorInformationService();
    private SponsorRepository sponsorRepository = new SponsorRepository();

    @Override
    public void differenceInProcess(OrderDto orderDto) {
        sponsorRepository.sendToRepository(orderDto);
        sponsorInformationService.inform(orderDto);
        glutenFreeShopOrderRepository.sendToRepository(orderDto);
        glutenFreeShopInformationService.inform(orderDto);
    }

    @Override
    public void process(Order order) { differenceInProcess(Producer.commonProcess(order));}

}
