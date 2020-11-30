package main.java.com.kodilla.good.patterns.challenges.ProductOrderService;

public class TradeDto {

    public Item item;
    public boolean isTraded;

    public TradeDto(final Item item, final boolean isTraded) {
        this.item = item;
        this.isTraded = isTraded;
    }

    public Item getItem() {
        return item;
    }

    public boolean isTraded() {
        return isTraded;
    }
}
