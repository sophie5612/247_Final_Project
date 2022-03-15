import java.util.*;
/**
 * @author Ben Goodman
 */
public class FlightTicket extends Flight{
    
    private SeatClass seatClass;
    private ArrayList<Bag> bags;
    private boolean windowSeat;

    public void addPetTicket(boolean petSize) {

    }

    public boolean isSeatAvailable(Seat seat) {
        return false;
    }
}
