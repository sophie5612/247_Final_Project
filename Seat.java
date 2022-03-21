/**
 * Seat class that extends FlightTicket class
 * @author Reagan Tibbetts
 */

//import java.util.ArrayList;

public class Seat { // This class might be useless
    private int[][] location;
    private boolean isAvailable;
    private int x = 0;
    private int y = 0;

   // public boolean Seat() {
      //  for(int i = 0; i < rows; i++) {
        //    for(int j = 0; j < columns; j++) { //Third time checking if seat is availible is repeated.

        //    }
        //}
    //}
    public boolean isSeatAvailable(String[][] seats) { //edit method
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
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
