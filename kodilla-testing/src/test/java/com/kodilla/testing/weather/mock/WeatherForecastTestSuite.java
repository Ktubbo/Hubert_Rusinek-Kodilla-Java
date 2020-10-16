package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.when;

@DisplayName("TDD: WeatherForecast Test Suite")
@ExtendWith(MockitoExtension.class)
class WeatherForecastTestSuite {

    private static int testCounter = 0;

    @Mock
    private Temperatures temperaturesMock;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEachTest(){
        Map<String, Double> temperaturesMap = new HashMap<>();
        temperaturesMap.put("Rzeszow", 25.5);
        temperaturesMap.put("Krakow", 26.2);
        temperaturesMap.put("Wroclaw", 24.8);
        temperaturesMap.put("Warszawa", 25.2);
        temperaturesMap.put("Gdansk", 26.1);
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);

        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @DisplayName("Test: Calculate Forecast with Mock")
    @Test
    void testCalculateForecastWithMock() {
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        int quantityOfSensors = weatherForecast.calculateForecast().size();

        //Then
        Assertions.assertEquals(5, quantityOfSensors);
    }

    @DisplayName("Test: Calculate Mean Temperature with Mock")
    @Test
    void testCalculateMeanTemperatureWithMock(){
        //Given
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //When
        double sumOfTemperatures = 0;
        for (Map.Entry<String, Double> temperatures : temperaturesMock.getTemperatures().entrySet()) {
            sumOfTemperatures = sumOfTemperatures + temperatures.getValue();
        }
        double meanOfTemperatures = sumOfTemperatures/temperaturesMock.getTemperatures().size();

        //Then
        Assertions.assertEquals(25.56,meanOfTemperatures);
    }

    @DisplayName("Test: Calculate Median of Temperatures with Mock")
    @Test
    void testCalculateMedianTemperatureWithMock(){
        //Given
        List<Double> listOfTemp = new ArrayList();
        for (Map.Entry<String, Double> m : temperaturesMock.getTemperatures().entrySet()) {
            listOfTemp.add(m.getValue());
        }
        Collections.sort(listOfTemp);
        double median=0;

        //When
        if(listOfTemp.size() % 2 == 0){
            int element1 = listOfTemp.size()/2;
            int element2 = (listOfTemp.size()/2) + 1;
            median = (((double)listOfTemp.get(element1) + (double)listOfTemp.get(element2))/2)-1;
        } else {
            int midElement = (listOfTemp.size()+1)/2;
            median = (double)listOfTemp.get(midElement-1);
        }

        //Then
        Assertions.assertEquals(25.5,median);
    }
}