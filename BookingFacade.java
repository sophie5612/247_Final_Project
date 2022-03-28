/**
 * A facade for our Booking System
 * @author Sophie Azula
 */

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;



public class BookingFacade {
    // private Flights flights;
    // private Hotels hotels;
    // private Users users;
    // private User user; // Current user

    // public BookingFacade(){
    //     flights = Flights.getInstance();
    //     hotels = Hotels.getInstance();
    //     users = Users.getInstance();
    // }
    
    public void signUp(String name, Date DOB, String username, String password){
        Users.addUser(name, DOB, username, password);
    }

    public boolean login(String username, String password){
        boolean exists = false;
        for(int i = 0; i < users.getUsers().size(); i ++){
            // check if there exists a user
        }
        return exists;
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

    public ArrayList<Flight> sortCheapestFlights(ArrayList<Flight> flights){ // search the Flights for cheapest flight, return the sorted ArrayList
        ArrayList<Double> tempFlights = new ArrayList<Double>();
        ArrayList<Flight> validFlights = new ArrayList<Flight>();
        for(int i = 0; i < flights.size(); i++) {
                tempFlights.add(flights.get(i).getPrice());
            } 
        Collections.sort(tempFlights);
        for(int i = 0; i < flights.size(); i++) {
            for(int j = 0; j < flights.size()-1; j++) {
                if(tempFlights.get(i) == flights.get(i).getPrice()) {
                    validFlights.add(flights.get(i));
                }
            }
        }
        return validFlights;
    }

    public ArrayList<Flight> sortMostAvailableFlights(ArrayList<Flight> flights){ // search the Flights for most available flight, return the sorted ArrayList
        Flight temp = new Flight();
        Flight temp2 = new Flight();
        return null;
            // Collections.sort(flights, new Comparator<Flight>()
            // {
                //Ascending sort (might scrap)
            //     public int compare(Flight f1, Flight f2)
            //     {
            //         return Integer.valueOf(f1.getSeats().compareTo(f2.getSeats());
            //     }
            // });
            // for (int i = 0; i < flights.size(); i++) {
            //     System.out.println(flights.get(i));
            // }
            //if(numTicketsAvailable(flights.get(i)) < numTicketsAvailable(flights.get(i+1))) {
            //    temp = flights.get(i);
            //    temp2 = flights.get(i+1);
            //    flights.get(i+1) = temp;
            //    temp = flights.get(i+1);
            //
            //}
        }

    public String printFlight(Flight flight){
        String flightString = ("Flight type: " + flight.getFlightType() + '\n' + "Departure Airport: " + flight.getDepartureAirport() +
            '\n' + "Arrival Airport: " + flight.getArrivalAirport() + '\n' + "Total Travel Time: "
            + calculateFlightTime(flight.getDepartureTime(), flight.getArrivalTime()) + '\n' + '\n');
        return flightString;
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

    public String printSortedFlights(ArrayList<Flight> flights){
        String sortedFlights = " ";
        for(int i = 0; i < flights.size(); i++) {
            sortedFlights += (i + 1) + ") " + printFlight(flights.get(i));
        }
        return sortedFlights;
    }

    public ArrayList<Hotel> sortCheapestHotels(ArrayList<Hotel> hotels){
        ArrayList<Double> tempHotel = new ArrayList<Double>();
        ArrayList<Hotel> validHotel = new ArrayList<Hotel>();
        for(int i = 0; i < hotels.size(); i++) {
                tempHotel.add(hotels.get(i).getPrice());
            } 
        Collections.sort(tempHotel);
        for(int i = 0; i < hotels.size(); i++) {
            for(int j = 0; j < hotels.size()-1; j++) {
                if(tempHotel.get(i) == hotels.get(i).getPrice()) {
                    validHotel.add(hotels.get(i));
                }
            }
        }
        return validHotel;
    }

    public ArrayList<Hotel> sortRatingHotels(ArrayList<Hotel> hotels){
        ArrayList<Integer> tempHotel = new ArrayList<Integer>();
        ArrayList<Hotel> validHotel = new ArrayList<Hotel>();
        for(int i = 0; i < hotels.size(); i++) {
            tempHotel.add(hotels.get(i).getRatings());
        }
        Collections.sort(tempHotel, Collections.reverseOrder());
        for(int i = 0; i < hotels.size(); i++) {
            for(int j = 0; j < hotels.size()-1; j++) {
                if(tempHotel.get(i) == hotels.get(i).getRatings()) {
                    validHotel.add(hotels.get(i));
                }
            }
        }
        return validHotel;
    }

    public String printHotel(Hotel hotel) {
        String hotelString = ("Hotel Name: " + hotel.getHotel() + '\n' + "Hotel price: " + hotel.getPrice() + '\n' 
            + "Rating: " + hotel.getRatings() + '\n' + "Amenities: " + hotel.getPool());
        return hotelString;
    }

    public String printSortedHotels(ArrayList<Hotel> hotels){ 
        String sortedHotels = " ";
        for(int i = 0; i < hotels.size(); i++) {
            sortedHotels += (i + 1) + ") " + printHotel(hotels.get(i));
        }
        return sortedHotels;
    }

    public void saveData(){
        // save all the users data
    }

    public ArrayList<Flight> validFlights(int numTickets, String destinationCity, String departCity){
        // loop through and see if the flight is available and add to the string
        ArrayList<Flight> validFlights = new ArrayList<Flight>();
        // for(int i = 0; i < this.flights.size(); i++) { // idk how we're creating the initial flights ArrayList
        //     if(numTicketsAvailable(flights.get(i)) >= numTickets )&& this.flights.getDepartureAirport(i) == departCity && this.flights.getDestination(i) == destinationCity) {
        //         validFlights.add(flights.get(i));
        //     }
        // } 
        return validFlights;
        
    }



    public boolean flightAvailable(int totalTickets, String destinationCity, String departCity, ArrayList<Flight> allFlights){
        //int available numTicketsAvailable(numTickets);
        // search for city
        for(int i = 0; i < allFlights.size(); i++) {
                if (numTicketsAvailable(allFlights.get(i)) >= totalTickets && departCity == allFlights.get(i).getDepartureAirport() && destinationCity == allFlights.get(i).getArrivalAirport()) { //check for the citys
                    return true;
                }
        }
        return false;
    }
    public int numTicketsAvailable(Flight flight){
        //return the number of tickets available
        int AvailableTickets = 0;
        //Determine which Seats are taken in the list
        for(int i = 0; i < flight.getSeat().size(); i++) {
            if(flight.getSeat().get(i).getSeatAvailablity() == true) {
                AvailableTickets++;
            }
        }                                                       
        return AvailableTickets; //Return integer of Seats still available
    }

    public String showSeats(Flight flight) { //should this be done in the UI
        String output = " ";
        int rows = 6;
        int cols = 10;
        char[][] seats = new char[rows][cols]; // will change to adapt

        for (int i = 0; i < rows; i++) {
            for (int j = 0; i < cols; j++) {
                // if (flight.getSeat().isAvailable()){
                // seats[i][j] = 'O';
                // }
                // else{
                // seats[i][j] = 'X';
                // }
                output += (seats[i][j]);
                ;
            }
        }
        return output;
    }


    /**
     * Method to pick a seat
     * 
     * @return The flight at the requested location
     */
    // public Seat SeatPicker(Flight flight) { // should this be done in the UI? No,
    // will move
    // Seat.initalizeSeats();
    // Seat.printSeats();
    // System.out.print("Please pick which seat you would like\nInput the row: ");
    // int row = scanner.nextInt();
    // System.out.print("Input the column: ");
    // int col = scanner.nextInt();
    // if(Seat.isSeatAvailable(row, col) == true) {
    // Seat.printSeats();
    // System.out.println("Booking your seat.");
    // } else {
    // System.out.println("That seat is already taken, please select another
    // seat.");
    // }

    // // return the seat, update the double array
    // return null;
    // }
}
