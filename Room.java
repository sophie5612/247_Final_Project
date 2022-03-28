import java.util.UUID;
import java.util.ArrayList;

/**
 * Room class
 * @author Reagan Tibbetts
 */
public class Room {
    private UUID ID;
    private int numOfBeds;
    private boolean smoking;
    private ArrayList<String> bookedDates;


    public Room(UUID uuid, int numOfBeds, boolean smoking, ArrayList<String> bookedDates) {
        this.ID = uuid;
        this.numOfBeds = numOfBeds;
        this.smoking = smoking;
        this.bookedDates = bookedDates;
    }

    public UUID getUUID() {
        return ID;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public boolean getSmoking() {
        return smoking;
    }

    public ArrayList<String> getBookedDates() {
        return bookedDates;
    }

}
