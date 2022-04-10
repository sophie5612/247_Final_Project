// Austin youre testing this entire class

import java.util.ArrayList;
import java.util.UUID;
import Enums.Airline;
import Enums.FlightType;
/**
 * A class that takes in multiple departures and arrivals of a given flight in order to tell the user how many stops they will
 * have to make to get to their desired location.
 */
public class ConnectedFlights {
    
    private ArrayList<Flight> connectList;
    /**
     * Default constructor for connectList.
     */
    public ConnectedFlights() {
        connectList = new ArrayList<Flight>();
    }
    /**
     * A method that takes in a flight and adds it to an arraylist of connected flight departure and arrival locations
     * to print a continuous stream.
     * @param flight
     */
    public void addFlight(Flight flight) {
        connectList.add(flight);
    }

    public void absorb(ConnectedFlights flightList) {
        for (int i = 0; i < flightList.getList().size(); i++) {
            this.connectList.add(flightList.getList().get(i));
        }
    }
    /**
     * A method that returns a new "flight" that accounts for layovers at multiple depart locations
     * @return Flight a new flight will all departure airports and the final arrival airport.
     */
    public Flight combine() {
        // 0 is first flight
        double price = 0;
        String destination = connectList.get(0).getDestination();
        String departures = "";
        int arrivalTime = connectList.get(0).getArrivalTime();
        int departTime = connectList.get(connectList.size()-1).getDepartureTime();
        String date = connectList.get(0).getDepartureDate();
        String destinationAirport = connectList.get(0).getArrivalAirport();
        String departAirport = connectList.get(connectList.size()-1).getDepartureAirport();
        int stops = 0;
        Airline airline = connectList.get(0).getAirline();
        for (int i = 0; i < connectList.size(); i++) {
            Flight temp = connectList.get(i);
            price += temp.getPrice();
            departures += temp.getDepartureCity() + " ";
            stops++;
        }
        return new Flight(UUID.randomUUID(), destination, departures, date, date, departAirport, 
        destinationAirport, FlightType.ONE_WAY, airline, price, departTime, arrivalTime, createSeats(), stops-1);
    }

    public ArrayList<Flight> getList() {
        return connectList;
    }
    /**
     * A method that creates a new ArrayList of seats for a flight
     * @return seats a new arraylsit of Seats
     */
    public static ArrayList<Seat> createSeats() {
        ArrayList<Seat> seats = new ArrayList<Seat>();
        for (int i = 0; i < 60; i++) {
            seats.add(new Seat(i/6, i%6, UUID.randomUUID(), true));
        }
        return seats;
    }

}
