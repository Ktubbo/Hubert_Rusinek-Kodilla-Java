package com.kodilla.good.patterns.challenges.food2door;

import com.kodilla.good.patterns.challenges.food2door.extrafoodshop.ExtraFoodShop;
import com.kodilla.good.patterns.challenges.food2door.glutenfreeshop.GlutenFreeShop;
import com.kodilla.good.patterns.challenges.food2door.healthyshop.HealthyShop;

public class Food2DoorRunner {

    public static void main(String[] args){

        ExtraFoodShop extraFoodShop = new ExtraFoodShop();
        HealthyShop healthyShop = new HealthyShop();
        GlutenFreeShop glutenFreeShop = new GlutenFreeShop();

        Order order = new Order(new Supplier("Mariusz","Kuryła",1110111),999.9,"flour (kg)");
        extraFoodShop.process(order);
        healthyShop.process(order);
        glutenFreeShop.process(order);

    }
}
