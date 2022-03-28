/**
 * A facade for our Booking System
 * @author Sophie Azula
 */

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import java.util.Collections;
import java.util.Comparator;

public class BookingFacade {

    Flights flights = Flights.getInstance();
    Hotels hotels = Hotels.getInstance();
    Users users = Users.getInstance();
    ArrayList<Flight> flightList;
    ArrayList<Hotel> hotelList;
    ArrayList<User> userList;
    User currentUser;

    public BookingFacade(){
        flightList = Flights.getFlights();
        hotelList = Hotels.getHotels();
        userList = Users.getUsers();
        currentUser = null;
    }

    public void signUp(String name, String DOB, String username, String password){
        currentUser = new User(UUID.randomUUID(), name, DOB, username, password, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>());
        Users.addUser(currentUser);
    }

    public boolean login(String username, String password){
        for (int i = 0; i < userList.size(); i++) {
            User temp = userList.get(i);
            if (temp.getUserName().equals(username) && temp.getPassword().equals(password)) {
                currentUser = temp;
                return true;
            }
        }
        return false;
    }

    public void logOut(){
        flights.logout();
        hotels.logout();
        users.logout();
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
        Collections.sort(flights);
        return flights;
    }

    public ArrayList<Flight> sortMostAvailableFlights(ArrayList<Flight> flights){ // search the Flights for most available flight, return the sorted ArrayList
        String ret = "";
        while (flights.size() > 0) {
            double mostAvailable = 0;
            Flight mostAvailableFlight = null;
            int mostAvailableIndex = 0;
            for (int i = 0; i < flights.size(); i++) {
                Flight temp = flights.get(i);
                int howManySeatsLeft = howManySeatsLeft(temp);
                if (howManySeatsLeft > mostAvailable) {
                    mostAvailable = howManySeatsLeft;
                    mostAvailableFlight = temp;
                    mostAvailableIndex = i;
                }
            }
            ret += printFlight(mostAvailableFlight);
            flights.remove(mostAvailableIndex);
        }
        return ret;
        }

    public String printFlight(Flight flight){
        if (flight == null) {
            return " ";
        }
        String flightString = ("Flight type: " + flight.getFlightType() + '\n' + "Departure Airport: " + flight.getDepartureAirport() +
            '\n' + "Arrival Airport: " + flight.getArrivalAirport() + '\n' + "Total Travel Time: "
            + calculateFlightTime(flight.getDepartureTime(), flight.getArrivalTime()) + '\n' + "Number of Stops: " + flight.getStops() + '\n' + "Price: " + flight.getPrice());
        return flightString;
    }

    public String calculateFlightTime(int departTime, int arrivalTime){
        int totalMinutes;
        int hours;
        int minutes;
        departTime = ((departTime / 100) * 60) + (departTime % 100);
        arrivalTime = ((arrivalTime / 100) * 60) + (arrivalTime % 100);
        totalMinutes = departTime - arrivalTime;
        hours = Math.abs(totalMinutes / 60);
        minutes = Math.abs(totalMinutes % 60);
        String total = "Total Time " + hours + " Hours " + minutes + " Minutes";
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

    public String printSortedFlights(ArrayList<Flight> tempArr){
        String sortedFlights = "";
        for(int i = 0; i < tempArr.size(); i++) {
            sortedFlights += (i + 1) + ") " + printFlight(tempArr.get(i)) + "\n";
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
        String hotelString = ("Hotel Name: " + hotel.getName() + '\n' + "Hotel price: " + hotel.getPrice() + '\n' 
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
        for (int i = 0; i < flightList.size(); i++) {
            Flight temp = flightList.get(i);
            // Check to see how many seats are available
            int seatsLeft = howManySeatsLeft(temp);
            if (seatsLeft >= numTickets && destinationCity.equalsIgnoreCase(temp.getDestination()) && departCity.equalsIgnoreCase(temp.getDepartureCity())) {
                validFlights.add(temp);
            }
        }
        return validFlights;
    }

    public int howManySeatsLeft(Flight flight) {
        ArrayList<Seat> seats = flight.getSeat();
        int seatsLeft = 0;
        for (int j = 0; j < seats.size(); j++) {
            if (seats.get(j).getIsAvailable()) {
                seatsLeft++;
            }
        }
        return seatsLeft;
    }

    public boolean pickedSeat(Flight flight, String seat) {
        return false;
    }

    public String showSeats(Flight flight) { //should this be done in the UI
        String output = "  A B C  D E F";
        int rows = 10;
        int cols = 6;
        ArrayList<Seat> seats = flight.getSeat();
        char[][] seatsChart = new char[rows][cols]; // will change to adapt

        for (int i = 0; i < seats.size(); i++) {
            Seat temp = seats.get(i);
            if (temp.getIsAvailable()) {
                seatsChart[temp.getRow()][temp.getCol()] = 'O';
            } else {
                seatsChart[temp.getRow()][temp.getCol()] = 'X';
            }
        }
        for (int i = 0; i < seatsChart.length; i++) {
            output += "\n" + (i + 1) + " ";
            for (int j = 0; j < seatsChart[i].length; j++) {
                output += seatsChart[i][j] + " ";
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
