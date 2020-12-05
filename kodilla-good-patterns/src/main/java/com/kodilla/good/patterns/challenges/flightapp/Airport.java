package com.kodilla.good.patterns.challenges.flightapp;

import java.util.*;
import java.lang.*;


class Airport {

    private String name;
    private String uniqueID;

    public Airport(String name, String uniqueID) {
        this.name = name;
        this.uniqueID = uniqueID;
    }

    public String getName() { return name; }
    public String getUniqueID() { return uniqueID; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name) &&
                Objects.equals(uniqueID, airport.uniqueID);
    }


    @Override
    public String toString() {
        return name;
    }
}



