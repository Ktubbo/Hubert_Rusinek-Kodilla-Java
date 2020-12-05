package com.kodilla.good.patterns.challenges.flightapp;

import java.util.Objects;

class Flight {

    private Airport from;
    private Airport to;

    public Flight(Airport from, Airport to) {
        this.from = from;
        this.to = to;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Flight: " +
                "from=" + from +
                ", to=" + to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(from, flight.from) &&
                Objects.equals(to, flight.to);
    }
}
