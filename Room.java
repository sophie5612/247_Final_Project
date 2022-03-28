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
    private boolean isAvailable;
    private ArrayList<String> bookedDates;
    private int row;
    private int col;


    public Room(int row, int col, UUID uuid, int numOfBeds, boolean smoking, boolean isAvailable, ArrayList<String> bookedDates) {
        this.ID = uuid;
        this.numOfBeds = numOfBeds;
        this.smoking = smoking;
        this.isAvailable = isAvailable;
        this.bookedDates = bookedDates;
        this.row = row;
        this.col = col;
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

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    
    public ArrayList<String> getBookedDates() {
        return bookedDates;
    }

}
