// Austin test this

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Enums.Airline;
import Enums.FlightType;

public class DataLoader extends DataContants {

    public static ArrayList<Flight> loadFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
			FileReader reader = new FileReader("JSON/Flight.JSON");
			JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < flightsJSON.size(); i++) {
				JSONObject flightJSON = (JSONObject)flightsJSON.get(i);
				UUID flightID = UUID.fromString((String)flightJSON.get(FLIGHT_ID));
                String departureCity = (String)flightJSON.get(DEPARTURE_CITY);
                String departAirport = (String)flightJSON.get(DEPART_AIRPORT);
                String arrivalAirport = (String)flightJSON.get(ARRIVAL_AIRPORT);
                String destination = (String)flightJSON.get(DESTINATION);
                int departureTime = ((Long)flightJSON.get(DEPARTURE_TIME)).intValue();
                int arrivalTime = ((Long)flightJSON.get(ARRIVAL_TIME)).intValue();
                String departDate = (String)flightJSON.get(DEPARTURE_DATE);
                String arrivDate = (String)flightJSON.get(ARRIVAL_DATE);
                FlightType flightType = FlightType.valueOf((String)flightJSON.get(FLIGHT_TYPE));
                Airline airline = Airline.valueOf((String)flightJSON.get(AIRLINE));
                Double price = (Double)flightJSON.get(PRICE);
                int stops = ((Long)flightJSON.get(STOPS)).intValue();
                // Seats!
                JSONArray seatArr = (JSONArray)flightJSON.get(SEATS);
                ArrayList<Seat> seatsList = new ArrayList<Seat>();
                for (int j = 0; j < seatArr.size(); j++) {
                    JSONObject seatDetails = (JSONObject)seatArr.get(j);
                    int col = ((Long)seatDetails.get(COL)).intValue();
                    int row = ((Long)seatDetails.get(ROW)).intValue();
                    boolean isAvailable = (boolean)seatDetails.get(AVAILABILITY);
                    UUID uuid = UUID.fromString((String)seatDetails.get(SEAT_ID));
                    seatsList.add(new Seat(row, col, uuid, isAvailable));
                }
				
				flights.add(new Flight(flightID, destination, departureCity, departDate, arrivDate, departAirport, arrivalAirport,
                flightType, airline, price, departureTime, arrivalTime, seatsList, stops));
			}
			
			return flights;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

    public static ArrayList<Hotel> loadHotels() {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();

        try {
			FileReader reader = new FileReader("JSON/Hotel.JSON");
			JSONArray hotelsJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < hotelsJSON.size(); i++) {
				JSONObject hotelJSON = (JSONObject)hotelsJSON.get(i); 
                UUID hotelID = UUID.fromString((String)hotelJSON.get(HOTEL_ID));
                String namOfHotel = (String)hotelJSON.get(NAME_OF_HOTEL);
                Boolean hasPool = (Boolean)hotelJSON.get(HAS_POOL);
                Double price = (Double)hotelJSON.get(HOTEL_PRICE);
                Double rating = (Double)hotelJSON.get(RATING);
                String city = (String)hotelJSON.get(CITY);
                // Rooms!
                ArrayList<Room> roomList = new ArrayList<Room>();
                JSONArray hotelArr = (JSONArray)hotelJSON.get(ROOMS);
                for (int j = 0; j < hotelArr.size(); j++) {
                    JSONObject roomDetails = (JSONObject)hotelArr.get(j);
                    UUID uuid = UUID.fromString((String)roomDetails.get(ROOM_ID));
                    int numOfBeds = ((Long)roomDetails.get(NUM_OF_BEDS)).intValue();
                    boolean smoking = (boolean)roomDetails.get(SMOKING);
                    int floor = ((Long)roomDetails.get(FLOOR)).intValue();
                    int rooomNumber = ((Long)roomDetails.get(ROOM_NUMBER)).intValue();
                    ArrayList<String> bookedDates = (ArrayList<String>) roomDetails.get(BOOKED_DATES);
                    roomList.add(new Room(floor, rooomNumber, uuid, numOfBeds, smoking, bookedDates));
                }
				hotels.add(new Hotel(hotelID, namOfHotel, hasPool, price, rating, roomList, city));
			}
			
			return hotels;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }

    public static ArrayList<User> loadUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
			FileReader reader = new FileReader("JSON/User.JSON");
			JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
			
			for(int i=0; i < usersJSON.size(); i++) {
				JSONObject userJSON = (JSONObject)usersJSON.get(i); 
                UUID userID = UUID.fromString((String)userJSON.get(USER_ID));
                String name = (String)userJSON.get(USER_NAME);
                String DOB = (String)userJSON.get(USER_DOB);
                String userName = (String)userJSON.get(USER_USERNAME);
                String password = (String)userJSON.get(USER_PASSWORD);
                ArrayList<String> flightHistory = (ArrayList<String>)userJSON.get(USER_FLIGHT_HISTORY);
                ArrayList<String> hotelHistory = (ArrayList<String>)userJSON.get(USER_HOTEL_HISTORY);
                // Family members
                ArrayList<FamilyMember> famList = new ArrayList<FamilyMember>();
                JSONArray userArr = (JSONArray)userJSON.get(USER_FAMILY_LIST);
                for (int j = 0; j < userArr.size(); j++) {
                    JSONObject userDetails = (JSONObject)userArr.get(j);
                    UUID uuid = UUID.fromString((String)userDetails.get(FAMILY_UUID));
                    String famName = (String)userDetails.get(FAMILY_NAME);
                    String famDOB = (String)userDetails.get(FAMILY_DOB);
                    famList.add(new FamilyMember(uuid, famName, famDOB));
                }
                users.add(new User(userID, name, DOB, userName, password, flightHistory, hotelHistory, famList));
            }
            return users;

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
    }


}
