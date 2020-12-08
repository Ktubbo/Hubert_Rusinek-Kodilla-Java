package com.kodilla.stream.world;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){
        //Given

        Continent africa = new Continent();
        Country kongo = new Country();
        kongo.peopleQuantity = new BigDecimal("84074562");
        Country angola = new Country();
        angola.peopleQuantity = new BigDecimal("30814567");
        Country nambia = new Country();
        nambia.peopleQuantity = new BigDecimal("2448125");
        africa.countryList.add(kongo);
        africa.countryList.add(angola);
        africa.countryList.add(nambia);

        Continent europe = new Continent();
        Country france = new Country();
        france.peopleQuantity = new BigDecimal("66994264");
        Country greatBritain = new Country();
        greatBritain.peopleQuantity = new BigDecimal("66651489");
        Country spain = new Country();
        spain.peopleQuantity = new BigDecimal("46947568");
        europe.countryList.add(france);
        europe.countryList.add(greatBritain);
        europe.countryList.add(spain);

        Continent asia = new Continent();
        Country china = new Country();
        china.peopleQuantity = new BigDecimal("1393456789");
        Country india = new Country();
        india.peopleQuantity = new BigDecimal("1353456489");
        Country japan = new Country();
        japan.peopleQuantity = new BigDecimal("126548975");
        europe.countryList.add(china);
        europe.countryList.add(india);
        europe.countryList.add(japan);

        List<Continent> continents = new ArrayList<>();
        continents.add(africa);
        continents.add(europe);
        continents.add(asia);

        World world = new World();
        world.continentList = continents;

        //When
        BigDecimal result = world.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("3171392828");
        Assertions.assertEquals(result,expectedResult);
    }
}
