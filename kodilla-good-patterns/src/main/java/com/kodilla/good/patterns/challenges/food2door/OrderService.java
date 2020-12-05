package com.kodilla.good.patterns.challenges.food2door;

public class OrderService {

    private Order order;

    public OrderService(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public OrderDto makeAnOrder(Order order){
        System.out.println("Supplier: " + order.getSupplier() + "Product: " + order.getTypeOfProduct() + "Quantity: " + order.getQuantityOfProduct());
        return new OrderDto(order,true);
    }
}
