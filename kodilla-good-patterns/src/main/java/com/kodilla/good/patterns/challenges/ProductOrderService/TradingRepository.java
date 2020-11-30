package main.java.com.kodilla.good.patterns.challenges.ProductOrderService;

interface TradingRepository {
    boolean createTrade(User buyer, User seller, Item item);
}
