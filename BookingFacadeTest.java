import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Ben Goodman
 */
class BookingFacadeTest {
    BookingFacade bookingFacade = new BookingFacade();
    Flights flights = Flights.getInstance();
    Hotels hotels = Hotels.getInstance();
    Users users = Users.getInstance();
    ArrayList<Flight> flightList;
    ArrayList<Hotel> hotelList;
    ArrayList<User> userList;

    UUID uuID = UUID.randomUUID(); 
    User austin = new User(uuID, "Austin", "01-01-2001", "cap", "password", null, null, null);


    @Before
    public static void setUp(){
        //if yall need to set anything up
    }
    @After
    public static void tearDown(){
        //take it down
    }

    @Test 
    void testSignUp(){
        bookingFacade.signUp("Austin", "01-01-2001", "cap", "password");
        User user = userList.get(0);
        assertSame(austin, user);
    }

    @Test
    void testLogInPass(){
        boolean temp = bookingFacade.login("cap", "password");
        assertTrue(temp);
    }

    @Test
    void testLogInFail(){
        boolean temp = bookingFacade.login("x", "y");
        assertFalse(temp);
    }

    @Test
    void testPrintHotelNull(){
        String hotel = BookingFacade.printHotel(null);
        assertEquals(hotel, "");
    }

    @Test
    public void testPrintHotelWorks() {
        Hotel hotelOne = new Hotel();
        String hotel = BookingFacade.printHotel(hotelOne);
        assertEquals(hotel, ("Hotel Name: " + hotelOne.getName() + '\n' + "Hotel price: " + hotelOne.getPrice() + '\n' 
        + "Rating: " + hotelOne.getRatings() + '\n' + "Pool?: " + hotelOne.getPool()));
    }

    @Test
    public void testPrintSortedHotelsNull() {
        String sortedHotels = BookingFacade.printSortedHotels(null);
        assertEquals(sortedHotels, "");
    }

    @Test
    public void testPrintSortedHotelsWorks() {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
        String sortedHotels = BookingFacade.printSortedHotels(hotels);
        assertEquals(sortedHotels, "");
    }

    @Test
    public void testPrintRoomNull() {
        String ret = BookingFacade.printRoom(null);
        assertEquals(ret, "\nFloor: \nRoom Number: \nNumber of beds: ");
    }

    @Test
    public void testgetRoomNull() {
        String ret = BookingFacade.getRoom(null, 0, 0, "", 0);
        assertEquals(ret, "No Rooms available in this hotel");
    }

    @Test
    public void TestPrintFlight() {
        Flight flight = new Flight();
        String ret = BookingFacade.printFlight(flight);
        assertEquals(ret, "Departure Airport: " + flight.getDepartureAirport() + '\n' + "Arrival Airport: " +  flight.getArrivalAirport() + '\n' + "Departure City(s): " + flight.getDepartureCity()
        + '\n' + "Arrival City: " + flight.getArrivalAirport() + '\n' + "Total Travel Time: " + BookingFacade.calculateFlightTime(flight.getDepartureTime(), flight.getArrivalTime()) + '\n' + "Price: " 
        + flight.getPrice() + '\n' + "Stops: " + flight.getStops());
    }

    @Test
    public void TestPrintFlightNull() {
        Flight flight = null;
        String ret = BookingFacade.printFlight(flight);
        assertEquals(ret, " ");
    }

    @Test
    public void testSortCheapestFlights() {
        ArrayList<Flight> temp = new ArrayList<Flight>();
        Flight flight = new Flight();
        temp.add(0, flight);
        ArrayList<Flight> sorted = BookingFacade.sortCheapestFlights(temp);
        assertEquals(sorted, flight.getArrivalAirport());
    }
    
    @Test
    public void testPickedSeatValidSeat() {
        Flight flight = new Flight();
        boolean seat = BookingFacade.pickedSeat(flight, "A");
        assertEquals(seat, false);
    }
    @Test
    public void testPickedSeatNull() {
        Flight flight = new Flight();
        boolean seat = BookingFacade.pickedSeat(flight, "null");
        assertEquals(seat, false);
    }
    @Test
    public void testSortCheapestHotel() {
        ArrayList<Flight> temp = new ArrayList<Flight>();
        Flight flight = new Flight();
        temp.add(0, flight);
        ArrayList<Flight> sorted = BookingFacade.sortCheapestFlights(temp);
        assertEquals(sorted, flight.getArrivalAirport());
    }

    @Test
    public void testFamilyMember() {
        String ret = BookingFacade.printFamilyMembers();
        assertEquals(ret, null);
    }
    
    
    // @Test
    // public void testgetRoomOneRoomTwoBedsTwoDays() {
    //     Hotel hotel = new Hotel();
    //     Room temp = new Room();
    //     String ret = BookingFacade.getRoom(hotel, 1, 2, "02-02-2022", 2);
    //     for (int i = 0; i < hotel.getRooms().size(); i++) {
    //         temp = hotel.getRooms().get(i);
    //     }
    //     assertEquals(ret, "\nAdded room" + BookingFacade.printRoom(temp));
    // }
    
}
