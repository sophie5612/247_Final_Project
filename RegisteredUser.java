/**
 * @author Sophie
 */

import java.util.ArrayList;

public class RegisteredUser extends User{
    private Login login;
    private ArrayList<Flight> flightData;
    private ArrayList<Hotel> hotelData;
    private ArrayList<User> familyList;
    private boolean frequentFlier;
    
    /**
     * A default constructor for Registered User
     */
    public RegisteredUser(){
        super();
        this.login = new Login();
        this.flightData = new ArrayList<Flight>();
        this.hotelData = new ArrayList<Hotel>();
        this.familyList = new ArrayList<User>();
        this.frequentFlier = false;
    }

    /**
     * A parameterized constructor for Registered User
     * @param login
     * @param flightData
     * @param hotelData
     * @param familyList
     * @param frequentFlier
     */
    public RegisteredUser(Login login, ArrayList<Flight> flightData, ArrayList<Hotel> hotelData, 
    ArrayList<User> familyList, boolean frequentFlier){
        super();
        this.login = login;
        this.flightData = flightData;
        this.hotelData = hotelData;
        this.familyList = familyList;
        this.frequentFlier = frequentFlier;
    }

    /**
     * Determines if the user is 18
     * @return
     */
    public boolean isEighteen(){ return false;}

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

    /**
     * Updates the User's frequent flier status
     */
    public void updateFrequentFlier(){}
}
