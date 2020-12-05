package com.kodilla.good.patterns.challenges.food2door;

public interface Producer {

    static OrderDto commonProcess(Order order){

        OrderDto orderDto = new OrderService(order).makeAnOrder(order);
        boolean isOrdered = orderDto.isOrdered();

        if(isOrdered) {
            return orderDto;
        } else {
            System.out.println("Order cannot be fulfilled.");
            return null;
        }
    }

    void differenceInProcess(OrderDto orderDto);
    void process(Order order);
}

