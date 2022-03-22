
/**
 * A User Interface for the booking system
 * @author Sophie Azula 
 */

import java.util.Scanner;

public class UI {
    private static final String WELCOME = "Welcome to Syntax Errorz Beautiful Booking System.\n";
    private String[] loginOptions = { "Login", "Continue as guest" };
    private String[] mainOptions = { "Book a flight", "Book a hotel", "View Account", "Log out" };
    private String[] sortingOptions = { "Find cheapest", "Find most available" };
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
                    bookingFacade.saveData();
                    quit = true;
            }
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * Method to pick a sorting method (1 = cheapest, 2 = most available)
     * 
     * @return Integer of sorting method
     */
    public int pickSortingMethod() {
        System.out.println("How would you like to sort your options?");
        for (int i = 0; i < sortingOptions.length; i++) {
            System.out.println("(" + (i + 1) + ") " + sortingOptions[i]);
        }
        return scanner.nextInt();
    }

    /**
     * Method to book a flight
     */
    public void BookFlight() {
        System.out.print("Input the following\nDestination City: ");
        String destinationCity = scanner.next();
        System.out.print("Depart Airport: ");
        String departAirport = scanner.next();

        System.out.println("How would you like to sort the flights?");
        Flight flight= new Flight();

        switch (pickSortingMethod()) {
            case (1):
                flight = bookingFacade.searchCheapestFlight(destinationCity, departAirport);
                break;
            case (2):
                flight = bookingFacade.searchMostAvailableFlight(destinationCity, departAirport);
                break;
            default:
                System.out.println("Sorry, there are no available flights");
                break;
        }

        if (flight!= null) { // how to check if its just a default?
            // flight.printFlight();
            System.out.println("Would you like to book this flight? (Y/N)");
            String input = scanner.next();

            if (input.equals("Y") || input.equals("y")) {
                SeatPicker(Flight flight);
                // FlightTicket ticket = SeatPicker();
                // add flight to user
            }
        }
    }

    /**
     * Method to pick a seat
     * 
     * @return The flight at the requested location
     */
    public FlightTicket SeatPicker(Flight flight) {
        flight.showSeats();
        System.out.print("Please pick which seat you would like\nInput the row: ");
        int row = scanner.nextInt();
        System.out.print("Input the column: ");
        int col = scanner.nextInt();
<<<<<<< HEAD


        flight.getSeat()[row][col];

        // Seat.isSeatAvailable();
=======
        String[][] newSeat = new String[row][col];
        if(Seat.isSeatAvailable(newSeat) == true) {
            System.out.println("Booking your seat.");
        }
        else {
            System.out.println("That seat is already taken, please select another seat.");
        }
>>>>>>> 38b706d4ab8be8a5eb9b7375d23b3b6e5385a952

        // return the flight ticket, update the double array
        return null; // for compiling sake
    }

    /**
     * Display the seats in a 2x2 matrix
     * Note: X represents booked, O represents open
     * 
     * @return A 2x2 matrix of seats on this flight
     */
    public void showSeats(Flight flight) {
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

    public int getUserInput(){ // rather than system.in for every input 
        return 0
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
 * Get done later
 */

// public void RoomPicker(){}
// public void DurationOfStay(){}
// public void BedScreen(){}
// public void SearchHotel(){}
// public void BookHotel(){}
// public void SignUp(){}
// public void LoginAsGuest(){}
// public void Exit(){}
// public void FamilyMember(){}
// public void ViewAccount(){}