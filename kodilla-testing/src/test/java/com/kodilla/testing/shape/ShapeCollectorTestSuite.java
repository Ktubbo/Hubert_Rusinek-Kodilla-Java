package com.kodilla.testing.shape;

import org.testng.annotations.Test;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Test Suite")
class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    void testAddFigure(){
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Triangle triangle = new Triangle(10,15);

        //When
        shapeCollector.addFigure(triangle);

        //Then



    }

    @Test
    void testRemoveFigure(){}

    @Test
    void testGetFigure(){}

    @Test
    void testShowFigure(){}




}