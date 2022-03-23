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
    private static int rows = 10;
    private static int cols = 10;
    private static String[][] location = new String[rows][cols];

    public static void initalizeRooms() { 
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                location[i][j] = "O";
            }
        }
    }
    public static void printRoom() {
    for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(location[rows][cols]);
            }
            System.out.println();
        }
    }
    public static boolean isSeatAvailable(int x, int y) { 
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(location[x-1][y-1] == "O") {
                    location[x-1][y-1] = "X";
                    return true;
                }
            }
        }
        return false;
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
