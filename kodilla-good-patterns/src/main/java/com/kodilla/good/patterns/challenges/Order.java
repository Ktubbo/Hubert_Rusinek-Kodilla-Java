package com.kodilla.good.patterns.challenges;

public class Order {

    private Supplier supplier;
    private double quantityOfProduct;
    private String typeOfProduct;

    public Order(Supplier supplier, double quantityOfProduct, String typeOfProduct) {
        this.supplier = supplier;
        this.quantityOfProduct = quantityOfProduct;
        this.typeOfProduct = typeOfProduct;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public double getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }
}
