import java.util.*;
/**
 * @author Ben Goodman
 */
public class FlightTicket {
    
    private SeatClass seatClass; //Is this needed if it is extending flight tickets?
    private ArrayList<Bag> bags;
    private boolean windowSeat;
    private int petTickets = 0;

    public void addBag(Bag bag) {
        bags.add(bag);
    }
    public void addPetTicket(String petSize) {
        if(petSize.equalsIgnoreCase("large")) {
            petTickets++;
        }
    }
}
