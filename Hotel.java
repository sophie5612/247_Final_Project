import java.util.*;
/**
 * @author Ben Goodman
 */
public class Hotel extends Booking {
    
    private UUID ID;
    private Date checkInDate;
    private Date checkOutDate;
    private String nameOfHotel; 
    private boolean noSmoking;
    private int numOfBeds;
    private boolean hasPool;
    private ArrayList<Room> rooms;

    public Hotel() {

    }

    private int[][] showRooms() {
        return new int[0][0];
    }
}
