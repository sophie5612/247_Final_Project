import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Room class that extends Hotel class
 * @author Reagan Tibbetts
 */
public class Room extends Hotel {
    private UUID ID;
    private boolean isAvailable;
    private int numOfBeds;
    private boolean noSmoking;
    private ArrayList<Date> bookedDates;
    
    public Room() {

    }
}
