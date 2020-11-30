package main.java.com.kodilla.good.patterns.challenges.ProductOrderService;

public class TradeRequest {

    private User seller;
    private User buyer;
    private Item item;

    public TradeRequest(final User seller, final User buyer, final Item item) {
        this.seller = seller;
        this.buyer = buyer;
        this.item = item;
    }

    public User getSeller() {
        return seller;
    }

    public User getBuyer() {
        return buyer;
    }

    public Item getItem() {
        return item;
    }
}
