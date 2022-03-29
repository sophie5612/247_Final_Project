import java.util.ArrayList;
import java.util.UUID;

import Enums.Airline;
import Enums.FlightType;

public class ConnectedFlights {
    
    private ArrayList<Flight> connectList;

    public ConnectedFlights() {
        connectList = new ArrayList<Flight>();
    }

    public void addFlight(Flight flight) {
        connectList.add(flight);
    }

    public void absorb(ConnectedFlights flightList) {
        for (int i = 0; i < flightList.getList().size(); i++) {
            this.connectList.add(flightList.getList().get(i));
        }
    }

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

    public static ArrayList<Seat> createSeats() {
        ArrayList<Seat> seats = new ArrayList<Seat>();
        for (int i = 0; i < 60; i++) {
            seats.add(new Seat(i/6, i%6, UUID.randomUUID(), true));
        }
        return seats;
    }

}
