package com.kodilla.good.patterns.challenges.flightapp;

import java.util.*;

class FlightMap {

    private List<Flight> flightList = new ArrayList<>();

    public FlightMap() {

        Airport paris = new Airport("Paris", "PAR");
        Airport warsaw = new Airport("Warsaw", "WAR");
        Airport berlin = new Airport("Berlin", "BER");
        Airport budapest = new Airport("Budapest", "BUD");
        Airport athens = new Airport("Athens", "ATH");
        Airport oslo = new Airport("Oslo", "OSL");
        Airport barcelona = new Airport("Barcelona", "BAR");
        Airport rome = new Airport("Rome", "ROM");

        flightList.add(new Flight(paris, warsaw));
        flightList.add(new Flight(warsaw, paris));

        flightList.add(new Flight(paris, barcelona));
        flightList.add(new Flight(barcelona, paris));

        flightList.add(new Flight(barcelona, rome));
        flightList.add(new Flight(rome, barcelona));

        flightList.add(new Flight(athens, rome));
        flightList.add(new Flight(rome, athens));

        flightList.add(new Flight(budapest, berlin));
        flightList.add(new Flight(paris, budapest));

        flightList.add(new Flight(berlin, warsaw));
        flightList.add(new Flight(warsaw, berlin));

        flightList.add(new Flight(oslo, warsaw));
        flightList.add(new Flight(warsaw, oslo));

        flightList.add(new Flight(berlin, oslo));
        flightList.add(new Flight(oslo, berlin));

        flightList.add(new Flight(athens, warsaw));
        flightList.add(new Flight(warsaw, athens));

        flightList.add(new Flight(paris, rome));
        flightList.add(new Flight(rome, paris));

        flightList.add(new Flight(budapest, barcelona));
        flightList.add(new Flight(barcelona, budapest));

    }

    public List<Flight> getFlightList() {
        return flightList;
    }
}
