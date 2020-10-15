package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Test Suite")
public class ShapeCollectorTestSuite{

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

    @Nested
    @DisplayName("Test of removes")
    class TestRemoves{

        @Test
        void testRemoveFigureNotExisting(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(10);
            //When
            boolean result = shapeCollector.removeFigure(square);
            //Then
            Assertions.assertFalse(result);
        }

        @Test
        void testRemoveFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Square square = new Square(10);
            //When
            shapeCollector.addFigure(square);
            boolean result = shapeCollector.removeFigure(square);
            //Then
            Assertions.assertTrue(result);
            Assertions.assertEquals(0,shapeCollector.getFiguresQuantity());
        }


    }

    @Nested
    @DisplayName("Other tests")
    class OtherTests{

        @Test
        void testAddFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Triangle triangle = new Triangle(10,15);

            //When
            shapeCollector.addFigure(triangle);

            //Then
            Assertions.assertEquals(1, shapeCollector.getFiguresQuantity());

        }


        @Test
        void testGetFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(5);
            //When
            shapeCollector.addFigure(circle);
            //Then
            Assertions.assertEquals(circle, shapeCollector.getFigure(0));
        }

        @Test
        void testShowFigure(){
            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Circle circle = new Circle(5);
            Square square = new Square(10);
            Triangle triangle = new Triangle(10,15);

            //When
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(triangle);
            String result = circle.toString()+ ", " +square.toString()+ ", " +triangle.toString() + ", ";

            //Then
            Assertions.assertEquals(result, shapeCollector.showFigures());
        }

    }

}