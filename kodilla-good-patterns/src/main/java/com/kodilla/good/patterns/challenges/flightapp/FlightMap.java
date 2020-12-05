package com.kodilla.good.patterns.challenges.flightapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class FlightMap {

    private Map<Integer, Flight> flightMap = new HashMap<>();

    public FlightMap() {

        Airport paris = new Airport("Paris", "PAR");
        Airport warsaw = new Airport("Warsaw", "WAR");
        Airport berlin = new Airport("Berlin", "BER");
        Airport budapest = new Airport("Budapest", "BUD");
        Airport athens = new Airport("Athens", "ATH");
        Airport oslo = new Airport("Oslo", "OSL");
        Airport barcelona = new Airport("Barcelona", "BAR");
        Airport rome = new Airport("Rome", "ROM");

        flightMap.put(Objects.hash(new Flight(paris, warsaw)), new Flight(paris, warsaw));
        flightMap.put(Objects.hash(new Flight(warsaw, paris)), new Flight(warsaw, paris));

        flightMap.put(Objects.hash(new Flight(paris, barcelona)), new Flight(paris, barcelona));
        flightMap.put(Objects.hash(new Flight(barcelona, paris)), new Flight(barcelona, paris));

        flightMap.put(Objects.hash(new Flight(barcelona, rome)), new Flight(barcelona, rome));
        flightMap.put(Objects.hash(new Flight(rome, barcelona)), new Flight(rome, barcelona));

        flightMap.put(Objects.hash(new Flight(athens, rome)), new Flight(athens, rome));
        flightMap.put(Objects.hash(new Flight(rome, athens)), new Flight(rome, athens));

        flightMap.put(Objects.hash(new Flight(budapest, berlin)), new Flight(budapest, berlin));
        flightMap.put(Objects.hash(new Flight(berlin, budapest)), new Flight(paris, budapest));

        flightMap.put(Objects.hash(new Flight(berlin, warsaw)), new Flight(berlin, warsaw));
        flightMap.put(Objects.hash(new Flight(warsaw, berlin)), new Flight(warsaw, berlin));

        flightMap.put(Objects.hash(new Flight(oslo, warsaw)), new Flight(oslo, warsaw));
        flightMap.put(Objects.hash(new Flight(warsaw, oslo)), new Flight(warsaw, oslo));

        flightMap.put(Objects.hash(new Flight(berlin, oslo)), new Flight(berlin, oslo));
        flightMap.put(Objects.hash(new Flight(oslo, berlin)), new Flight(oslo, berlin));

        flightMap.put(Objects.hash(new Flight(athens, warsaw)), new Flight(athens, warsaw));
        flightMap.put(Objects.hash(new Flight(warsaw, athens)), new Flight(warsaw, athens));

        flightMap.put(Objects.hash(new Flight(paris, rome)), new Flight(paris, rome));
        flightMap.put(Objects.hash(new Flight(rome, paris)), new Flight(rome, paris));

        flightMap.put(Objects.hash(new Flight(budapest, barcelona)), new Flight(budapest, barcelona));
        flightMap.put(Objects.hash(new Flight(barcelona, budapest)), new Flight(barcelona, budapest));

    }

    public Map<Integer, Flight> getFlightMap() {
        return flightMap;
    }
}
