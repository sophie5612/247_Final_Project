
/**
 * A User Interface for the booking system
 * @author Sophie Azula 
 */

import java.util.Scanner;
import java.util.ArrayList;

public class UI {
    private static final String WELCOME = "Welcome to Syntax Errorz Beautiful Booking System.\n";
    private String[] loginOptions = { "Login", "Continue as guest" };
    private String[] mainOptions = { "Book a flight", "Book a hotel", "View Account", "Log out" };
    private String[] flightSortingOptions = { "Find cheapest", "Find most available" };
    private String[] hotelSortingOptions = { "Find cheapest", "Find highest rated" };
    private Scanner scanner;
    private User user; // the user that will be operating this account
    private BookingFacade bookingFacade;

    /**
     * A default constructor for UI
     */
    public UI() {
        this.scanner = new Scanner(System.in);
        this.bookingFacade = new BookingFacade();
    }

    /**
     * Main menu for the program
     */
    public void MainMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.println("What would you like to do?"); // print User's options
            for (int i = 0; i < mainOptions.length; i++) {
                System.out.println("(" + (i + 1) + ") " + mainOptions[i]);
            }

            int input = scanner.nextInt();
            System.out.println();

            switch (input) {
                case (1):
                    BookFlight();
                    break;
                case (2):
                    BookHotel();
                    break;
                // case (3):
                // ViewAccount
                case (4):
                    bookingFacade.saveData();
                    quit = true;
            }
            System.out.println();
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * Method to pick a sorting method 
     * 
     * @return Integer of sorting method
     */
    public int pickSortingMethod(String[] options) {
        System.out.println("How would you like to sort your options?");
        for (int i = 0; i < options.length; i++) {
            System.out.println("(" + (i + 1) + ") " + options[i]);
        }
        return scanner.nextInt();
    }

    /**
     * Method to book a flight
     */
    public void BookFlight() {
        System.out.print("Please input the following\nDestination City: ");
        String destinationCity = scanner.next();
        System.out.print("Depart Airport: ");
        String departAirport = scanner.next();
        System.out.println();

        ArrayList<Flight> sortedFlights= new ArrayList<Flight>();

        switch (pickSortingMethod(flightSortingOptions)) { // 1 = cheapest, 2 = most available
            case (1):
                sortedFlights = bookingFacade.sortCheapestFlights(destinationCity, departAirport);
                break;
            case (2):
                sortedFlights = bookingFacade.sortMostAvailableFlights(destinationCity, departAirport);
                break;
            default:
                System.out.println("Showing cheapest flights"); //make sure defualt sort is cheap
                break;
        }

        if (sortedFlights!= null) { // how to check if its just a default? SOS
            bookingFacade.printSortedFlights(sortedFlights);

            System.out.println("Which flight would you like to book?");
            int input = scanner.nextInt();
            if(input > 0 && input < sortedFlights.size()){ // check the number picked is in bounds
                Flight pickedFlight = sortedFlights.get(input - 1); // get the flight at the user's request
                Seat pickedSeat = SeatPicker(pickedFlight); // user picks their seat
                bookingFacade.bookFlight(pickedSeat); // book seat to user
            }
        }
    } 

    /**
     * Method to pick a seat
     * 
     * @return The flight at the requested location
     */
    public Seat SeatPicker(Flight flight) { // should this be done in the UI
        showSeats(flight);

        System.out.print("Please pick which seat you would like\nInput the row: ");
        int row = scanner.nextInt();
        System.out.print("Input the column: ");
        int col = scanner.nextInt();
        String[][] newSeat = new String[row][col];
        if (Seat.isSeatAvailable(newSeat) == true) {
            System.out.println("Booking your seat.");
        } else {
            System.out.println("That seat is already taken, please select another seat.");
        }

        // return the seat, update the double array
        return null; 
    }

    /**
     * Display the seats in a 2x2 matrix
     * Note: X represents booked, O represents open
     * 
     * @return A 2x2 matrix of seats on this flight
     */
    public void showSeats(Flight flight) { //should this be done in the UI
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
                System.out.print(seats[i][j]);
                ;
            }
        }
    }

    /**
     * Method to book a hotel
     */
    public void BookHotel(){
        System.out.print("Please input the following\nDestination City: ");
        String destinationCity = scanner.next();
        System.out.println();

        System.out.println("How would you like to sort the hotels?");
        ArrayList<Hotel> sortedHotels= new ArrayList<Hotel>();

        switch (pickSortingMethod(hotelSortingOptions)) { // 1 = cheapest, 2 = highest rated
            case (1):
                sortedHotels = bookingFacade.sortCheapestHotels(destinationCity);
                break;
            case (2):
                sortedHotels = bookingFacade.sortRatingHotels(destinationCity);
                break;
            default:
                System.out.println("Showing cheapest hotles"); //make sure defualt sort is cheap
                break;
        }

        if (sortedHotels!= null) { // how to check if its just a default? SOS
            bookingFacade.printSortedHotels(sortedHotels);

            System.out.println("Which hotel would you like to book?");
            int input = scanner.nextInt();
            if(input > 0 && input < sortedHotels.size()){ // check the number picked is in bounds
                Hotel pickedHotel = sortedHotels.get(input -1);// get the hotel at the user's request
                Room pickedRoom = RoomPicker(pickedHotel);// user picks their room
                bookingFacade.bookHotel(pickedRoom); // book room to user
            }
        }
    }

    //these two should probably be done in the facade
    public Room RoomPicker(Hotel hotel){ 
        return null;
    }

    public void showRooms(Hotel hotel){

    }

    /**
     * Method to run the program
     */
    public void run() {
        System.out.println(WELCOME);
        // Login();
        MainMenu();
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }

     /*************************************************************************************
     *
     * In progress
     */
    public void Login() {
        System.out.println("Would you like to login or continue as a guest?");
        for (int i = 0; i < loginOptions.length; i++) {
            System.out.println("(" + (i + 1) + ") " + loginOptions[i]);
        }

        int input = scanner.nextInt();
        if (input == 1) {
            // set user
        }
    }

    /**
     * Method to view the user's frequent flier status
     */
    public void FrequentFlier() {
        System.out.println("Frequent flier status: ");
        /*
         * if(RegisteredUser.frequentFlier == true){
         * System.out.println("Active");
         * } else {
         * System.out.println("Not active");
         * }
         */
    }
}