package com.kodilla.good.patterns.challenges.flightapp;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FindFlight {

    FlightMap flights = new FlightMap();
    Set<Flight> flightSet = flights.getFlightSet();

    public void findFrom(Airport a) {

        System.out.println("\nFind from: \n");
        List<Flight> flightList = this.flightSet.stream()
                .filter(e -> e.getFrom().equals(a))
                .collect(Collectors.toList());
        if(!flightList.isEmpty()){
            for(Flight flight: flightList){
                System.out.println(flight);
            }
        } else {
            System.out.println("There is no such flight.");
        }
    }

    public void findTo(Airport a) {
        System.out.println("\nFind to: \n");
        List<Flight> flightList = this.flightSet.stream()
                .filter(e -> e.getTo().equals(a))
                .collect(Collectors.toList());
        if(!flightList.isEmpty()){
            for(Flight flight: flightList){
                System.out.println(flight);
            }
        } else {
            System.out.println("There is no such flight.");
        }
    }

    public void findThrough(Airport a, Airport b, Airport c) {

        System.out.println("\nFind through: \n");

        List<Flight> flightListA =
                flightSet.stream()
                .filter(e->e.getFrom().equals(a))
                .filter(e->e.getTo().equals(b))
                .collect(Collectors.toList());

        List<Flight> flightListB =
                flightSet.stream()
                .filter(e->e.getFrom().equals(b))
                .filter(e->e.getTo().equals(c))
                .collect(Collectors.toList());

        if(!(flightListA.isEmpty() || flightListB.isEmpty())){

            for(Flight flight: flightListA){
                System.out.println(flight);
            }

            for(Flight flight: flightListB){
                System.out.println(flight);
            }

        } else {
            System.out.println("There is no such flight.");
        }

    }
}
