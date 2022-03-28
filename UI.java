
/**
 * A User Interface for the booking system
 * @author Sophie Azula 
 */

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UI {
    private static final String WELCOME = "Welcome to Syntax Errorz Beautiful Booking System.\n";
    private String[] loginOptions = { "Login", "Sign up" };
    private String[] mainOptions = { "Book a flight", "Book a hotel", "View Account", "Log out" };
    private String[] flightSortingOptions = { "Find cheapest", "Find most available" };
    private String[] hotelSortingOptions = { "Find cheapest", "Find highest rated" };
    private Scanner scanner;
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
     * Method to log a user in or create account
     * @throws ParseException
     */
    public void Login() throws ParseException {
        System.out.println("What would you like to do?");
        for (int i = 0; i < loginOptions.length; i++) {
            System.out.println("(" + (i + 1) + ") " + loginOptions[i]);
        }

        int input = scanner.nextInt();

        System.out.println("Please input the following information");
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();
        if (input == 1) {
            bookingFacade.login(username, password);
        } else {
           System.out.println("Please input the following information");
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("DOB (Format)");
            String StringDOB = scanner.next();
            Date DOB = new SimpleDateFormat().parse(StringDOB);
            bookingFacade.signUp(name, DOB, username, password);
        }
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
        System.out.println("Please input the following");
        System.out.print("Destination City: ");
        String destinationCity = scanner.next();
        System.out.print("Depart City: ");
        String departCity = scanner.next();
        System.out.println();

        System.out.println("How many tickets would you like to book?");
        int numTickets = scanner.nextInt();

        ArrayList<Flight> sortedFlights = new ArrayList<Flight>();
        sortedFlights = bookingFacade.validFlights(numTickets, destinationCity, departCity);

        if (sortedFlights.size() == 0)
            ;
        {
            System.out.println("No flights available");
            return;
        }

        switch (pickSortingMethod(flightSortingOptions)) {
            case (1):
                sortedFlights = bookingFacade.sortCheapestFlights(sortedFlights);
                break;
            case (2):
                sortedFlights = bookingFacade.sortMostAvailableFlights(sortedFlights);

                break;
            default:
                sortedFlights = bookingFacade.sortCheapestFlights(sortedFlights);
                System.out.println("Showing cheapest flights");
                break;
        }

        bookingFacade.printSortedFlights(sortedFlights); // display sorted flights

        System.out.println("Which flight would you like to book?");
        int input = scanner.nextInt();
        if (input > 0 && input < sortedFlights.size()) { // check the number picked is in bounds
            Flight pickedFlight = sortedFlights.get(input - 1); // get the flight at the user's request
            // Seat pickedSeat = SeatPicker(pickedFlight); // user picks their seat
            // bookingFacade.bookFlight(pickedSeat); // book seat to user
            System.err.println("Flight booked!");
        }
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

    /**
     * Display the seats in a 2x2 matrix
     * Note: X represents booked, O represents open
     * 
     * @return A 2x2 matrix of seats on this flight
     */
    public void showSeats(Flight flight) { // should this be done in the UI
        System.out.println(bookingFacade.showSeats(flight));
    }

    /**
     * Method to book a hotel
     */
    public void BookHotel() {
        System.out.println("Please input the following");
        System.err.println("Destination City: ");
        String destinationCity = scanner.next();
        System.out.println();

        // how many rooms would you like to book?
        // search for flights with the city and number of tickets available

        // if there are no flights that fit parameters, tell them that and quit this
        // method

        System.out.println("How would you like to sort the hotels?");
        ArrayList<Hotel> sortedHotels = new ArrayList<Hotel>();

        switch (pickSortingMethod(hotelSortingOptions)) { // 1 = cheapest, 2 = highest rated
            case (1):
                sortedHotels = bookingFacade.sortCheapestHotels(sortedHotels);
                break;
            case (2):
                sortedHotels = bookingFacade.sortRatingHotels(sortedHotels);
                break;
            default:
                System.out.println("Showing cheapest hotles"); // make sure defualt sort is cheap
                break;
        }

        if (sortedHotels != null) { // how to check if its just a default? SOS
            bookingFacade.printSortedHotels(sortedHotels);

            System.out.println("Which hotel would you like to book?");
            int input = scanner.nextInt();
            if (input > 0 && input < sortedHotels.size()) { // check the number picked is in bounds
                Hotel pickedHotel = sortedHotels.get(input - 1);// get the hotel at the user's request
                Room pickedRoom = RoomPicker(pickedHotel);// user picks their room
                bookingFacade.bookHotel(pickedRoom); // book room to user
            }
        }
    }

    // these two should probably be done in the facade
    public Room RoomPicker(Hotel hotel) {
        return null;
    }

    public void showRooms(Hotel hotel) {

    }
    

    /**
     * Method to run the program
     */
    public void run() {
        System.out.println(WELCOME);
        Login();
        MainMenu();
    }

    public void logOut() {
        bookingFacade.logOut();
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}