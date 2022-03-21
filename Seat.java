/**
 * Seat class that extends FlightTicket class
 * @author Reagan Tibbetts
 */

//import java.util.ArrayList;

public class Seat { 
    private int rows = 10; //Change when dimensions of plane are given
    private int col = 10;
    private int[][] location;
    private boolean isAvailable;
    private int x = 0;
    private int y = 0;

    public Seat() {
        this.rows = rows;
        this.col = col;
        this.location = location;
        this.isAvailable = isAvailable;
        this.x = x;
        this.y = y;
    }
     
    public boolean isSeatAvailable(String[][] seats) { 
        for(int i = 0; i < rows; i++) {
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
