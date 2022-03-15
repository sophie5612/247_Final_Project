
/**
 * A Booking class
 * @author Sophie Azula
 */

import java.util.ArrayList;

public class Booking {
    private ArrayList<Flight> flights;
    private ArrayList<Hotel> hotels;

    /**
     * A default constructor for Booking
     */
    public Booking(){
        this.flights = new ArrayList<Flight>();
        this.hotels = new ArrayList<Hotel>();
    }

    /**
     * A parameterized constructor for Booking
     * @param flights
     * @param hotels
     */
    public Booking(ArrayList<Flight> flights, ArrayList<Hotel> hotels){
        this.flights = flights;
        this. hotels = hotels;
    }
    
    /**
     * Retrieve file data from a JSON file
     * @param fileName Name of the file to read from
     */
    public void getFileData(String fileName){}

    /**
     * Book a flight/hotel for a user
     * @param user The user the flight/hotel is booked for
     */
    public void Book(User user){}
}
