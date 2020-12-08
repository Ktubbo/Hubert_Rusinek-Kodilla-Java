package com.kodilla.good.patterns.challenges.flightapp;

import java.util.*;

class FlightMap {

    private Set<Flight> flightSet = new HashSet<>();

    public FlightMap() {

        Airport paris = new Airport("Paris", "PAR");
        Airport warsaw = new Airport("Warsaw", "WAR");
        Airport berlin = new Airport("Berlin", "BER");
        Airport budapest = new Airport("Budapest", "BUD");
        Airport athens = new Airport("Athens", "ATH");
        Airport oslo = new Airport("Oslo", "OSL");
        Airport barcelona = new Airport("Barcelona", "BAR");
        Airport rome = new Airport("Rome", "ROM");

        flightSet.add(new Flight(paris, warsaw));
        flightSet.add(new Flight(warsaw, paris));

        flightSet.add(new Flight(paris, barcelona));
        flightSet.add(new Flight(barcelona, paris));

        flightSet.add(new Flight(barcelona, rome));
        flightSet.add(new Flight(rome, barcelona));

        flightSet.add(new Flight(athens, rome));
        flightSet.add(new Flight(rome, athens));

        flightSet.add(new Flight(budapest, berlin));
        flightSet.add(new Flight(paris, budapest));

        flightSet.add(new Flight(berlin, warsaw));
        flightSet.add(new Flight(warsaw, berlin));

        flightSet.add(new Flight(oslo, warsaw));
        flightSet.add(new Flight(warsaw, oslo));

        flightSet.add(new Flight(berlin, oslo));
        flightSet.add(new Flight(oslo, berlin));

        flightSet.add(new Flight(athens, warsaw));
        flightSet.add(new Flight(warsaw, athens));

        flightSet.add(new Flight(paris, rome));
        flightSet.add(new Flight(rome, paris));

        flightSet.add(new Flight(budapest, barcelona));
        flightSet.add(new Flight(barcelona, budapest));

    }

    public Set<Flight> getFlightSet() {
        return flightSet;
    }
}
