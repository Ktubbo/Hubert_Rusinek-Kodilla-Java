package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {

    @BeforeEach
    public void before(){
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after(){
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @DisplayName("when create oddNumbersExterminator with empty list, " +
            "then exterminate should return empty list")

    @Test
    void testOddNumbersExterminatorEmptyList(){

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        Integer arrayNumbers[] = new Integer[]{};
        List numbers = Arrays.asList(arrayNumbers);

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing exterminated list: " + numbers);
        //Then

        Integer arrayExpectedResults[] = new Integer[]{};
        List expectedResult = Arrays.asList(arrayExpectedResults);

        System.out.println("Expected list: " + expectedResult);
        Assertions.assertEquals(expectedResult, result);
    }

    @DisplayName("when create oddNumbersExterminator with even and odd numbers list, " +
            "then exterminate should return only even numbers list")


    @Test
    void testOddNumbersExterminatorNormalList() {

        //Given
        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();

        Integer arrayNumbers[] = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List numbers = Arrays.asList(arrayNumbers);

        //When
        List<Integer> result = oddNumbersExterminator.exterminate(numbers);
        System.out.println("Testing exterminated list: " + result);

        //Then
        Integer arrayExpectedResults[] = new Integer[]{2,4,6,8,10};
        List expectedResult = Arrays.asList(arrayExpectedResults);

        System.out.println("Expected list: " + expectedResult);
        Assertions.assertEquals(expectedResult, result);
    }
}