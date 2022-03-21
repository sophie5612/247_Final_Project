/**
 * Seat class that extends FlightTicket class
 * @author Reagan Tibbetts
 */

//import java.util.ArrayList;

public class Seat { 
    private static int rows = 10; //Change when dimensions of plane are given
    private static int cols = 10;
    private static String[][] Array;
    private String[][] location;
    private int x = 0;
    private int y = 0;

    public Seat() {
        this.x = x;
        this.y = y;
    }

    public static void showSeats() { 
        String[][] Array= new String[rows][cols];
        for(int rows = 0; rows < Array.length; rows++) {
            for(int cols = 0; cols < Array[rows].length; cols++) {
                Array[rows][cols] = "O";
            }
        }

        for(int rows = 0; rows < Array.length ; rows++) {
            for (int cols = 0; cols < Array[rows].length; cols++) {
                System.out.print(Array[rows][cols]);
            }
            System.out.println();
        }
    }

    public boolean isSeatAvailable(String[][] location) { 
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(location[x][y] == "O"){
                    return true;
                }
            }
        }
        return false;
    }

}
