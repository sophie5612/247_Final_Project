    /**
     * Method to create a pet ticket
     */
    //public void Pet() {
    //    System.out.print("Please input the weight of your pet (lbs)");
    //    double weight = scanner.nextDouble();
        // PetTicket petTicket = new PetTicket(weight);
        // add the ticket to the user's account
    //}

    
/**
import java.util.*;
import Enums.*;
 * @author Ben Goodman

public class FlightTicket {
    
    private SeatClass seatClass; //Is this needed if it is extending flight tickets?
    private ArrayList<Bag> bags;
    private boolean windowSeat;
    private int petTickets = 0;

    public void addBag(Bag bag) {
        bags.add(bag);
    }
    public void addPetTicket(String petSize) {
        if(petSize.equalsIgnoreCase("large")) {
            petTickets++;
        }
    }
}
/**
 * @author Sophie Azula
 */
/*
public class BusinessUser extends User{
    private Login login;
    private String company;

    /**
     * A defualt constructor for a Business User
     */
    public BusinessUser(){
        super();
        this.login = new Login(" ", " ");
        this.company = " ";
    }

    /**
     * A parameterized constructor for a Business User
     * @param login
     * @param company
     */
    public BusinessUser(Login login, String company){
        super();
        this.login = login;
        this.company = company;
    }
}
*/


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
