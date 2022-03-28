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
				UUID flightID = UUID.fromString((String)flightJSON.get(FLIGHT_ID));
                String departureCity = (String)flightJSON.get(DEPARTURE_CITY);
                String departAirport = (String)flightJSON.get(DEPART_AIRPORT);
                String arrivalAirport = (String)flightJSON.get(ARRIVAL_AIRPORT);
                String destination = (String)flightJSON.get(DESTINATION);
                int departureTime = (Integer)flightJSON.get(DEPARTURE_TIME);
                int arrivalTime = (Integer)flightJSON.get(ARRIVAL_TIME);
                Date departDate = (Date)flightJSON.get(DEPARTURE_DATE);
                Date arrivDate = (Date)flightJSON.get(ARRIVAL_DATE);
                FlightType flightType = (FlightType)flightJSON.get(FLIGHT_TYPE);
                Airline airline = (Airline)flightJSON.get(AIRLINE);
                int price = (Integer)flightJSON.get(PRICE);
                ArrayList<Seat> seats = null;
				
				flights.add(new Flight(flightID, destination, departureCity, departDate, arrivDate, departAirport, arrivalAirport,
                flightType, airline, price, departureTime, arrivalTime));
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
