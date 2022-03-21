/**
 * A flight class
 * @author Sophie Azula
 */

import java.util.Date;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.UUID;
import Enums.Airline;
import Enums.FlightType;

 public class Flight extends Booking{
    protected int row;
    protected int col;
    private UUID ID;
    private String destinationCity;
    private Date departDate;
    private Date arrivalDate;
    private String departAirport;
    private String arrivalAirport;
    private boolean smoking;
    private FlightType flightType;
    private String[][] seats = new String[row][col];
    private Airline airline;
    
    private int[] totalFlights;

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
        //String[][] seats = new String[rows][columns]; //Dont know if this is neccessary.
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
        for(int i = 0; i < row; i++) {
            for(int j = 0; i < col; j++) {
                if(seats[i][j] == "O") {
                    amountOfSeats++;
                }
            }
        }
        System.out.println("Their are " + amountOfSeats + " seats left");
        return amountOfSeats;
    }
 }