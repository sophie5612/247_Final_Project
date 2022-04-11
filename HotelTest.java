import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.Test;

//import java.util.UUID;
//import org.junit.Test;

public class HotelTest {
    Hotel HotelOne = new Hotel();//UUID.randomUUID(), "Hilton", true, 30.50, 4.5, null);
    Hotel HotelTwo = new Hotel();//UUID.randomUUID(), "Motel 6", false, 20.25, 3.0, null);
    Hotel HotelThree = new Hotel();

    @Test
    public void testCheapestHotels(){
       int ret = HotelOne.compareTo(HotelTwo);
        assertEquals(-1, ret);
    }

    @Test
    public void testPriciestHotel(){
        int ret = HotelThree.compareTo(HotelOne);
        assertEquals(1, ret);
    }

    @Test
    public void testEqualHotels(){
        int ret = HotelOne.compareTo(HotelTwo);
        assertEquals(0, ret);
    }
}