import java.util.UUID;

/**
 * Seat class that extends FlightTicket class
 * @author Reagan Tibbetts
 */

//import java.util.ArrayList;

public class Seat { 
    private int row;
    private int col;
    private boolean isAvailable;
    private UUID uuid;

    public Seat(int row, int col, UUID uuid, boolean isAvailable) {
        this.uuid = uuid;
        this.row = row;
        this.col = col;
        this.isAvailable = isAvailable;
    }

    public boolean getSeatAvailablity() {
        return isAvailable;        
    }

    public void setSeatToTaken() {
        isAvailable = false;
    }

    public UUID getUuid() {
        return uuid;
    }
    //same as get SeatAvailability
    public boolean getIsAvailable() {
        return isAvailable;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    // Austin
    public String toString() {
        return "\nID: " + uuid.toString() + "\nRow:" + row + "\nCol:" + col;
    }

}
