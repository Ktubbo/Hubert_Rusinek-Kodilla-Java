package com.kodilla.good.patterns.challenges.food2door;

public class Item {

    String typeOfProduct;

    public Item(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    @Override
    public String toString() {
        return "Item{" +
                "typeOfProduct='" + typeOfProduct + '\'' +
                '}';
    }
}
