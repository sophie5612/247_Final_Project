import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Enums.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

class BookingFacadeTest {
    BookingFacade bookingFacade = new BookingFacade();

    @BeforeEach
    public void setUp(){
        bookingFacade.setEmptyUserList();
        UUID uuID1 = UUID.randomUUID(); 
        UUID uuID2 = UUID.randomUUID();
        User austin = new User(uuID1, "Austin", "01-01-2001", "cap", "password", null, null, null);
        User sophie = new User(uuID2, "Sophie" , "05-09-2001", "soph", "pass", null, null, null);
        bookingFacade.userList.add(austin);
        bookingFacade.userList.add(sophie);
    }

    @AfterEach
    public void tearDown(){
        if (bookingFacade.userList != null){
            bookingFacade.userList.clear();
        }
        //DataWriter.saveUsers();
    }

    @Test 
    public void testAccountCreation(){
        bookingFacade.signUp("Ben", "01-01-2001", "cap", "password");
        User user = bookingFacade.userList.get(2); // 2 users already set in setUp
        String usersName = user.getName();
        assertSame("Ben", usersName);
    }

    @Test 
    public void testDuplicateUserNames(){
        bookingFacade.signUp("Austin", "01-01-2001", "cap", "password");
        User user = bookingFacade.userList.get(2); // 2 users already set in setUp
        String usersName = user.getName();
        assertEquals(null, usersName); // acount should not be created
    }

    @Test
    public void testCreateEmptyUser(){
        bookingFacade.signUp(" ", " ", " ", " ");
        User user = bookingFacade.userList.get(2); // 2 users already set in setUp
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
    public void testSortMostAvailableFlights() {
        ArrayList<Flight> temp = new ArrayList<Flight>();
        ArrayList<Flight> sorted = new ArrayList<Flight>();
        bookingFacade.sortMostAvailableFlights(sorted);
        assertEquals(sorted, BookingFacade.sortCheapestFlights(temp));
    }

    @Test
    public void testNoValidFlightsIfZeroTix(){
        ArrayList<Flight> validFlights = bookingFacade.validFlights(0, "Columbia", "Seattle");
        assertEquals(null, validFlights);
    }

    @Test
    public void testNoValidFlightsIfNullInput(){
        ArrayList<Flight> validFlights = bookingFacade.validFlights(0, " " , " ");
        assertEquals(null, validFlights);
    }

    @Test
    public void testValidFlight(){
        UUID uuID = UUID.randomUUID();
        ArrayList<Seat> seats = new ArrayList<Seat>();
        Seat seat = new Seat(2, 'A', uuID, true);
        seats.add(seat);
        Flight validFlight = new Flight(UUID.randomUUID(), "Columbia", "Seattle", "1-1-2022", "1-1-2022", "CA", "SA", FlightType.ONE_WAY, Airline.DELTA, 1, 800, 900, seats, 0);
        assertNotEquals(null, validFlight);
    }

    @Test
    public void testOneSeatsLeft(){
        ArrayList<Seat> seats = new ArrayList<Seat>();
        Seat seat = new Seat(2, 'A', UUID.randomUUID(), true);
        seats.add(seat);
        Flight validFlight = new Flight(UUID.randomUUID(), "Columbia", "Seattle", "1-1-2022", "1-1-2022", "CA", "SA", FlightType.ONE_WAY, Airline.DELTA, 1, 800, 900, seats, 0);
        int seatsLeft = bookingFacade.howManySeatsLeft(validFlight);
        assertSame(1, seatsLeft);
    }

    @Test
    public void testNoSeatsLeft(){
        ArrayList<Seat> seats = new ArrayList<Seat>();
        Flight validFlight = new Flight(UUID.randomUUID(), "Columbia", "Seattle", "1-1-2022", "1-1-2022", "CA", "SA", FlightType.ONE_WAY, Airline.DELTA, 1, 800, 900, seats, 0);
        int seatsLeft = bookingFacade.howManySeatsLeft(validFlight);
        assertSame(0, seatsLeft);
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
        Boolean ret = BookingFacade.checkFamilyMember("Shawn");
        assertEquals(ret, false);
    }
    @Test
    public void testCalculateFlightTime() {
        String ret = BookingFacade.calculateFlightTime(0, 0);
        assertEquals(ret, "Total Time " + 0 + " Hours " + 0 + " Minutes");
    }
    @Test
    public void testCalculateFlightTimeBigTime() {
        String ret = BookingFacade.calculateFlightTime(900, 690);
        assertEquals(ret, "Total Time " + 2 + " Hours " + 30 + " Minutes");
    }
    @Test
    public void testCalculateFlightTimeSmallLarge() {
        String ret = BookingFacade.calculateFlightTime(600, 61);
        assertEquals(ret, "Total Time " + 9 + " Hours " + 59 + " Minutes");
    }
    @Test
    public void testCalculateFlightTimeNegative() {
        String ret = BookingFacade.calculateFlightTime(-100, -50);
        assertEquals(ret, "Not a valid time");
    }
    @Test
    public void testPrintSortedFlight() {
        ArrayList<Flight> tempArr = new ArrayList<Flight>();
        String ret = BookingFacade.printSortedFlights(tempArr);
        assertEquals(ret, "");
    }
    
    @Test
    public void testPrintSortedFlightNull() {
        ArrayList<Flight> tempArr = null;
        String ret = BookingFacade.printSortedFlights(tempArr);
        assertEquals(ret, null);
    }
    @Test
    public void testShowSeats() {
        Flight flight = new Flight();
        String ret = bookingFacade.showSeats(flight);
        assertEquals(ret, null);
    }
    @Test
    public void testShowSeatsNull() {
        Flight flight = null;
        String ret = bookingFacade.showSeats(flight);
        assertEquals(ret, null);
    }
}
