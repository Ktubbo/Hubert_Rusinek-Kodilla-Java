package com.kodilla.good.patterns.challenges.flightapp;

public class FlightRunner {

    public static void main(String[] args) {

        FlightMap flightMap = new FlightMap();
        Airport barcelona = new Airport("Barcelona","BAR");
        Airport warsaw = new Airport("Warsaw", "WAR");
        Airport paris = new Airport("Paris","PAR");

        FindFlight findFlight = new FindFlight();
        findFlight.findFrom(barcelona);
        findFlight.findTo(warsaw);
        findFlight.findThrough(barcelona,paris,warsaw);

    }
}
