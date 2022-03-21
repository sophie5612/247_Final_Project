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
    private static int x;
    private static int y;

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

    public static boolean isSeatAvailable(String[][] location) { 
        for(int rows = 0; rows < Array.length; rows++) {
            for(int cols = 0; cols < Array[rows].length; cols++) {
                if(location[rows][cols] == "O"){//change it find location not just indexing.  
                    return true;
                }
            }
        }
        return false;
    }
    public int remainingSeats(String[][] seats){
        int amountOfSeats = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; i < cols; j++) {
                if(seats[i][j] == "O") {
                    amountOfSeats++;
                }
            }
        }
        System.out.println("Their are " + amountOfSeats + " seats left");
        return amountOfSeats;
    }
}
