package com.kodilla.good.patterns.challenges.food2door;

public class Supplier {

    private String name;
    private String lastName;
    private int supplierID;

    public Supplier(String name, String lastName, int supplierID) {
        this.name = name;
        this.lastName = lastName;
        this.supplierID = supplierID;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    @Override
    public String toString() {
        return "Supplier{" + "name='" + name  + ", lastName='" + lastName + ", supplierID=" + supplierID + '}';
    }
}
