/**
 * A flight class
 * @author Sophie Azula
 */

import java.util.Date;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;

 public class Flight{
    private UUID ID;
    private String destinationCity;
    private Date departDate;
    private Date arrivalDate;
    private String departAirport;
    private String arrivalAirport;
    private boolean smoking;
    private FlightType flightType;
    private String[][] seats;
    private Airline airline;
    
    private int[] totalFlights;

    int rows = 10;
    int columns = 6;

    /**
     * A default constructor
     */
    public Flight(){
        this.ID = UUID.randomUUID();
        this.destinationCity = " ";
        this.departDate = new Date();
        this.arrivalDate = new Date();
        this.departAirport = " ";
        this.arrivalAirport = " ";
        this.smoking = false;
        this.flightType = FlightType.ONE_WAY;
        String[][] seats = new String[rows][columns]; //Dont know if this is neccessary.
        //this.seats = new ArrayList<Seat>();
        this.airline = Airline.DELTA;
    }

     /**
      * A parameterized constructor
      * @param ID
      * @param destinationCity
      * @param departDate
      * @param arrivalDate
      * @param departAirport
      * @param arrivalAirport
      * @param smoking
      * @param flightType
      * @param seats
      * @param airline
      */
    public Flight(UUID ID, String destinationCity, Date departDate, Date arrivalDate, String departAirport, String arrivalAirport, boolean smoking,
        FlightType flightType, String[][] seats, Airline airline){
            this.ID = ID;
            this.destinationCity = destinationCity;
            this.departDate = departDate;
            this.arrivalDate = arrivalDate;
            this.departAirport = departAirport;
            this.arrivalAirport = arrivalAirport;
            this.smoking = smoking;
            this.flightType = flightType;
            this.seats = seats;
            this.airline = airline;
        }

    /**
     *  A method that will sort flights based on default sorting behavior
     * @param destinationCity
     * @param departDate
     */
    public void sortFlights(String destinationCity, Date departDate){
        //Read in jason to get all dates then compare
        //Total flights will be an array of dates of the dates in the json.
        for(int i = 0; i < totalFlights.length; i++) { 
            
        }
    }
    
    /**
     * Calculate the number of unbooked seats
     * @return The number of remaining seats 
     */
    public int remainingSeats(String[][] seats){
        int amountOfSeats = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; i < columns; j++) {
                if(seats[i][j] == "O") {
                    amountOfSeats++;
                }
            }
        }
        System.out.println("Their are " + amountOfSeats + " seats left");
        return amountOfSeats;
    }
    
    /**
     * Display the seats in a 2x2 matrix
     * Note: X represents booked, O represents open
     * @return A 2x2 matrix of seats on this flight
     */
    public void showSeats(int seats) { 
        String[][] seatsArray = new String[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; i < columns; j++) {
                seatsArray[i][j] = "O";
            }
        }

        for(int i = 0; i < rows; i++) {
            for (int j = 0; i < columns; j++) {
                System.out.print(seatsArray[i][j]);
            }
            System.out.println();
        }
    }
 }