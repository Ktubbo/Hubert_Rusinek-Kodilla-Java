package com.kodilla.stream.array;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class ArrayOperationsTestSuite {

    @Test
    public void testGetAverage(){
        //Given
        int [] numbers = {5,60,80,69,62,53,84,2,27,9,2,45,74,96,14,38,91,38,23,31};
        double result = 45.15;

        //When
        double expectedResult = ArrayOperations.getAverage(numbers);

        //Then
        Assertions.assertEquals(result,expectedResult);
    }

}
