import java.io.FileReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Enums.Airline;
import Enums.FlightType;

public class DataLoader extends DataContatnts {
    
    public DataLoader() {
        
    }

    public static ArrayList<Flight> loadFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
			FileReader reader = new FileReader(FLIGHT_FILE_NAME);
			//JSONParser parser = new JSONParser();
			JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < flightsJSON.size(); i++) {
				JSONObject flightJSON = (JSONObject)flightsJSON.get(i);
				UUID flightID = (UUID)flightJSON.get(FLIGHT_ID);
                String departAirport = (String)flightJSON.get(DEPART_AIRPORT);
                String arrivalAirport = (String)flightJSON.get(ARRIVAL_AIRPORT);
                String destination = (String)flightJSON.get(DESTINATION);
                String departureTime = (String)flightJSON.get(DEPARTURE_TIME);
                String arrivalTime = (String)flightJSON.get(ARRIVAL_TIME);
                Date departDate = (Date)flightJSON.get(DEPARTURE_DATE);
                Date arrivDate = (Date)flightJSON.get(ARRIVAL_DATE);
                Boolean smoking = (Boolean)flightJSON.get(SMOKING);
                FlightType flightType = (FlightType)flightJSON.get(FLIGHT_TYPE);
                Airline airline = (Airline)flightJSON.get(AIRLINE);
                String[][] seats = null;
				
				flights.add(new Flight(flightID, destination, departDate, arrivDate, departAirport, arrivalAirport, smoking,
                flightType, seats, airline));
			}
			
			return flights;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

    public ArrayList<Hotel> getHotel() {
        return null;
    }


}
