/**
 * A flight class
 * @author Sophie Azula
 */

import java.util.ArrayList;
import java.util.UUID;
import Enums.Airline;
import Enums.FlightType;

 public class Flight implements Comparable<Flight>{
    protected int row;
    protected int col;
    private UUID ID;
    private String destinationCity;
    private String departureCity;
    private String departDate;
    private String arrivalDate;
    private double price;
    private int departTime;
    private int arrivalTime;
    private String departAirport;
    private String arrivalAirport;
    private int stops;
    private FlightType flightType;
    private ArrayList<Seat> seats;
    private Airline airline;

    /**
     * A default constructor
     */
    public Flight(){
        this.ID = UUID.randomUUID();
        this.destinationCity = " ";
        this.departureCity = " ";
        this.departDate = " ";
        this.arrivalDate = " ";
        this.departAirport = " ";
        this.price = 0;
        this.arrivalAirport = " ";
        this.departTime = 0000;
        this.arrivalTime = 0000;
        this.stops = 0;
        this.flightType = FlightType.ONE_WAY;
        this.airline = Airline.DELTA;
    }

     /**
      * A parameterized constructor
      * @param ID
      * @param destinationCity
      * @param departDate
      * @param arrivalDate
      * @param departTime
      * @param arrivalTime
      * @param departAirport
      * @param arrivalAirport
      * @param flightType
      * @param seats
      * @param airline
      */
    public Flight(UUID ID, String destinationCity, String departureCity, String departDate, String arrivalDate, String departAirport, String arrivalAirport,
        FlightType flightType, Airline airline, double price, int departTime, int arrivalTime, ArrayList<Seat> seats, int stops){
            this.ID = ID;
            this.destinationCity = destinationCity;
            this.departureCity = departureCity;
            this.departDate = departDate;
            this.arrivalDate = arrivalDate;
            this.departTime = departTime;
            this.arrivalTime = arrivalTime;
            this.departAirport = departAirport;
            this.arrivalAirport = arrivalAirport;
            this.flightType = flightType;
            this.airline = airline;
            this.price = price;
            this.seats = seats;
            this.stops = stops;
        }

    /**
     * Calculate the number of unbooked seats
     * @return The number of remaining seats 
     */
    public UUID getUuid() {
        return ID;
    }
    public String getDestination() {
        return destinationCity;
    }
    public String getDepartureDate() {
        return departDate;
    }
    public String getArrivalDate() {
        return arrivalDate;
    }
    public int getDepartureTime() {
        return departTime;
    }
    public int getArrivalTime () {
        return arrivalTime;
    }
    public String getDepartureAirport() {
        return departAirport;
    }
    public String getDepartureCity() {
        return departureCity;
    }
    public String getArrivalAirport() {
        return arrivalAirport;
    }
    public int getStops() {
        return stops;
    }
    public FlightType getFlightType() {
        return flightType;
    }
    public ArrayList<Seat> getSeat() {
        return seats;
    }
    
    public Airline getAirline() {
        return airline;
    }
    public double getPrice() {
        return price;
    }

    public int compareTo(Flight flight) {
        if (price == flight.price) {
            return 0;
        } else if (price > flight.price) {
            return 1;
        } else {
            return -1;
        }
    }
 }