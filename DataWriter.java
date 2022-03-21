import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataContatnts{

    public void newUser(User user) {
        
    }

    public static void saveFlight() {
        Flights flights = Flights.getInstance();
        ArrayList<Flight> flightList = flights.getFlights();
        JSONArray jsonFlights = new JSONArray();

        for(int i=0; i< flightList.size(); i++) {
			jsonFlights.add(getFlightJSON(flightList.get(i)));
		}

        try (FileWriter file = new FileWriter(FLIGHT_FILE_NAME)) {
 
            file.write(jsonFlights.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static JSONObject getFlightJSON(Flight flight) {
		JSONObject flightDetails = new JSONObject();
		flightDetails.put(FLIGHT_ID, flight.getUuid());
		flightDetails.put(DEPART_AIRPORT, flight.getDepartureAirport());
		flightDetails.put(ARRIVAL_AIRPORT, flight.getArrivalAirport());
        flightDetails.put(DESTINATION, flight.getDestination());
        flightDetails.put(DEPARTURE_DATE, flight.getDepartureDate());
        flightDetails.put(ARRIVAL_DATE, flight.getArrivalDate());
        flightDetails.put(SMOKING, flight.getSmoking());
        flightDetails.put(FLIGHT_TYPE, flight.getFlightType());
        flightDetails.put(AIRLINE, flight.getAirline());
        //flightDetails.put(SEATS, flight.getSeat());
        
        return flightDetails;
	}

    public void newHotel(Hotel hotel) {

    }

}
