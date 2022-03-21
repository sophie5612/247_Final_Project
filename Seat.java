/**
 * Seat class that extends FlightTicket class
 * @author Reagan Tibbetts
 */

//import java.util.ArrayList;

public class Seat { 
    private int rows = 10; //Change when dimensions of plane are given
    private int col = 10;
    private String[][] location;
    private int x = 0;
    private int y = 0;

    public Seat() {
        this.x = x;
        this.y = y;
    }
     
    public boolean isSeatAvailable(String[][] location) { 
        for(int i = 0; i < rows; i++) 
        {
            for(int j = 0; j < col; j++) 
            {
                if(location[x][y] == "O")
                {
                    return true;
                }
            }
        }
        return false;
    }
}
