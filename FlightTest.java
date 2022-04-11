/**
 * @author Sophie Azula
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.UUID;
import org.junit.Test;


import Enums.Airline;
import Enums.FlightType;

public class FlightTest {
    Flight cheapFlight = new Flight(UUID.randomUUID(), "Columbia", "Seattle", "1-1-2022", "1-1-2022", "CA", "SA", FlightType.ONE_WAY, Airline.DELTA, 1, 800, 900, null, 0);
    Flight anotherCheapFlight = new Flight(UUID.randomUUID(), "Columbia", "Seattle", "1-1-2022", "1-1-2022", "CA", "SA", FlightType.ONE_WAY, Airline.DELTA, 1, 800, 900, null, 0);
    Flight pricyFlight = new Flight(UUID.randomUUID(), "Columbia", "Seattle", "1-1-2022", "1-1-2022", "CA", "SA", FlightType.ONE_WAY, Airline.DELTA, 100000, 800, 900, null, 0);

    @Test 
    public void testCheapestFlight(){
        int comp = cheapFlight.compareTo(pricyFlight); 
        assertEquals(-1, comp);
    }

    @Test
    public void testPriciestFlight(){
        int comp = pricyFlight.compareTo(cheapFlight);
        assertEquals(1, comp);

    }

    @Test
    public void testEqualPrice(){
        int comp = cheapFlight.compareTo(anotherCheapFlight);
        assertEquals(0, comp);
    }
 }
    
