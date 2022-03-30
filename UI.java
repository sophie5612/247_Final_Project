
/**
 * A User Interface for the booking system
 * @author Sophie Azula 
 */

import java.util.Scanner;
import java.util.UUID;
import java.util.ArrayList;

public class UI {
    private Scanner scanner;
    private BookingFacade bookingFacade;
    private static final String WELCOME = "Welcome to Syntax Errorz Beautiful Booking System.\n";
    private String[] loginOptions = { "Login", "Sign up" };
    private String[] mainOptions = { "Book a flight", "Book a hotel", "View Account", "Log out" };
    private String[] accountOptions = { "Check flight history", "Check hotel history", "Print out this sessions bookings", "Main menu"};
    private String[] flightSortingOptions = { "Find cheapest", "Find most available" };
    private String[] hotelSortingOptions = { "Find cheapest", "Find highest rated" };
    private ArrayList<String> bookings = new ArrayList<String>();

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
                case (3):
                    ViewAccount();
                    break;
                case (4):
                    bookingFacade.logOut();
                    quit = true;
            }
            System.out.println();
        }
        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * Method to log a user in or create account
     */
    public void Login()  {
        System.out.println("What would you like to do?");
        for (int i = 0; i < loginOptions.length; i++) {
            System.out.println("(" + (i + 1) + ") " + loginOptions[i]);
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please input the following information");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        if (input == 1) {
            if(bookingFacade.login(username, password)) {
                System.out.println("\nLogin Successful!");
                System.out.println("Welcome " + bookingFacade.currentUser.getName() + "\n");
            } else {
                System.out.println("Username or password do not match anything in our system, please either try to login again or make a new account!\n");
                Login();
            }
        } else {
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("DOB (dd-mm-yyyy): ");
            String DOB = scanner.nextLine();
            bookingFacade.signUp(name, DOB, username, password);
            System.out.println("Welcome " + bookingFacade.currentUser.getName() + "\n");
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
        scanner.nextLine();

        // Family member stuff
        ArrayList<String> familyMemberSelectedList = new ArrayList<String>();
        if (numTickets <= 0) {
            System.out.println("Invalid number of tickets, please pick again");
            BookFlight();
        } else if (numTickets > 1) {
            System.out.println("It looks like your booking a ticket for other people!");
            for (int i = 0; i < numTickets - 1; i++) {
                System.out.println("If your trying to book a flight for someone that is not on this list please type \"New\"");
                System.out.println(bookingFacade.printFamilyMembers());
                String familyMemberInput = scanner.nextLine();
                if (familyMemberInput.equalsIgnoreCase("New")) {
                    // NEW FAMILY MEMBER
                    String name = addNewFamilyMember();
                    System.out.println("Horray! You added " + name + " to your flight!");
                    familyMemberSelectedList.add(name);
                } else if (bookingFacade.checkFamilyMember(familyMemberInput)) {
                    // FAMILY MEMBER FOUND
                    familyMemberSelectedList.add(familyMemberInput);
                    System.out.println("Horray! You added " + familyMemberInput + " to your flight!");
                } else {
                    // NO FAMILY MEMBER FOUND
                    System.out.println("Invald input, please try again");
                    i--;
                }
            }
        }
        ArrayList<Flight> sortedFlights = new ArrayList<Flight>();
        sortedFlights = bookingFacade.validFlights(numTickets, destinationCity, departCity);

        if (sortedFlights.size() == 0) {
            System.out.println("No flights available");
            return;
        }

        switch (pickSortingMethod(flightSortingOptions)) {
            case (1):
                sortedFlights = bookingFacade.sortCheapestFlights(sortedFlights);
                break;
            case (2):
                sortedFlights= bookingFacade.sortMostAvailableFlights(sortedFlights);
                break;
            default:
                sortedFlights = bookingFacade.sortCheapestFlights(sortedFlights);
                System.out.println("Showing cheapest flights");
                break;
        }
        String sortedFlightsString = bookingFacade.printSortedFlights(sortedFlights);
        System.out.println(sortedFlightsString); // display sorted flights

        System.out.println("Which flight would you like to book?");
        System.out.print("Enter number 1 - ");
        System.out.print(bookingFacade.numOfFlightOptions(sortedFlights) + "\n");
        int input = scanner.nextInt();
        Flight pickedFlight = null;
        if (input > 0 && input <= sortedFlights.size()) { // check the number picked is in bounds
            pickedFlight = sortedFlights.get(input - 1); // get the flight at the user's request
            System.out.println("\nNow that you have picked a flight, please choose a seat! The open seats are marked with O's");
        } else {
            System.out.println("\nInvalid Flight was entered, sending you back to the main menu");
            MainMenu();
        }
        System.out.println("\nPlease enter the seat(s) you would like by following this example. If I wanted the B seat in row 3 I would type in 3B then hit enter.");
        scanner.nextLine();
        ArrayList<String> selectedSeats = new ArrayList<String>();
        String prettyFlightBooking = "";
        for (int i = 0; i < numTickets; i++) {
            showSeats(pickedFlight);
            String seatPick = scanner.nextLine();
            if(i == 0) {
                prettyFlightBooking += "You are in seat " + seatPick;
            }
            //prettyFlightBooking += seatPick;
            if(i > 0) {
                for(int j = 0; j < familyMemberSelectedList.size(); j++) {
                        prettyFlightBooking += "\n" + familyMemberSelectedList.get(j) + " is in seat " + seatPick;
                }
            }
        }
        System.out.println("Flight is being added to your account, check out your User information to find your flight booking history!\n");
        bookingFacade.currentUser.addFlight(pickedFlight);
        // MAKE THE PRETTY BOOKING HERE
        //
        //
        //
        bookings.add(prettyFlightBooking);
        System.out.println("Do you want to print out your flight information? (Y/N)");
        String printInput = scanner.nextLine();
        if (printInput.equalsIgnoreCase("Y")) {
            bookingFacade.printOutFlight(prettyFlightBooking);
        }
    }

    public String addNewFamilyMember() {
        System.out.println("\nPlease input thier name: ");
        String name = scanner.nextLine();
        System.out.println("\nPlease input their DOB dd-mm-yyyy: ");
        String DOB = scanner.nextLine();
        bookingFacade.currentUser.addFamilyMember(UUID.randomUUID(), name, DOB);
        return name;
    }

    /**
     * Display the seats in a 2x2 matrix
     * Note: X represents booked, O represents open
     */
    public void showSeats(Flight flight) { // should this be done in the UI
        System.out.println(bookingFacade.showSeats(flight));
    }

    /**
     * Method to book a hotel
     */
    public void BookHotel() {
        System.out.println("Please input the following");
        scanner.nextLine();
        System.err.println("Destination City: ");
        String destinationCity = scanner.nextLine();
        System.out.println();

        ArrayList<Hotel> sortedHotels = new ArrayList<Hotel>();
        sortedHotels = bookingFacade.validHotels(destinationCity); // check enough rooms and exists
        // at a city
        if (sortedHotels.size() == 0) {
            System.out.println("No hotels available");
        }

        switch (pickSortingMethod(hotelSortingOptions)) { // 1 = cheapest, 2 = highest rated
            case (1):
                sortedHotels = bookingFacade.sortCheapestHotels(sortedHotels);
                break;
            case (2):
                sortedHotels = bookingFacade.sortRatingHotels(sortedHotels);
                break;
            default:
                System.out.println("Showing cheapest hotles");
                break;
        }

        System.out.println(bookingFacade.printSortedHotels(sortedHotels));

        System.out.println("Which hotel would you like to book?");
        int input = scanner.nextInt();
        Hotel pickedHotel = null;
        if (input > 0 && input <= sortedHotels.size()) { // check the number picked is in bounds
            pickedHotel = sortedHotels.get(input - 1);// get the hotel at the user's request
        } else {
            System.out.println("Invalid hotel number, please try again");
            BookHotel();
        }
        System.out.println("How many rooms would you like to book?");
        int numRooms = scanner.nextInt();

        System.out.println("How many beds would you like in each room?");
        int numOfBeds = scanner.nextInt();
        scanner.nextLine();

        System.out.println("When would you like to book the room? (dd-mm-yyyy)");
        String dateBooked = scanner.nextLine();

        System.out.println("How long would you like to book the room for?");
        int numOfDays = scanner.nextInt();

        String roomsInformation = bookingFacade.getRoom(pickedHotel, numRooms, numOfBeds, dateBooked, numOfDays);
        System.out.println(roomsInformation);

        scanner.nextLine();
        // MAKE THE PRETTY BOOKING HERE
        //
        //
        //
        String prettyHotelBooking = "";
        bookings.add(prettyHotelBooking);
        System.out.println("\nWould you like to print this information? (Y/N)");
        String printChoice = scanner.nextLine();
        if (printChoice.equalsIgnoreCase("y")) {
            // PRINT HOTEL INFOMRATION
            bookingFacade.printOutHotel(prettyHotelBooking);
        }
    }

    public void ViewAccount() {
        System.out.println("What would you like to do?"); // print User's options
            for (int i = 0; i < accountOptions.length; i++) {
                System.out.println("(" + (i + 1) + ") " + accountOptions[i]);
            }

            int input = scanner.nextInt();
            System.out.println();

            switch (input) {
                case (1):
                    checkFlightHistory();
                    break;
                case (2):
                    checkHotelHistory();
                    break;
                case (3):
                    printOutBookings();
                    break;
                case (4):
                    MainMenu();
            }
            System.out.println();
    }

    public void checkFlightHistory() {
        System.out.println(bookingFacade.getFlightHistory());
    }

    public void checkHotelHistory() {
        System.out.println(bookingFacade.getHotelHistory());
    }

    public void printOutBookings() {
        // Use the bookings array list to save everything to a file
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