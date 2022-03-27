/**
 * A flight class
 * @author Sophie Azula
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import Enums.Airline;
import Enums.FlightType;

 public class Flight {
    protected int row;
    protected int col;
    private UUID ID;
    private String destinationCity;
    private String departureCity;
    private Date departDate;
    private Date arrivalDate;
    private double price;
    private int departTime;
    private int arrivalTime;
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
        this.departureCity = " ";
        this.departDate = new Date();
        this.arrivalDate = new Date();
        this.departAirport = " ";
        this.price = 0;
        this.arrivalAirport = " ";
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
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
      * @param departTime
      * @param arrivalTime
      * @param departAirport
      * @param arrivalAirport
      * @param flightType
      * @param seats
      * @param airline
      */
    public Flight(UUID ID, String destinationCity, String departureCity, Date departDate, Date arrivalDate, String departAirport, String arrivalAirport,
        FlightType flightType, Airline airline, double price){
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
            seats = createSeats();
        }

    private ArrayList<Seat> createSeats() {
        ArrayList<Seat> temp = new ArrayList<Seat>();
        for (int i = 0; i < 60; i++) {
            temp.add(new Seat(i/6, i%6, UUID.randomUUID()));
        }
        return temp;
    }
    //A bit messy but should work, might want to clean up. <<<----------
    public char SeatPrinter(Flight flight) {
        for(int i = 0; i < flight.getSeat().size(); i++) {
            if(flight.getSeat().get(i).getSeatAvailablity() == true) {
                return 'O';
            }
            else {
                return 'X';
            }
        }
        return '0';
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
    public Date getDepartureDate() {
        return departDate;
    }
    public Date getArrivalDate() {
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
    public String getArrivalAirport() {
        return arrivalAirport;
    }
    public boolean getSmoking() {
        return smoking;
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
 }