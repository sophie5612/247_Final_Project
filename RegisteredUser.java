/**
 * @author Sophie
 */

import java.util.ArrayList;
import java.util.Date;


public class RegisteredUser extends User{
    private String username;
    private String password;
    private ArrayList<Flight> flightData;
    private ArrayList<Hotel> hotelData;
    private ArrayList<User> familyList;
    
    /**
     * A default constructor for Registered User
     */
    public RegisteredUser(){
        super();
        this.username = " ";
        this.password = " ";
        this.flightData = new ArrayList<Flight>();
        this.hotelData = new ArrayList<Hotel>();
        this.familyList = new ArrayList<User>();
    }

    /**
     * A parameterized constructor for Registered User
     * @param flightData
     * @param hotelData
     * @param familyList
     */
    public RegisteredUser(String name, Date DOB, String username, String password){
        super(name, DOB);
        this.username = username;
        this.password = password;
        this.flightData = new ArrayList<Flight> ();
        this.hotelData = new ArrayList<Hotel>();
        this.familyList = new ArrayList<User>();
    }

    public String getUserName(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public ArrayList<Flight> getFlightData(){
        return this.flightData;
    }

    public ArrayList<Hotel> getHotelData(){
        return this.hotelData;
    }

    public ArrayList<User> getFamilyList(){
        return this.familyList;
    }

    /**
     * Determines if the user is 18
     * @return
     */
    public boolean isEighteen(){ 
        return (calculateAge(this.getDOB()) >= 18);
    }

    /**
     * Adds a flight to the User data
     * @param flight
     */
    public void addFlight(Flight flight){}

    /**
     * Adds a hotel to the User data
     * @param hotel
     */
    public void addHotel(Hotel hotel){}

    /**
     * Adds a family member to the User data
     * @param familyMember
     */
    public void addFamilyMember(User familyMember){}
}
