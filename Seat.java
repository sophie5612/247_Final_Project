/**
 * Seat class that extends FlightTicket class
 * @author Reagan Tibbetts
 */

import java.util.ArrayList;

public class Seat extends FlightTicket {
    private SeatClass seatClass;
    private ArrayList<Bag> bags;
    private boolean windowSeat;
    /**
     * Method that adds a pet ticket
     */
    public void addPetTicket() {

    }
    /**
     * Method that checks if a seat is available
     * @param seatClass
     */
    public boolean isSeatAvailable(Seat seatClass) {
        return false;
    }
}
