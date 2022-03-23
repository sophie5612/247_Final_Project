/**
 * Pet ticket class that extends flight ticket class
 * @author Reagan Tibbetts
 */
public class PetTicket {
    private double petWeight;
/**
    public PetTicket() {
    }
**/
    public boolean isPetLarge(double petWeight) {
        if(petWeight > 100) {
            return true;
        }
        else {
            return false;
        }
    }
}
