/**
 * Seat class that extends FlightTicket class
 * @author Reagan Tibbetts
 */

//import java.util.ArrayList;

public class Seat { 
    private static int rows = 10; //Change when dimensions of plane are given
    private static int cols = 10;
    private static String[][] Array;
    private static String[][] newArray = new String[rows][cols];
    //private String[][] location;
    private int x;
    private int y;

    public Seat() {

    }

    public static void initalizeSeats() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                newArray[i][j] = "O";
            }
        }
    }
    public static void printSeats() {
    for(int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            System.out.print(newArray[i][j]);
        }
        System.out.println();
    }
}

    public static boolean isSeatAvailable(int x, int y) { 
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(newArray[x][y] == "O") {
                    newArray[x][y] = "X";
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
