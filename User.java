// Sophie

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Sophie Azula
 */

public class User {
    private UUID ID;
    private String name;
    private String DOB;
    private String userName;
    private String password;
    private ArrayList<String> flightData;
    private ArrayList<String> hotelData;
    private ArrayList<FamilyMember> familyList;
    private int age;

    /**
     * A default constructor for User
     */
    public User(){
        this.ID = UUID.randomUUID();
        this.name = " ";
        this.DOB = " ";
        this.userName = " ";
        this.password = " ";
        this.flightData = null;
        this.hotelData = null;
        this.familyList = null;
    }

    /**
     * A parameterized constructor for USer
     * @param ID a new user ID
     * @param name a user name 
     * @param DOB a users date of birth
     */
    public User(UUID ID, String name, String DOB, String userName, String passWord, ArrayList<String> flightData, ArrayList<String> hotelData, ArrayList<FamilyMember> familyList){
        this.ID = ID;
        this.name = name;
        this.DOB = DOB;
        this.userName = userName;
        this.password = passWord;
        this.flightData = flightData;
        this.hotelData = hotelData;
        this.familyList = familyList;
    }

    public void addFamilyMember(UUID uuid, String name, String DOB) {
        familyList.add(new FamilyMember(ID, name, DOB));
    }

    public void addFlight(Flight flight) {
        flightData.add(flight.getUuid().toString());
    }

    public void addHotel(Hotel hotel) {
        hotelData.add(hotel.getUuid().toString());
    }

    public UUID getUuid() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getDOB() {
        return DOB;
    }

    public int getAge() {
        return age;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<String> getFlightHistory() {
        return flightData;
    }

    public ArrayList<String> getHotelHistory() {
        return hotelData;
    }
    public int calculateAge() {
        return 0;
    }
    public ArrayList<FamilyMember> getFamilyMembers() {
        return familyList;
    }
}
