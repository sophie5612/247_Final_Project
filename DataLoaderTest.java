import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import Enums.Airline;
import Enums.FlightType;

public class DataLoaderTest {
	ArrayList<User> userList = Users.getUsers();
    ArrayList<Flight> flightList = Flights.getFlights();
    ArrayList<Hotel> hotelList = Hotels.getHotels();

    @BeforeEach
    public void setup() {
        userList.clear();
        userList.add(new User(UUID.randomUUID(), "bob", "02-01-1999", "bobTheMan", "bobsPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
        userList.add(new User(UUID.randomUUID(), "man", "03-05-1989", "manIsBob", "mansPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
        DataWriter.saveUsers();
        flightList.clear();
        flightList.add(new Flight(UUID.randomUUID(), "Seattle", "Columbia", "03-15-2020", "03=15=2020", "SEA", "COL", FlightType.ONE_WAY, Airline.SPIRIT, 100, 200, 300, new ArrayList<Seat>(), 0));
        flightList.add(new Flight(UUID.randomUUID(), "Columbia", "Seattle", "03-15-2020", "03=15=2020", "SEA", "COL", FlightType.ONE_WAY, Airline.SPIRIT, 100, 200, 300, new ArrayList<Seat>(), 0));
        DataWriter.saveFlight();
        hotelList.clear();
        hotelList.add(new Hotel(UUID.randomUUID(), "Hilton", true, 100, 4.2, new ArrayList<Room>(), "Detroit"));
        hotelList.add(new Hotel(UUID.randomUUID(), "Marriot", false, 120, 2.4, new ArrayList<Room>(), "Detroit"));
        DataWriter.saveHotels();
    }

    @AfterEach
    public void tearDown() {
        Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
        Flights.getInstance().getFlights().clear();
		DataWriter.saveFlight();
        Hotels.getInstance().getHotels().clear();
		DataWriter.saveHotels();
    }

    @Test
    public void testGetUsersSize() {
        userList = DataLoader.loadUsers();
        assertEquals(2, userList.size());
    }

    @Test
    public void teestGetUsersSizeZero() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, userList.size());
    }

    @Test
    public void testGetUserFirstUserName() {
        userList = DataLoader.loadUsers();
        assertEquals("bobTheMan", userList.get(0).getUserName());
    }

    @Test
    public void testGetUserLastUserName() {
        userList = DataLoader.loadUsers();
        assertEquals("bobTheMan", userList.get(1).getUserName());
    }

    @Test
    public void testGetFlightsSize() {
        flightList = DataLoader.loadFlights();
        assertEquals(2, flightList.size());
    }

    @Test
    public void testGetFlightSizeZero() {
        Flights.getInstance().getFlights().clear();
        DataWriter.saveFlight();
        assertEquals(0, flightList.size());
    }

    @Test
    public void testGetFlightFirstCity() {
        flightList = DataLoader.loadFlights();
        assertEquals("Seattle", flightList.get(0).getArrivalAirport());
    }

    @Test
    public void testGetUserLastCity() {
        flightList = DataLoader.loadFlights();
        assertEquals("Columbia", flightList.get(1).getArrivalAirport());
    }

    @Test
    public void testGetHotelSize() {
        hotelList = DataLoader.loadHotels();
        assertEquals(2, hotelList.size());
    }

    @Test
    public void testGetHotelSizeZero() {
        Hotels.getInstance().getHotels().clear();
        DataWriter.saveHotels();
        assertEquals(0, hotelList.size());
    }

    @Test
    public void testGetHotelFirstName() {
        hotelList = DataLoader.loadHotels();
        assertEquals("Hilton", hotelList.get(0).getName());
    }

    @Test
    public void testGetHotelLastName() {
        hotelList = DataLoader.loadHotels();
        assertEquals("Marriot", hotelList.get(1).getName());
    }

}
