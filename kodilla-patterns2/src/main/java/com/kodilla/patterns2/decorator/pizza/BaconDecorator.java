package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BaconDecorator extends AbstractPizzaOrderDecorator {

    public BaconDecorator(PizzaOrder pizzaOrder) { super(pizzaOrder); }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(4));
    }
    @Override
    public String getIngredient() {
        return super.getIngredient() + ", bacon";
    }
}
