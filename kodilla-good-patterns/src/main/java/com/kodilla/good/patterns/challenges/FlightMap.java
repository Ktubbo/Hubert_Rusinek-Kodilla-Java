package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.Map;

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

        flightMap.put(new Flight(paris, warsaw).hashCode(), new Flight(paris, warsaw));
        flightMap.put(new Flight(warsaw, paris).hashCode(), new Flight(warsaw, paris));

        flightMap.put(new Flight(paris, barcelona).hashCode(), new Flight(paris, barcelona));
        flightMap.put(new Flight(barcelona, paris).hashCode(), new Flight(barcelona, paris));

        flightMap.put(new Flight(barcelona, rome).hashCode(), new Flight(barcelona, rome));
        flightMap.put(new Flight(rome, barcelona).hashCode(), new Flight(rome, barcelona));

        flightMap.put(new Flight(athens, rome).hashCode(), new Flight(athens, rome));
        flightMap.put(new Flight(rome, athens).hashCode(), new Flight(rome, athens));

        flightMap.put(new Flight(budapest, berlin).hashCode(), new Flight(budapest, berlin));
        flightMap.put(new Flight(berlin, budapest).hashCode(), new Flight(paris, budapest));

        flightMap.put(new Flight(berlin, warsaw).hashCode(), new Flight(berlin, warsaw));
        flightMap.put(new Flight(warsaw, berlin).hashCode(), new Flight(warsaw, berlin));

        flightMap.put(new Flight(oslo, warsaw).hashCode(), new Flight(oslo, warsaw));
        flightMap.put(new Flight(warsaw, oslo).hashCode(), new Flight(warsaw, oslo));

        flightMap.put(new Flight(berlin, oslo).hashCode(), new Flight(berlin, oslo));
        flightMap.put(new Flight(oslo, berlin).hashCode(), new Flight(oslo, berlin));

        flightMap.put(new Flight(athens, warsaw).hashCode(), new Flight(athens, warsaw));
        flightMap.put(new Flight(warsaw, athens).hashCode(), new Flight(warsaw, athens));

        flightMap.put(new Flight(paris, rome).hashCode(), new Flight(paris, rome));
        flightMap.put(new Flight(rome, paris).hashCode(), new Flight(rome, paris));

        flightMap.put(new Flight(budapest, barcelona).hashCode(), new Flight(budapest, barcelona));
        flightMap.put(new Flight(barcelona, budapest).hashCode(), new Flight(barcelona, budapest));

    }

    public void findFrom(Airport a) {
        System.out.println("\nFind from: \n");
        flightMap.entrySet()
                                                .stream()
                                                .filter(e -> e.getValue().getFrom().equals(a))
                                                .forEach(System.out::println); }

    public void findTo(Airport a) {
        System.out.println("\nFind to: \n");
        flightMap.entrySet()
            .stream()
            .filter(e -> e.getValue().getTo().equals(a))
            .forEach(System.out::println); }

    public void findThrough(Airport a, Airport b, Airport c) {

        System.out.println("\nFind through: \n");

        flightMap.entrySet()
                .stream()
                .filter(e->e.getValue().getFrom().equals(a))
                .filter(e->e.getValue().getTo().equals(b))
                .forEach(System.out::println);

        flightMap.entrySet()
                .stream()
                .filter(e->e.getValue().getFrom().equals(b))
                .filter(e->e.getValue().getTo().equals(c))
                .forEach(System.out::println);

    }

}
