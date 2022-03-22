/**
 * A facade for our Booking System
 * @author Sophie Azula
 */

import java.util.ArrayList;

public class BookingFacade {
    
    public void signUp(String username, String password){
        // add a user to the User database
    }
    public boolean login(String username, String password){
        return true;
        // return true if the username and password match with an account in the User database
    }

    public void addFamilyMember(String name){
        // add the family member's name to the User database
    }

    public void bookFlight(Flight flight){
        // add a flight to the Users database
    }

    public ArrayList<Flight> sortedCheapestFlights(String destinationCity, String departAirport){
        // search the Flight database for cheapest flight
        return null;
    }

    public ArrayList<Flight> sortedMostAvailableFlights(String destinationCity, String departAirport){
        // search the Flight database for the most available flight
        return null;
    }

    public String printSortedFlights(ArrayList<Flight> flights){
        // return a nicely formated breakdown of flight ticket
        return null;
    }

    public void saveData(){
        // save all the users data
    }
}
