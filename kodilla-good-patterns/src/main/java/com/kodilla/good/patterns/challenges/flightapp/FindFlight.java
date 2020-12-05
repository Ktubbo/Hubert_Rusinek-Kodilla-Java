package com.kodilla.good.patterns.challenges.flightapp;

import java.awt.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class FindFlight {

    FlightMap flights = new FlightMap();
    Map<Integer,Flight> flightMap = flights.getFlightMap();

    public void findFrom(Airport a) {

        System.out.println("\nFind from: \n");
        List<Map.Entry<Integer,Flight>> flightList = flightMap.entrySet()
                .stream()
                .filter(e -> e.getValue().getFrom().equals(a))
                .collect(Collectors.toList());
        if(!flightList.isEmpty()){
            for(Map.Entry entry: flightList){
                System.out.println(flightMap.get(entry.getKey()));
            }
        } else {
            System.out.println("There is no such flight.");
        }
    }

    public void findTo(Airport a) {
        System.out.println("\nFind to: \n");
        List<Map.Entry<Integer,Flight>> flightList = flightMap.entrySet()
                .stream()
                .filter(e -> e.getValue().getTo().equals(a))
                .collect(Collectors.toList());
        if(!flightList.isEmpty()){
            for(Map.Entry entry: flightList){
                System.out.println(flightMap.get(entry.getKey()));
            }
        } else {
            System.out.println("There is no such flight.");
        }
    }

    public void findThrough(Airport a, Airport b, Airport c) {

        System.out.println("\nFind through: \n");

        List<Map.Entry<Integer,Flight>> flightListA =
                flightMap.entrySet()
                .stream()
                .filter(e->e.getValue().getFrom().equals(a))
                .filter(e->e.getValue().getTo().equals(b))
                .collect(Collectors.toList());

        List<Map.Entry<Integer,Flight>> flightListB =
                flightMap.entrySet()
                .stream()
                .filter(e->e.getValue().getFrom().equals(b))
                .filter(e->e.getValue().getTo().equals(c))
                .collect(Collectors.toList());

        if(!(flightListA.isEmpty() || flightListB.isEmpty())){

            for(Map.Entry entry: flightListA){
                System.out.println(flightMap.get(entry.getKey()));
            }

            for(Map.Entry entry: flightListB){
                System.out.println(flightMap.get(entry.getKey()));
            }

        } else {
            System.out.println("There is no such flight.");
        }

    }
}
