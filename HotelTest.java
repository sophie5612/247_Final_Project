import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.Test;

//import java.util.UUID;
//import org.junit.Test;

public class HotelTest {
    Hotel cheapHotel2 = new Hotel(UUID.randomUUID(), "Hilton", true, 20.25, 4.5, null, "Columiba");
    Hotel cheapHotel = new Hotel(UUID.randomUUID(), "Motel 6", false, 20.25, 3.0, null, "Columbia");
    Hotel expensiveHotel = new Hotel(UUID.randomUUID(), "Marriot", true, 50.00, 3.0, null, "Columbia");

    @Test
    public void testCheapestHotels(){
       int ret = cheapHotel.compareTo(expensiveHotel);
        assertEquals(-1, ret);
    }

    @Test
    public void testPriciestHotel(){
        int ret = expensiveHotel.compareTo(cheapHotel);
        assertEquals(1, ret);
    }

    @Test
    public void testEqualHotels(){
        int ret = cheapHotel.compareTo(cheapHotel2);
        assertEquals(0, ret);
    }
}