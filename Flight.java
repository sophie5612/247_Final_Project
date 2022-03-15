/**
 * A flight class
 * @author Sophie Azula
 */

import java.util.Date;
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
    private ArrayList<Seat> seats;
    private Airline airline;

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
        this.seats = new ArrayList<Seat>();
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
        FlightType flightType, ArrayList<Seat> seats, Airline airline){
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
    public void sortFlights(String destinationCity, Date departDate){}
    
    /**
     * Calculate the number of unbooked seats
     * @return The number of remaining seats 
     */
    public int remainingSeats(){ return 0;}
    
    /**
     * Display the seats in a 2x2 matrix
     * Note: X represents booked, O represents open
     * @return A 2x2 matrix of seats on this flight
     */
    public int[][] showSeats(){ return new int[0][0];}
 }