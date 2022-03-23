
/**
 * A User Interface for the booking system
 * @author Sophie Azula 
 */

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static final String WELCOME = "Welcome to Syntax Errorz Beautiful Booking System.\n";
    private String[] loginOptions = { "Login", "Continue as guest" };
    private String[] mainOptions = { "Book a flight", "Book a hotel", "View Account", "Log out" };
    private Scanner scanner;
    private User user; // the user that will be operating this account

    /**
     * A default constructor for UI
     */
    public UI() {
        this.scanner = new Scanner(System.in);
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

            switch (input) {
                case (1):
                    BookFlight();
                    break;
                // case (2):
                // BookHotel();
                // break;
                // case (3):
                // ViewAccount
                case (4):
                    quit = true;
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * Method to book a flight
     */
    public void BookFlight() {
        System.out.print("Input the following\nDestination City: ");
        String destinationCity = scanner.next();
        System.out.print("Depart Airport: ");
        String departAirport = scanner.next();

        // SearchFlight(destinationCity, departAirport)

        System.out.println("Would you like to book this flight? (Y/N)");
        String book = scanner.next();
        if (book.equals("Y")) {
            SeatPicker();
            //FlightTicket ticket = SeatPicker();
            // add flight to user
        }

        // ask if they would like a bag or a pet after booking 
    }

    /**
     * Method to search for a flight
     * 
     * @param destinationCity
     * @param departAirport
     */
    public Flight SearchFlight(String destinationCity, String departAirport) {
        // search for a flight
        return null; //for compliling sake
    }

    /**
     * Method to pick a seat
     * 
     * @return The flight at the requested location
     */
    public FlightTicket SeatPicker() {
        Seat.initalizeSeats();
        Seat.printSeats();
        System.out.println("Please pick which seat you would like\nInput the row: ");
        int row = scanner.nextInt();
        System.out.println("Input the column: ");
        int col = scanner.nextInt();
        String[][] newSeat = new String[row][col];
        if(Seat.isSeatAvailable(newSeat) == true) {
            Seat.printSeats();
            System.out.println("Booking your seat.");
        }
        else {
            System.out.println("That seat is already taken, please select another seat.");
        }

        // return the flight ticket, update the double array
        return null; //for compiling sake
    }

    /**
     * Display the seats in a 2x2 matrix
     * Note: X represents booked, O represents open
     * @return A 2x2 matrix of seats on this flight
     */
    public void showSeats(Flight flight) { 
        int rows = 6;
        int cols = 10;
        char[][] seats = new char[rows][cols]; // will change to adapt

        for(int i = 0; i < rows; i++) {
            for(int j = 0; i < cols; j++) {
                // if (flight.getSeat().isAvailable()){
                //     seats[i][j] = 'O';
                // }                
                // else{
                //     seats[i][j] = 'X';
                // }
            System.out.print(seats[i][j]);;
            }
        }
    }
 
    /**
     * Method to view flight ticket history
     */
    public void TicketHistory() {
        System.out.println("Welcome to ticket history");
        // retrieve user's past flights
        /*
         * if(Booking.getFlights() != null)
         * for(int i = 0; i < flights.length; i++){
         * System.out.println(ticket);
         * }
         * else System.out.println("You have no past tickets");
         */
    }

    /**
     * Method to view the user's frequent flier status
     */
    public void FrequentFlier() {
        System.err.println("Frequent flier status: ");
        /*
         * if(RegisteredUser.frequentFlier == true){
         * System.out.println("Active");
         * } else {
         * System.out.println("Not active");
         * }
         */
    }

    /**
     * Method to create a pet ticket
     */
    public void Pet() {
        System.out.print("Please input the weight of your pet (lbs)");
        double weight = scanner.nextDouble();
        // PetTicket petTicket = new PetTicket(weight);
        // add the ticket to the user's account
    }

    public void run() {
        System.out.println(WELCOME);
        // Login();
        MainMenu();
    }

    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }

    /**
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
