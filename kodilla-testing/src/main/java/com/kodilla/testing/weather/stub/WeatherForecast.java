package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures){
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature :
                temperatures.getTemperatures().entrySet()){

            // adding 1 celsius degree to current value
            // as a temporary weather forecast
            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateMeanTemperature(Map<String, Double> temperatureMap){

        double sumOfTemperatures = 0;
        for (Map.Entry<String, Double> temperatures : temperatureMap.entrySet()) {
            sumOfTemperatures = sumOfTemperatures + temperatures.getValue();
        }
        double meanOfTemperatures = sumOfTemperatures/temperatureMap.size();

        return meanOfTemperatures;
    }

    public double calculateMedianOfTemperature(Map<String, Double> temperatureMap){

        List<Double> listOfTemp = new ArrayList();
        for (Map.Entry<String, Double> m : temperatureMap.entrySet()) {
            listOfTemp.add(m.getValue());
        }
        Collections.sort(listOfTemp);
        double median=0;

        if(listOfTemp.size() % 2 == 0){
            int element1 = listOfTemp.size()/2;
            int element2 = (listOfTemp.size()/2) + 1;
            median = (((double)listOfTemp.get(element1) + (double)listOfTemp.get(element2))/2)-1;
        } else {
            int midElement = (listOfTemp.size()+1)/2;
            median = (double)listOfTemp.get(midElement-1);
        }
        return median;
    }

}