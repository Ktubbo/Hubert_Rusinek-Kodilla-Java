package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    Map<String,Boolean> flightMap = new HashMap<>();

    public void findFlight(Flight flight) throws RouteNotFoundException{
        if(!flightMap.containsKey(flight.getArrivalAirport()) || !flightMap.containsKey(flight.getDepartureAirport())){
            throw new RouteNotFoundException();
        }

       if(flightMap.get(flight.getDepartureAirport())){
           System.out.println("You can fly from: " + flight.getDepartureAirport());
       } else {
           System.out.println("You can't fly from: " + flight.getDepartureAirport());
       }

       if(flightMap.get(flight.getArrivalAirport())){
           System.out.println("You can fly to: " + flight.getArrivalAirport());
        } else {
            System.out.println("You can't fly to: " + flight.getArrivalAirport());
        }
    }

    public void setEntryFlightMap(String airport, Boolean possibleFlight){
        flightMap.put(airport,possibleFlight);
    }
}
