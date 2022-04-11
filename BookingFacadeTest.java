import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.DrbgParameters.Capability;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;


class BookingFacadeTest {
    BookingFacade bookingFacade = new BookingFacade();

    @BeforeEach
    public void setUp(){
        bookingFacade.userList.clear();
        UUID uuID1 = UUID.randomUUID(); 
        UUID uuID2 = UUID.randomUUID();
        User austin = new User(uuID1, "Austin", "01-01-2001", "cap", "password", null, null, null);
        User sophie = new User(uuID2, "Sophie" , "05-09-2001", "soph", "pass", null, null, null);
        bookingFacade.userList.add(austin);
        bookingFacade.userList.add(sophie);
    }

    @AfterEach
    public static void tearDown(){
        DataWriter.saveUsers();
    }

    @Test 
    void testAccountCreation(){
        bookingFacade.signUp("Ben", "01-01-2001", "cap", "password");
        User user = userList.get(2); // 2 users already set in setUp
        String usersName = user.getName();
        assertSame("Ben", usersName);
    }

    @Test 
    void testDuplicateUserNames(){
        bookingFacade.signUp("Austin", "01-01-2001", "cap", "password");
        User user = userList.get(2); // 2 users already set in setUp
        String usersName = user.getName();
        assertEquals(null, usersName); // acount should not be created
    }

    @Test
    void testCreateEmptyUser(){
        bookingFacade.signUp(" ", " ", " ", " ");
        User user = userList.get(2); // 2 users already set in setUp
        String usersName = user.getName();
        assertEquals(null, usersName); // acount should not be created
    }

    @Test
    void testLogInPass(){
        boolean temp = bookingFacade.login("cap", "password");
        assertTrue(temp);
    }

    @Test
    void testLogInFail(){
        boolean temp = bookingFacade.login("x", "y"); // no credentials exist
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
    public void testPrintRoomWorks() {
        UUID uuid = new UUID(2,5);
        ArrayList<String> bookedDates = new ArrayList<String>();
        Room room = new Room(0, 0, uuid, 3, true, bookedDates);
        String ret = BookingFacade.printRoom(room);
        assertEquals(ret, "\nFloor: 0\nRoom Number: 0\nNumber of beds: 3" );
    }

    @Test
    public void testGetRoomNull() {
        String ret = BookingFacade.getRoom(null, 0, 0, "", 0);
        assertEquals(ret, "No Rooms available in this hotel");
    }

    
    @Test
    public void testGetRoomWorks() {
        Hotel hotel = new Hotel();
        String ret = BookingFacade.getRoom(hotel, 2, 2, "20-02-2022", 4);
        assertEquals(ret, "Added room\n Floor: 0\n Room Number: 0\n Number of beds: 2\n Added room\n Floor: 0\n Room Number: 2\n Number of beds: 2\n Hotel is being added to your account...");
    }

    @Test
    public void testDosentContainDayNull() {
        boolean ret = BookingFacade.doesntContainDay(null, null);
        assertEquals(ret, true);
    }

    @Test
    public void testDosentContainDayWorks() {
        UUID uuid = new UUID(2,5);
        ArrayList<String> bookedDates = new ArrayList<String>();
        Room room = new Room(0, 0, uuid, 2, true, bookedDates);
        boolean ret = BookingFacade.doesntContainDay(room, bookedDates);
        assertEquals(ret, true);
    }

    @Test
    public void TestPrintFlight() {
        Flight flight = new Flight();
        String ret = BookingFacade.printFlight(flight);
        assertEquals(ret,  "\nDeparture Airport: " + flight.getDepartureAirport() +
        '\n' + "Arrival Airport: " + flight.getArrivalAirport() + '\n' + "Departure City(s): " + flight.getDepartureCity() + '\n' +
        "Arrival City: " + flight.getDestination() + '\n' + "Total Travel Time: "
        + BookingFacade.calculateFlightTime(flight.getDepartureTime(), flight.getArrivalTime()) + '\n' + "Price: " + flight.getPrice() + '\n' + "Stops: " + flight.getStops());
    }

    @Test
    public void TestPrintFlightNull() {
        Flight flight = null;
        String ret = BookingFacade.printFlight(flight);
        assertEquals(ret, " ");
    }

    @Test
    public void testMilitaryTimeConvertBaseCase() {
        String ret = BookingFacade.militaryTimeConvert(1400);
        assertEquals(ret, "02:00 PM");
    }
    @Test
    public void testMilitaryTimeConvertAllZeros() {
        String ret = BookingFacade.militaryTimeConvert(0000);
        assertEquals(ret, "12:00 AM");
    }
    @Test
    public void testMilitaryTimeConvertExtraDigits() {
        String ret = BookingFacade.militaryTimeConvert(130113232);
        assertEquals(ret, "Not a valid Military Time");
    }
    @Test
    public void testSortCheapestFlights() {
        ArrayList<Flight> temp = new ArrayList<Flight>();
        ArrayList<Flight> sorted = new ArrayList<Flight>();
        Collections.sort(sorted);
        assertEquals(sorted, BookingFacade.sortCheapestFlights(temp));
    }

    @Test
    public void testSortCheapestFlightsNull() {
        ArrayList<Flight> temp = null;
        ArrayList<Flight> sorted = null;
        Collections.sort(sorted);
        assertEquals(sorted, BookingFacade.sortCheapestFlights(temp));
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
    public void testSortCheapestHotels() {
        ArrayList<Hotel> temp = new ArrayList<Hotel>();
        ArrayList<Hotel> sorted = new ArrayList<Hotel>();
        Collections.sort(sorted);
        assertEquals(sorted, BookingFacade.sortCheapestHotels(temp));
    }

    @Test
    public void testSortCheapestHotelsNull() {
        ArrayList<Hotel> temp = null;
        ArrayList<Hotel> sorted = null;
        Collections.sort(sorted);
        assertEquals(sorted, BookingFacade.sortCheapestHotels(temp));
    }
    @Test
    public void testFamilyMember() {
        String ret = BookingFacade.printFamilyMembers();
        assertEquals(ret, null);
    }
    @Test
    public void testCheckFamilyMember() {
        boolean ret = BookingFacade.checkFamilyMember("Shawn");
        assertEquals(ret, false);
    }
    
}
