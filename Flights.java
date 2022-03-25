import java.sql.Date;
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

    public ArrayList<Flight> getFlights() {
        return flightList;
    }

    public void addFlight(UUID ID, String destinationCity, Date departDate, Date arrivalDate, String departAirport, String arrivalAirport, boolean smoking,
    FlightType flightType, String[][] seats, Airline airline) {
        flightList.add(new Flight(ID, destinationCity, departDate, arrivalDate, departAirport, arrivalAirport, smoking, flightType, seats, airline));
    }

    public void logout() {
        DataWriter.saveFlight();
    }
}
