package com.kodilla.good.patterns.challenges.tradeapp;

import com.kodilla.good.patterns.challenges.food2door.Item;

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
