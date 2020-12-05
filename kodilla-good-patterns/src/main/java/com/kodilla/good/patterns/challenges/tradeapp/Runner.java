package com.kodilla.good.patterns.challenges.tradeapp;

import com.kodilla.good.patterns.challenges.food2door.Item;

public class Runner {

    public static void main(String[] args) {

        //13.2-----------------------------------------------------

        InformationService informationService = new InformationService() {
            @Override
            public void inform(TradeRequest tradeRequest) {
                System.out.println("Mail sent to: " + tradeRequest.getBuyer());
                System.out.println("Mail sent to: " + tradeRequest.getSeller());
            }
        };

        TradingRepository tradingRepository = new TradingRepository() {
            @Override
            public boolean createTrade(TradeRequest tradeRequest) {
                System.out.println(tradeRequest + " was created.");
                return true;
            }
        };

        TradingService tradingService = new TradingService() {
            @Override
            public boolean trade(TradeRequest tradeRequest) {
                System.out.println(tradeRequest + " was made.");
                return true;
            }
        };

        User.ProductOrderService productOrderService = new User.ProductOrderService(informationService,tradingService,tradingRepository);
        TradeRequest tradeRequest = new TradeRequest(new User("Mariusz","Kuryła"),new User("Will","Smith"),new Item("Umbrella"));
        productOrderService.process(tradeRequest);

        //13.4------------------------------------------------

        //13.5----------------------------------------------------------

    }
}
