/**
 * A facade for our Booking System
 * @author Sophie Azula
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
import java.util.Collections;

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
    /**
     * A method that is used to create a new user in the json
     * @param name the name of the user
     * @param DOB the date of birth of the user
     * @param username the username for the user
     * @param password the password for the user
     */
    public void signUp(String name, String DOB, String username, String password){
        currentUser = new User(UUID.randomUUID(), name, DOB, username, password, new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>());
        Users.addUser(currentUser);
    }
    /**
     * A method that logs a user in if the username and password match what is stored in the json
     * @param username the users username 
     * @param password the users password
     * @return true if the information is valid or false if the information is invalid
     */
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
    /**
     * A method that logs the user out of the program and saves all of their changes.
     */
    public void logOut(){
        Flights.logout();
        Hotels.logout();
        Users.logout();
    }
    /**
     * A method that uses collection sort to sort a list of flights based on their price.
     * @param flights The Arraylist of total flights from a departure locations to and arrival location
     * @return flights the in order
     */
    public ArrayList<Flight> sortCheapestFlights(ArrayList<Flight> flights){ // search the Flights for cheapest flight, return the sorted ArrayList
        Collections.sort(flights);
        return flights;
    }
    /**
     * A method that sorts flights based on how many seats are left on the plane.
     * @param flights The ArrayList of all flights from a specified departure and arrival location
     * @return ret A new arraylist sorted by most available flights.
     */
    public ArrayList<Flight> sortMostAvailableFlights(ArrayList<Flight> flights){ // search the Flights for most available flight, return the sorted ArrayList
        ArrayList<Flight> ret = new ArrayList<Flight>();
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
            ret.add(mostAvailableFlight);
            flights.remove(mostAvailableIndex);
        }
        return ret;
        }
    /**
     * A method that prints all the information for a flight
     * @param flight a flight
     * @return flightString a new string that displays all the information about a flight
     */
    public String printFlight(Flight flight){
        if (flight == null) {
            return " ";
        }
        String flightString = ("\nDeparture Airport: " + flight.getDepartureAirport() +
            '\n' + "Arrival Airport: " + flight.getArrivalAirport() + '\n' + "Departure City(s): " + flight.getDepartureCity() + '\n' +
            "Arrival City: " + flight.getDestination() + '\n' + "Total Travel Time: "
            + calculateFlightTime(flight.getDepartureTime(), flight.getArrivalTime()) + '\n' + "Price: " + flight.getPrice() + '\n' + "Stops: " + flight.getStops());
        return flightString;
    }
    /**
     * A method that saves what flight the user booked and its information to a new text file.
     * @param text A string of text to be saved to a text file.
     */
    public void printOutFlight(String text) {
        try {
            File myObj = new File("FlightTicket.txt");
            myObj.createNewFile();
                // Create File
            FileWriter myWriter = new FileWriter("FlightTicket.txt");
            // WIRTE FLIGHT INFORMATION
            myWriter.write(text);
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    /**
     * A method that prints all the information about a hotel to a new text file
     * @param text A string of text to be saved to a text file.
     */
    public void printOutHotel(String text) {
        try {
            File myObj = new File("HotelInfo.txt");
            myObj.createNewFile();
                // Create File
            FileWriter myWriter = new FileWriter("HotelInfo.txt");
            // WIRTE FLIGHT INFORMATION
            myWriter.write(text);
            myWriter.close();
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }
    /**
     * A method that determines the total amout of time the flight will take
     * @param departTime a given depart time for a flight
     * @param arrivalTime a given arrival time for a flight
     * @return the amount of time that the flight will take to get to its destination.
     */
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
    /**
     * A method that converts 12 hour time to 24 hour time
     * @param time a given integer of time
     * @return timeConvert a converted 12 hour time in AM or PM to a 24 hour time
     */
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
    /**
     * A method that prints out the flights that have been sorted and labels them 
     * @param tempArr A new temporary arry of all flights the user is interested in (based on departure location
     * and arrival location)
     * @return sortedFlights flights sorted based on user specification
     */
    public String printSortedFlights(ArrayList<Flight> tempArr){
        String sortedFlights = "";
        for(int i = 0; i < tempArr.size(); i++) {
            sortedFlights += (i + 1) + ") " + printFlight(tempArr.get(i)) + "\n";
        }
        return sortedFlights;
    }
    /**
     * A method that tells the user the ammount of flights that can be booked
     * @param tempArr A temp arraylist of all the flights the user is interested in.
     * @return i where i is the amount of flights in the ArrayList
     */
    public int numOfFlightOptions(ArrayList<Flight> tempArr) {
        int i = tempArr.size();
        return i;
    }
    /**
     * A method that returns A sorted arraylist of hotels based on price using collection sort.
     * @param hotels an ArrayList of the total amount of hotels the user is interested in
     * @return hotels the sorted ArrayList of hotels based on their price
     */
    public ArrayList<Hotel> sortCheapestHotels(ArrayList<Hotel> hotels){
        Collections.sort(hotels);
        return hotels;
    }
    /**
     * A method that sort hotels based on their ratings
     * @param hotels and ArrayList of the total amount of hotels the user is interested in
     * @return validHotels the sorted ArrayList of hotels based on their ratings
     */
    public ArrayList<Hotel> sortRatingHotels(ArrayList<Hotel> hotels){
        ArrayList<Double> tempHotel = new ArrayList<Double>();
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

    public ArrayList<Hotel> validHotels(String city) {
        ArrayList<Hotel> validHotels = new ArrayList<Hotel>();
        for (int i = 0; i < hotelList.size(); i++) {
            Hotel temp = hotelList.get(i);
            if (temp.getCity().equalsIgnoreCase(city)) {
                validHotels.add(temp);
            }
        }
        return validHotels;
    }

    public String printHotel(Hotel hotel) {
        String hotelString = ("Hotel Name: " + hotel.getName() + '\n' + "Hotel price: " + hotel.getPrice() + '\n' 
            + "Rating: " + hotel.getRatings() + '\n' + "Pool?: " + hotel.getPool());
        return hotelString;
    }

    public String printSortedHotels(ArrayList<Hotel> hotels){ 
        String sortedHotels = "";
        for(int i = 0; i < hotels.size(); i++) {
            sortedHotels += "\n" + (i + 1) + ") " + printHotel(hotels.get(i));
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
            if (seatsLeft >= numTickets && destinationCity.equalsIgnoreCase(temp.getDestination()) && temp.getDepartureCity().contains(departCity)) {
                validFlights.add(temp);
            }
            // check connecting flights too
            if ((seatsLeft >= numTickets && destinationCity.equalsIgnoreCase(temp.getDestination()))) {
                // Destination matches
                ConnectedFlights connection = connectFlights(temp, departCity);
                if(connection != null) {
                    // Have a connection
                    Flight con = connection.combine();
                    // Check if the flight already exsists, if it does, do not add it
                    boolean isItThere = false;
                    for (int j = 0; j < flightList.size(); j++) {
                        if (con.getDepartureCity().equals(flightList.get(j).getDepartureCity())) {
                            isItThere = true;
                        }
                    }
                    if (!isItThere) {
                        flightList.add(con);
                        validFlights.add(con);
                    }
                }
            }
        }
        return validFlights;
    }

    public ConnectedFlights connectFlights(Flight compare, String startLocation) {
        // Create list of all connections;
        ConnectedFlights ret = new ConnectedFlights();
        ret.addFlight(compare);
        for (int i = 0; i < flightList.size(); i++) {
            Flight temp = flightList.get(i);
            if (compare.getDepartureCity().equalsIgnoreCase(temp.getDestination())) {
                if (temp.getDepartureCity().equalsIgnoreCase(startLocation)) {
                    // DONE
                    ret.addFlight(temp);
                    return ret;
                } else {
                    // ANOTHER CONNECTION
                    ret.absorb(connectFlights(temp, startLocation));
                    return ret;
                }
            }
        }
        return null;
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
        ArrayList<Seat> seats = flight.getSeat();
        if (seat.length() != 2) {
            return false;
        }
        int seatRow = Character.getNumericValue(seat.charAt(0)) - 1;
        char seatLetter = seat.charAt(1);
        int seatCol = 0;
        switch (seatLetter) {
            case('A'):
                seatCol = 0;
                break;
            case('B'):
                seatCol = 1;
                break;
            case('C'):
                seatCol = 2;
                break;
            case('D'):
                seatCol = 3;
                break;
            case('E'):
                seatCol = 4;
                break;
            case('F'):
                seatCol = 5;
                break;
        }
        for (int i = 0; i < seats.size(); i++) {
            Seat temp = seats.get(i);
            if (temp.getRow() == seatRow && temp.getCol() == seatCol && temp.getIsAvailable()) {
                temp.setSeatToTaken();
                return true;
            }
        }
        return false;
    }

    public String printFamilyMembers() {
        String ret = "";
        if (currentUser.getFamilyMembers().size() == 0) {
            return "Looks like you dont have anyone saved to your account, please type in \"New\"";
        } else {
            for (int i = 0; i < currentUser.getFamilyMembers().size(); i++) {
                ret += currentUser.getFamilyMembers().get(i).getName();
                if (i + 1 < currentUser.getFamilyMembers().size())  {
                    ret += ", ";
                }
            }
        }
        return ret;
    }

    public boolean checkFamilyMember(String famName) {
        for (int i = 0; i < currentUser.getFamilyMembers().size(); i++) {
            if (famName.equalsIgnoreCase(currentUser.getFamilyMembers().get(i).getName())) {
                return true;
            }
        }
        return false;
    }

    public String showSeats(Flight flight) { //should this be done in the UI
        String output = "   A B C  D E F";
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
            output += "\n" + (i + 1);
            if (i < 9) {
                output += "  ";
            } else {
                output += " ";
            }
            for (int j = 0; j < seatsChart[i].length; j++) {
                output += seatsChart[i][j] + " ";
                if (j == 2) {
                    output += " ";
                }
            }
        }
        return output;
    }

    public String getRoom(Hotel pickedHotel, int numRooms, int numOfBeds, String dateBooked, int numOfDays) {
        String ret = "";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = formatter.parse(dateBooked);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        c.setTime(date);
        // Making an arraylist of the days the user wants to book it for
        ArrayList<String> daysToBook = new ArrayList<String>();
        daysToBook.add(formatter.format(c.getTime()));
        for (int i = 0; i < numOfDays; i++) {
            c.add(Calendar.DATE, 1);
            daysToBook.add(formatter.format(c.getTime()));
        }
        // Check each room for their availability
        for (int i = 0; i < pickedHotel.getRooms().size(); i++) {
            Room temp = pickedHotel.getRooms().get(i);
            if (temp.getNumOfBeds() == numOfBeds && doesntContainDay(temp, daysToBook) && numRooms > 0) {
                // ROOM IS GOOD! Send data to UI and save it to user's profile, 
                ret += "\nAdded room";
                ret += printRoom(temp);
                numRooms--;
                for (int j = 0; j < daysToBook.size(); j++) {
                    temp.getBookedDates().add(daysToBook.get(j));
                }
                currentUser.addHotel(pickedHotel);
            }
        }
        if (ret.equalsIgnoreCase("")) {
            ret = "No Rooms available in this hotel";
        }
        return ret;
    }

    public String printRoom(Room room) {
        return "\nFloor: " + room.getFloor() + "\nRoom Number: " + room.getRoomNumber() + "\nNumber of beds: " + room.getNumOfBeds();
    }

    public boolean doesntContainDay(Room room, ArrayList<String> daysToBook) {
        boolean ret = true;
        for (int i = 0; i < room.getBookedDates().size(); i++) {
            String dateCheck = room.getBookedDates().get(i);
            if (daysToBook.contains(dateCheck)) {
                ret = false;
            }
        }
        return ret;
    }

    public String getFlightHistory() {
        String ret = "";
        for (int i = 0; i < currentUser.getFlightHistory().size(); i++) {
            UUID uuid = UUID.fromString(currentUser.getFlightHistory().get(i));
            // System.out.println(uuid);;
            for (int j = 0; j < flightList.size(); j++) {
                if (uuid.equals(flightList.get(j).getUuid())) {
                    ret += printFlight(flightList.get(j));
                }
            }
        }
        return ret;
    }

    public String getHotelHistory() {
        String ret = "";
        for (int i = 0; i < currentUser.getHotelHistory().size(); i++) {
            UUID uuid = UUID.fromString(currentUser.getHotelHistory().get(i));
            for (int j = 0; j < hotelList.size(); j++) {
                if (uuid.equals(hotelList.get(j).getUuid())) {
                    ret += printHotel(hotelList.get(j));
                }
            }
        }
        return ret;
    }
}
