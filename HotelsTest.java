
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;
import org.junit.Test;


public class HotelsTest {

    Hotel cheapHotel = new Hotel(UUID.randomUUID(), "EvesINN", true, 120.00, 2.3, null, "Charleston");
    Hotel anotherCheapHotel = new Hotel(UUID.randomUUID(), "EvesINN", true, 120.00, 3.0, null, "Charleston");
    Hotel pricyHotel = new Hotel(UUID.randomUUID(), "EvesINN", true, 300.00, 4.5, null, "Charleston");

    @Test 
    public void testCheapestHotel(){
        int comp = cheapHotel.compareTo(pricyHotel); 
        assertEquals(-1, comp);
    }

    @Test
    public void testPriciestHotel(){
        int comp = pricyHotel.compareTo(cheapHotel);
        assertEquals(1, comp);

    }

    @Test
    public void testEqualPrice(){
        int comp = cheapHotel.compareTo(anotherCheapHotel);
        assertEquals(0, comp);
    }
 }
    
