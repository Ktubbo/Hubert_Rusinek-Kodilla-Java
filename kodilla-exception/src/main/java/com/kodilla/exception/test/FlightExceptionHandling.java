package com.kodilla.exception.test;

public class FlightExceptionHandling {

    public static void main(String[] args){

        Flight flightWWAtoPRS = new Flight("Warsaw","Paris");
        Flight flightWWAtoBCL = new Flight("Warsaw","Barcelona");
        FlightFinder flightFinder = new FlightFinder();
        flightFinder.setEntryFlightMap("Warsaw",true);
        flightFinder.setEntryFlightMap("Paris",false);


        try{ flightFinder.findFlight(flightWWAtoPRS); }
        catch(RouteNotFoundException e){
            System.out.println("Some of these airports are not on the list.");
        }
        finally {
            System.out.println("Remember to check our current airport list.");
        }

        try{ flightFinder.findFlight(flightWWAtoBCL);}
        catch(RouteNotFoundException e){
            System.out.println("Some of these airports are not on the list.");
        }
        finally {
            System.out.println("Remember to check our current airport list.");
        }

    }
}
