package com.kodilla.good.patterns.challenges;

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
    public int hashCode() {
        int a = from.getUniqueID().charAt(0);
        int b = from.getUniqueID().charAt(1);
        int c = to.getUniqueID().charAt(0);
        int d = to.getUniqueID().charAt(1);
        return a * 1000000 + b * 10000 + c * 100 + d;
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
