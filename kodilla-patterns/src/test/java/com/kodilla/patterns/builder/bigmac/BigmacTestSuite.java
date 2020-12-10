package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacBuilder() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("sesame")
                .burgers(2)
                .ingredient("bacon")
                .ingredient("onion")
                .ingredient("cheese")
                .sauce("BBQ")
                .build();
        System.out.println(bigmac);
        //When
        int howManyIngredients = bigmac.getIngredients().size();

        //Then
        assertEquals(3,howManyIngredients);
    }
}
