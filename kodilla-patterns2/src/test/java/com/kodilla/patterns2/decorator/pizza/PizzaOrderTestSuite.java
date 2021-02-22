package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(new BigDecimal(15), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetIngredient() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        String ingredient = theOrder.getIngredient();
        // Then
        assertEquals("Ingredients of pizza: tomato sauce, cheese", ingredient);
    }

    @Test
    public void testPizzaWithAdditionalCheeseGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new AdditionalCheeseDecorator(theOrder);
        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(20), theCost);
    }

    @Test
    public void testPizzaWithAdditionalCheeseGetIngredient() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new AdditionalCheeseDecorator(theOrder);
        //When
        String ingredient = theOrder.getIngredient();
        //Then
        assertEquals("Ingredients of pizza: tomato sauce, cheese, additional cheese", ingredient);
    }

    @Test
    public void testPizzaWithAllIngredientsGetCost() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new AdditionalCheeseDecorator(theOrder);
        theOrder = new BaconDecorator(theOrder);
        theOrder = new CornDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        theOrder = new PepperDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);

        //When
        BigDecimal theCost = theOrder.getCost();
        //Then
        assertEquals(new BigDecimal(37), theCost);
    }

    @Test
    public void testPizzaWithAllIngredientsGetIngredient() {
        //Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new AdditionalCheeseDecorator(theOrder);
        theOrder = new BaconDecorator(theOrder);
        theOrder = new CornDecorator(theOrder);
        theOrder = new OlivesDecorator(theOrder);
        theOrder = new PepperDecorator(theOrder);
        theOrder = new SalamiDecorator(theOrder);
        //When
        String ingredient = theOrder.getIngredient();
        //Then
        assertEquals("Ingredients of pizza: tomato sauce, cheese, " +
                "additional cheese, bacon, corn, olives, pepper, salami", ingredient);
    }
}
