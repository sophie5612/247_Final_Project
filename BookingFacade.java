/**
 * A facade for our Booking System
 * @author Sophie Azula
 */

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

public class BookingFacade {
    
    public void signUp(String username, String password){
        // add a user to the User database
    }
    public boolean login(String username, String password){
        return true;
        // return true if the username and password match with an account in the User database
    }

    public void logOut(){
        // log out of Flights, Hotels (save the data)
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

    public ArrayList<Flight> sortCheapestFlights(ArrayList<Flight> flights){
        // search the Flights for cheapest flight, return the sorted ArrayList

        return null;
    }

    public ArrayList<Flight> sortMostAvailableFlights(ArrayList<Flight> flights){
        // search the Flights for most available flight, return the sorted ArrayList
        return null;
    }

    public String printFlight(Flight flight){
        // print out a nice overview of a flight
        // calculate the flight time and include it here
        return null;
    }

    public String calculateFlightTime(int departTime, int arrivalTime){
        // return the total time of the flight (in hours)
        // could alternatively return a String
        // 2400, 1000
        departTime = 0020;
        arrivalTime = 2380;
        int totalMinutes;
        int hours;
        int minutes;
        departTime = ((departTime / 100) * 60) + (departTime % 100);
        arrivalTime = ((arrivalTime / 100) * 60) + (arrivalTime % 100);
        totalMinutes = departTime - arrivalTime;
        hours = Math.abs(totalMinutes / 60);
        minutes = Math.abs(totalMinutes % 60);
        String total = "Total Time " + hours + " Hours " + minutes + " Minutes";
        System.out.print(total);
        return total;
    }

    public String militaryTimeConvert(int time){

        String timeconvert = Integer.toString(time);
        String hour = timeconvert.substring(0,2);
        String minutes = timeconvert.substring(2,4);
        String AmOrPm = "AM";
        int tempAmOrPM = Integer.parseInt(hour.substring(0,2));
        if(hour.substring(0,2).equals("00")) {
            hour = "12";
        }
        else if(hour.substring(0,1).equals("1") || hour.subSequence(0,1).equals("2")) {
            Integer militaryHour = Integer.parseInt(hour);
            Integer regularHour = null;
            if(militaryHour > 12) {
                regularHour = (militaryHour - 12);
                if(regularHour < 10) {
                    hour = "0" + String.valueOf(regularHour);
                }
                else {
                    hour = String.valueOf(regularHour);
                }
            }
        }
        if((tempAmOrPM >= 12) || (tempAmOrPM <= 23)) {
            AmOrPm = "PM";
        }
        if((tempAmOrPM == 00) || (tempAmOrPM == 24)) {
            AmOrPm = "AM";
        }
        timeconvert = hour + ":" + minutes + " " + AmOrPm;
        return timeconvert;
    }

    public String printSortedFlights(ArrayList<Flight> flights){ // or rename to printFlights?? idk just want to make it distinguishable
        // use printFlight, loop through each flight and print out, number each flight 1 - length of flights
        return null;
    }

    public ArrayList<Hotel> sortCheapestHotels(ArrayList<Hotel> hotels){
        // search Hotels for cheapest
        Hotel temp;
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < hotels.size()-1; i++) {
                if(hotels.get(i).compareHotelsCost(hotels.get(i+1)) > 0) {
                    temp = hotels.get(i);
                    hotels.set(i, hotels.get(i+1));
                    hotels.set(i+1, temp);
                    sorted = false;
                }
            }
        }
        return null;
    }

    public ArrayList<Hotel> sortRatingHotels(ArrayList<Hotel> hotels){
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

    public ArrayList<Flight> validFlights(int numTickets, String destinationCity, String departCity, ArrayList<Flight> allFlights){
        // loop through and see if the flight is available and add to the string
        ArrayList<Flight> validFlights = new ArrayList<Flight>();
        for(int i = 0; i < allFlights.size(); i++) {
            if(allFlights.get(i).getDepartureAirport() == departCity && allFlights.get(i).getDestination() == destinationCity) {
                validFlights.add(allFlights.get(i));
            }
        } 
        return validFlights;
        
    }

    public boolean flightAvailable(int numTickets, String destinationCity, String departCity){
        numTicketsAvailable(numTickets);
        // search for city
        if (numTickets >= numTicketsAvailable(numTickets) && departCity == " "){ //check for the citys
            return true;
        }
        return false;
    }
    public int numTicketsAvailable(int numTickets){
        //reutnr the number of tickets available
        return 0;
    }

    //Method may be unneccessary.
    public int compareHotelsCost(Hotel hotel) {
        int res = 0;
        if (this.cost < hotel.getCost()) {
            res =- 1
        }
        if (this.cost > hotel.getCost()) {
            res = 1;
        }
        return res;
    }

}
