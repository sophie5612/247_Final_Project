import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.Airline;
import Enums.FlightType;

class DataWriterTest {
	private Users users = Users.getInstance();
	private ArrayList<User> userList = users.getUsers();
    private Hotels hotels = Hotels.getInstance();
    private ArrayList<Hotel> hotelList = hotels.getHotels();
    private Flights flights = Flights.getInstance();
    private ArrayList<Flight> flightList = flights.getFlights();
	
	@BeforeEach
	public void setup() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
		Hotels.getInstance().getHotels().clear();
		DataWriter.saveHotels();
		Flights.getInstance().getFlights().clear();
		DataWriter.saveFlight();
	}
	
	@AfterEach
	public void tearDown() {
		Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
		Hotels.getInstance().getHotels().clear();
		DataWriter.saveHotels();
		Flights.getInstance().getFlights().clear();
		DataWriter.saveFlight();
	}
	
	
	@Test
	void testWritingZeroUsers() {
		userList = DataLoader.loadUsers();
		assertEquals(0, userList.size());
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User(UUID.randomUUID(), "bob", "02-01-1999", "bobTheMan", "bobsPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
		DataWriter.saveUsers();
		assertEquals("bob", DataLoader.loadUsers().get(0).getName());
	}
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new User(UUID.randomUUID(), "bob1", "02-01-1999", "bobTheMan", "bobsPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
		userList.add(new User(UUID.randomUUID(), "bob2", "02-01-1999", "bobTheMan", "bobsPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
		userList.add(new User(UUID.randomUUID(), "bob3", "02-01-1999", "bobTheMan", "bobsPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
		userList.add(new User(UUID.randomUUID(), "bob4", "02-01-1999", "bobTheMan", "bobsPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
		userList.add(new User(UUID.randomUUID(), "bob5", "02-01-1999", "bobTheMan", "bobsPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
		DataWriter.saveUsers();
		assertEquals("bob5", DataLoader.loadUsers().get(4).getName());
	}
	
	@Test
	void testWritingEmptyUser() {
		userList.add(new User());
		DataWriter.saveUsers();
		assertEquals("", DataLoader.loadUsers().get(0).getName());
	}
	
	@Test
	void testWritingNullUser() {
		userList.add(new User(null, null, null, null, null, null, null, null));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.loadUsers().get(0).getName());
	}

	///////////////////////////////////////////////////////////////////////////////////
	// Hotels                                                                        //
	///////////////////////////////////////////////////////////////////////////////////

	@Test
	void testWritingZeroHotels() {
		hotelList = DataLoader.loadHotels();
		assertEquals(0, hotelList.size());
	}

	@Test
	void testWritingOneHotel() {
        hotelList.add(new Hotel(UUID.randomUUID(), "Hilton", true, 100, 4.2, new ArrayList<Room>(), "Detroit"));
		DataWriter.saveHotels();
		assertEquals("Hilton", DataLoader.loadHotels().get(0).getName());
	}
	
	@Test
	void testWritingFiveHotels() {
        hotelList.add(new Hotel(UUID.randomUUID(), "Hilton1", true, 100, 4.2, new ArrayList<Room>(), "Detroit"));
        hotelList.add(new Hotel(UUID.randomUUID(), "Hilton2", true, 100, 4.2, new ArrayList<Room>(), "Detroit"));
        hotelList.add(new Hotel(UUID.randomUUID(), "Hilton3", true, 100, 4.2, new ArrayList<Room>(), "Detroit"));
        hotelList.add(new Hotel(UUID.randomUUID(), "Hilton4", true, 100, 4.2, new ArrayList<Room>(), "Detroit"));
        hotelList.add(new Hotel(UUID.randomUUID(), "Hilton5", true, 100, 4.2, new ArrayList<Room>(), "Detroit"));
		DataWriter.saveHotels();
		assertEquals("Hilton5", DataLoader.loadHotels().get(4).getName());
	}
	
	@Test
	void testWritingEmptyHotel() {
		hotelList.add(new Hotel(null, "", true, 100, 4.2, new ArrayList<Room>(), "Detroit"));
		DataWriter.saveHotels();
		assertEquals("", DataLoader.loadHotels().get(0).getName());
	}
	
	@Test
	void testWritingNullHotel() {
		hotelList.add(new Hotel(null, null, true, 0, 0, null, null));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.loadHotels().get(0).getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////
	// Flights                                                                       //
	///////////////////////////////////////////////////////////////////////////////////

	@Test
	void testWritingZeroFlight() {
		flightList = DataLoader.loadFlights();
		assertEquals(0, flightList.size());
	}

	@Test
	void testWritingOneFlight() {
        flightList.add(new Flight(UUID.randomUUID(), "Columbia", "Seattle", "03-15-2020", "03=15=2020", "SEA", "COL", FlightType.ONE_WAY, Airline.SPIRIT, 100, 200, 300, new ArrayList<Seat>(), 0));
		DataWriter.saveFlight();
		assertEquals("Columbia", DataLoader.loadFlights().get(0).getDepartureCity());
	}
	
	@Test
	void testWritingFiveFlights() {
        flightList.add(new Flight(UUID.randomUUID(), "Columbia1", "Seattle", "03-15-2020", "03=15=2020", "SEA", "COL", FlightType.ONE_WAY, Airline.SPIRIT, 100, 200, 300, new ArrayList<Seat>(), 0));
        flightList.add(new Flight(UUID.randomUUID(), "Columbia2", "Seattle", "03-15-2020", "03=15=2020", "SEA", "COL", FlightType.ONE_WAY, Airline.SPIRIT, 100, 200, 300, new ArrayList<Seat>(), 0));
        flightList.add(new Flight(UUID.randomUUID(), "Columbia3", "Seattle", "03-15-2020", "03=15=2020", "SEA", "COL", FlightType.ONE_WAY, Airline.SPIRIT, 100, 200, 300, new ArrayList<Seat>(), 0));
        flightList.add(new Flight(UUID.randomUUID(), "Columbia4", "Seattle", "03-15-2020", "03=15=2020", "SEA", "COL", FlightType.ONE_WAY, Airline.SPIRIT, 100, 200, 300, new ArrayList<Seat>(), 0));
        flightList.add(new Flight(UUID.randomUUID(), "Columbia5", "Seattle", "03-15-2020", "03=15=2020", "SEA", "COL", FlightType.ONE_WAY, Airline.SPIRIT, 100, 200, 300, new ArrayList<Seat>(), 0));
		DataWriter.saveFlight();
		assertEquals("Columbia5", DataLoader.loadFlights().get(0).getDepartureCity());
	}
	
	@Test
	void testWritingEmptyFlight() {
        flightList.add(new Flight(null, "", null, null, null, null, null, null, null, 0, 0, 0, null, 0));
		DataWriter.saveHotels();
		assertEquals("", DataLoader.loadFlights().get(0).getDepartureCity());
	}
	
	@Test
	void testWritingNullFlight() {
        flightList.add(new Flight(null, "", null, null, null, null, null, null, null, 0, 0, 0, null, 0));
		DataWriter.saveFlight();
		assertEquals(null, DataLoader.loadFlights().get(0).getAirline());
	}
}