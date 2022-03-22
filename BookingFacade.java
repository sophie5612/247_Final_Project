/**
 * A facade for our Booking System
 * @author Sophie Azula
 */

import java.util.ArrayList;
import java.util.Date;

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

    public void bookFlight(Seat seat){
        // add a flight to the Users database
        // we're going to start running into issues of objects not knowing about each other, should restructure this
    }

    public void bookHotel(Room room){
        // ^^ see above
    }

    public ArrayList<Flight> sortCheapestFlights(String destinationCity, String departAirport){
        // search the Flights for cheapest flight, return the sorted ArrayList
        return null;
    }

    public ArrayList<Flight> sortMostAvailableFlights(String destinationCity, String departAirport){
        // search the Flights for most available flight, return the sorted ArrayList
        return null;
    }

    public String printFlight(Flight flight){
        // print out a nice overview of a flight
        return null;
    }

    public String printSortedFlights(ArrayList<Flight> flights){ // or rename to printFlights?? idk just want to make it distinguishable
        // use printFlight, loop through each flight and print out, number each flight 1 - length of flights
        return null;
    }

    public ArrayList<Hotel> sortCheapestHotels(String destinationCity){
        // search Hotels for cheapest
        return null;
    }

    public ArrayList<Hotel> sortRatingHotels(String destinationCity){
        // search Hotels for highest rating
        return null;
    }

    public String printHotel(Hotel hotel){
        // nice formating of a hotel
        return null;
    }

    public String printSortedHotels(ArrayList<Hotel> hotels){ 
        // numbered list of hotels
        return null;
    }

    public void saveData(){
        // save all the users data
    }
}
