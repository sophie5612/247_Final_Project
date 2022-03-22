import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;

/**
 * Room class that extends Hotel class
 * @author Reagan Tibbetts
 */
public class Room extends Hotel {
    private UUID ID;
    private boolean isAvailable;
    private int numOfBeds;
    private boolean noSmoking;
    private ArrayList<Date> bookedDates;
    private String[][] location;
    private static int rows = 10;
    private static int cols = 10;
    public Room() {

    }
    public static void showRooms() { 
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
    public int remainingRooms(String[][] rooms){
        int amountOfRooms = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; i < cols; j++) {
                if(rooms[i][j] == "O") {
                    amountOfRooms++;
                }
            }
        }
        System.out.println("Their are " + amountOfRooms + " rooms left");
        return amountOfRooms;
    }
}
