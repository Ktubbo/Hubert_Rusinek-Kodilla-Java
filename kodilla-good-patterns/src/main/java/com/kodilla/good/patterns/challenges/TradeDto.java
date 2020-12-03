package com.kodilla.good.patterns.challenges;

public class TradeDto {

    private Item item;
    private boolean isTraded;

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
