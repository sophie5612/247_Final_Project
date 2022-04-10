<<<<<<< HEAD
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

=======
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
>>>>>>> 3ad84e85a10f5202887fae43206231585079f6a6
import java.util.ArrayList;

/**
 * @author Ben Goodman
 */
class BookingFacadeTest {

    @Test
    public void testPrintHotelNull(){
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
    public void testgetRoomOneRoomTwoBedsTwoDays() {
        Hotel hotel = new Hotel();
        Room temp;
        String ret = BookingFacade.getRoom(hotel, 1, 2, "02-02-2022", 2);
        for (int i = 0; i < hotel.getRooms().size(); i++) {
            temp = hotel.getRooms().get(i);
        }
        assertEquals(ret, "\nAdded room" + BookingFacade.printRoom(temp));
    }
    
}
