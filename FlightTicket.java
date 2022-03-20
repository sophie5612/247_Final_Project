import java.util.*;
/**
 * @author Ben Goodman
 */
public class FlightTicket extends Flight{
    
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

    public boolean isSeatAvailable(String[][] seats) { //edit method
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(seats[i][j] == "O"){
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        return false;
    }
}
