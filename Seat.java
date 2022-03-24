import java.util.UUID;

/**
 * Seat class that extends FlightTicket class
 * @author Reagan Tibbetts
 */

//import java.util.ArrayList;

public class Seat { 
    private static int row;
    private static int col;
    private boolean isAvailable;
    private static UUID uuid;

    public Seat(int row, int col, UUID uuid) {
        this.uuid = uuid;
        this.row = row;
        this.col = col;
        isAvailable = false;
    }

    public boolean getSeatAvailablity() {
        return isAvailable;
    }

}
