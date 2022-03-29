import java.util.ArrayList;
import java.util.UUID;
import Enums.Airline;
import Enums.FlightType;


public class Flights {

    private static Flights flights = null;
    private static ArrayList<Flight> flightList;

    private Flights() {
        flightList = DataLoader.loadFlights();
    }

    public static Flights getInstance() {
        if (flights == null) {
            flights = new Flights();
        }

        return flights;
    }

    public static ArrayList<Flight> getFlights() {
        return flightList;
    }

    public void addFlight(UUID ID, String destinationCity, String departureCity, String departDate, String arrivalDate, String departAirport, String arrivalAirport,
    FlightType flightType, Airline airline, double price, int departTime, int arrivalTime, ArrayList<Seat> seats, int stops) {
        flightList.add(new Flight(ID, destinationCity, departureCity, departDate, arrivalDate, departAirport, arrivalAirport,
        flightType, airline, price, departTime, arrivalTime, seats, stops));
    }

    public static void logout() {
        DataWriter.saveFlight();
    }
}
