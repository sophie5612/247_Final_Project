// Austin test this 

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataContants {

    public static void saveFlight() {
        ArrayList<Flight> flightList = Flights.getFlights();
        JSONArray jsonFlights = new JSONArray();

        for(int i=0; i< flightList.size(); i++) {
			jsonFlights.add(getFlightJSON(flightList.get(i)));
		}

        try (FileWriter file = new FileWriter("JSON/Flight.JSON")) {
 
            file.write(jsonFlights.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static JSONObject getFlightJSON(Flight flight) {
		JSONObject flightDetails = new JSONObject();
		flightDetails.put(FLIGHT_ID, flight.getUuid().toString());
		flightDetails.put(DEPART_AIRPORT, flight.getDepartureAirport());
		flightDetails.put(ARRIVAL_AIRPORT, flight.getArrivalAirport());
        flightDetails.put(AIRLINE, flight.getAirline().toString());
        flightDetails.put(DESTINATION, flight.getDestination());
        flightDetails.put(DEPARTURE_CITY, flight.getDepartureCity());
        flightDetails.put(DEPARTURE_TIME, flight.getDepartureTime());
        flightDetails.put(ARRIVAL_TIME, flight.getArrivalTime());
        flightDetails.put(DEPARTURE_DATE, flight.getDepartureDate());
        flightDetails.put(ARRIVAL_DATE, flight.getArrivalDate());
        flightDetails.put(PRICE, flight.getPrice());
        flightDetails.put(FLIGHT_TYPE, flight.getFlightType().toString());
        flightDetails.put(STOPS, flight.getStops());
        // Seats
        JSONArray seatArr = new JSONArray();
        for (int i = 0; i < flight.getSeat().size(); i++) {
            Seat temp = flight.getSeat().get(i);
            JSONObject seatDetails = new JSONObject();
            seatDetails.put(SEAT_ID, temp.getUuid().toString());
            seatDetails.put(ROW, temp.getRow());
            seatDetails.put(COL, temp.getCol());
            seatDetails.put(AVAILABILITY, temp.getIsAvailable());
            seatArr.add(seatDetails);
        }
        flightDetails.put(SEATS, seatArr);
        
        return flightDetails;
	}

    public static void saveHotels() {
        ArrayList<Hotel> hotelList = Hotels.getHotels();
        JSONArray jsonHotels = new JSONArray();

        for(int i=0; i< hotelList.size(); i++) {
			jsonHotels.add(getHotelJSON(hotelList.get(i)));
		}

        try (FileWriter file = new FileWriter("JSON/Hotel.JSON")) {
 
            file.write(jsonHotels.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static JSONObject getHotelJSON(Hotel hotel) {
		JSONObject hotelDetails = new JSONObject();
		hotelDetails.put(HOTEL_ID, hotel.getUuid().toString());
        hotelDetails.put(NAME_OF_HOTEL, hotel.getName());
        hotelDetails.put(HAS_POOL, hotel.getPool());
        hotelDetails.put(HOTEL_PRICE, hotel.getPrice());
        hotelDetails.put(RATING, hotel.getRatings());
        hotelDetails.put(CITY, hotel.getCity());
        // Rooms
        JSONArray roomArr = new JSONArray();
        for (int i = 0; i < hotel.getRooms().size(); i++) {
            Room temp = hotel.getRooms().get(i);
            JSONObject roomDetails = new JSONObject();
            roomDetails.put(ROOM_ID, temp.getUUID().toString());
            roomDetails.put(NUM_OF_BEDS, temp.getNumOfBeds());
            roomDetails.put(SMOKING, temp.getSmoking());
            roomDetails.put(BOOKED_DATES, temp.getBookedDates());
            roomDetails.put(FLOOR, temp.getFloor());
            roomDetails.put(ROOM_NUMBER, temp.getRoomNumber());
            roomArr.add(roomDetails);
        }
        hotelDetails.put(ROOMS, roomArr);
        
        return hotelDetails;
	}

    // USERS TIME
    public static void saveUsers() {
        ArrayList<User> userList = Users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for(int i=0; i< userList.size(); i++) {
			jsonUsers.add(getUserJSON(userList.get(i)));
		}

        try (FileWriter file = new FileWriter("JSON/User.JSON")) {
 
            file.write(jsonUsers.toJSONString());
            file.flush();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

    public static JSONObject getUserJSON(User user) {
		JSONObject userDetails = new JSONObject();

        userDetails.put(USER_ID, user.getUuid().toString());
        userDetails.put(USER_NAME, user.getName());
        userDetails.put(USER_DOB, user.getDOB());
        userDetails.put(USER_USERNAME, user.getUserName());
        userDetails.put(USER_PASSWORD, user.getPassword());
        userDetails.put(USER_FLIGHT_HISTORY, user.getFlightHistory());
        userDetails.put(USER_HOTEL_HISTORY, user.getHotelHistory());
        // Family Members
        JSONArray famArr = new JSONArray();
        for (int i = 0; i < user.getFamilyMembers().size(); i++) {
            FamilyMember temp = user.getFamilyMembers().get(i);
            JSONObject famDetails = new JSONObject();
            famDetails.put(FAMILY_UUID, temp.getUUID().toString());
            famDetails.put(FAMILY_NAME, temp.getName());
            famDetails.put(FAMILY_DOB, temp.getDOB());
            famArr.add(famDetails);
        }
        userDetails.put(USER_FAMILY_LIST, famArr);

        return userDetails;
    }
}
