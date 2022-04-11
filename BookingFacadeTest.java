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
    void testAccountCreation(){
        bookingFacade.signUp("Austin", "01-01-2001", "cap", "password");
        User user = userList.get(0);
        assertSame(austin, user);
    }

    @Test 
    void testDuplicateUserNames(){

    }

    @Test
    void testCreateEmptyUserName(){

    }

    @Test void testCreateNullUserName(){
        
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
