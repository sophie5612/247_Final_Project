
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
    private String[] mainOptions = { "Book a flight", "Book a hotel", "View Account Information", "Log out" };
    private String[] accountOptions = { "Check flight history", "Check hotel history","Print out this sessions bookings", "Main menu" };
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
     * @return quit if the boolean quit equals true the method will exit
     */
    public void MainMenu() {
        boolean quit = false;

        while (!quit) {
            printStars();
            int input = usersChoice(mainOptions, "                  Main Menu");

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
        System.out.println("Goodbye!\n");
        printStars();
        scanner.close();
    }

    /**
     * Method to log a user in or create account
     * This method alows the user to create a new user name and password of a new account or log into an
     * existing account saved in the program/
     */
    public void Login() {
        printStars();
        int input = usersChoice(loginOptions, "Please Login or Sign Up");
        System.out.println("Please enter your account information");
        System.out.print("Username: ");
        String username = scanner.next();
        System.out.print("Password: ");
        String password = scanner.next();

        if (input == 1) { // Login
            if (bookingFacade.login(username, password)) {
                System.out.print("\nLogin Successful! ");
                System.out.println("Welcome " + bookingFacade.currentUser.getName() + "\n");
            } else {
                System.out.println("Invalid Username or Password!\n");
                Login();
            }
        } else { // Sign Up
            System.out.print("Name: ");
            String name = scanner.next();
            System.out.print("DOB (dd-mm-yyyy): ");
            String DOB = scanner.next();
            bookingFacade.signUp(name, DOB, username, password);
            System.out.println("Welcome " + bookingFacade.currentUser.getName() + ".\n");
        }
    }

    /**
     * Method to pick a sorting method
     * 
     * @return Integer of sorting method
     */
    public int usersChoice(String[] options, String prompt) {
        System.out.println(prompt + "\n");
        for (int i = 0; i < options.length; i++) {
            System.out.println("(" + (i + 1) + ") " + options[i]);
        }
        System.out.print("\nChoice: ");
        int choice = scanner.nextInt();
        if (choice < 0 || choice > options.length) { // check for valid choice
            System.out.println("Not a valid input\n");
        }
        System.out.println();
        return choice;
    }

    /**
     * Method to book a flight
     * This method propts the user with a series of questions about their flight (Amount of tickets, who is going on the flight). 
     * Then, the program saves the users flight information is saved to the users account if they wish to have a copy of it.
     */
    public void BookFlight() {
        System.out.println("Let's book a flight! Please input the following");
        System.out.print("Destination City: ");
        String destinationCity = scanner.next();
        System.out.print("Depart City: ");
        String departCity = scanner.next();
        System.out.print("How many tickets would you like to book? ");
        int numTickets = scanner.nextInt();
        scanner.nextLine();
        System.out.println();

        ArrayList<String> familyMemberSelectedList = new ArrayList<String>();

        if (numTickets <= 0) { // invalid number of tickets
            System.out.println("Invalid number of tickets, please pick again");
            BookFlight();
        } else if (numTickets > 1) { // booking for others
            System.out.println("It seems you're booking a ticket for other people!");
            for (int i = 0; i < numTickets - 1; i++) {
                System.out.println("Enter the name of your guest, or if they're not listed, type \"New\"");
                System.out.println(bookingFacade.printFamilyMembers());
                System.out.print("Guest: ");
                String familyMemberInput = scanner.next();

                if (familyMemberInput.equalsIgnoreCase("New")) { // Add new family member
                    String name = addNewFamilyMember();
                    System.out.println("Horray! You added " + name + " to your flight!\n");
                    familyMemberSelectedList.add(name);
                } else if (bookingFacade.checkFamilyMember(familyMemberInput)) {// Family member found
                    familyMemberSelectedList.add(familyMemberInput);
                    System.out.println("Horray! You added " + familyMemberInput + " to your flight!\n");
                } else { // No family matching member
                    System.out.println("Invald input, please try again");
                    i--;
                }
            }
        } // booking for one

        ArrayList<Flight> sortedFlights = new ArrayList<Flight>();
        sortedFlights = bookingFacade.validFlights(numTickets, destinationCity, departCity);

        if (sortedFlights.size() == 0) {
            System.out.println("No flights available");
            return;
        }

        switch (usersChoice(flightSortingOptions, "How would you like to sort your flight options?")) {
            case (1):
                sortedFlights = bookingFacade.sortCheapestFlights(sortedFlights);
                break;
            case (2):
                sortedFlights = bookingFacade.sortMostAvailableFlights(sortedFlights);
                break;
            default:
                sortedFlights = bookingFacade.sortCheapestFlights(sortedFlights);
                System.out.println("Showing cheapest flights"); // default sort
                break;
        }
        System.out.println(bookingFacade.printSortedFlights(sortedFlights)); // display sorted flights

        System.out.println("Which flight would you like to book? Choose from flights 1 - " + sortedFlights.size());
        System.out.print("Choice: ");
        int input = scanner.nextInt();
        scanner.nextLine(); 
        Flight pickedFlight = null;

        if (input > 0 && input <= sortedFlights.size()) { // check the number picked is in bounds
            pickedFlight = sortedFlights.get(input - 1); // get the flight at the user's request
            System.out.println(
                    "\nNow that you have picked a flight, please choose a seat! The open seats are marked with O's");
        } else {
            System.out.println("\nInvalid Flight was entered, please try again");
            BookFlight();
        }

        System.out.println( "Please enter the seat(s) you would like. (Example: To get B seat in Row 3, type in 3B and hit enter.)");
        String prettyFlightBooking = "\n" + bookingFacade.printFlight(pickedFlight);

        for (int i = 0; i < numTickets; i++) {
            showSeats(pickedFlight); // display seats
            String seatPick = scanner.nextLine();
            if (bookingFacade.pickedSeat(pickedFlight, seatPick)) { // check for seat availability, set it to taken 
                System.out.println("You picked Seat: " + seatPick + "\n");
            } else {
                System.out.println("Invalid Seat please pick again");
                i--; // try again
                continue;
            }
            if(i == 0) {
                prettyFlightBooking += "\nYou are in seat " + seatPick; 
            }
            else{
                prettyFlightBooking += "\n" + familyMemberSelectedList.get(i -  1) + " is in seat " + seatPick;
            }
        }
        System.out.println("Flight is being added to your account...");
        bookingFacade.currentUser.addFlight(pickedFlight);
        bookings.add(prettyFlightBooking);

        System.out.println("Would you like to print out your flight information? (Y/N)");
        String printInput = scanner.nextLine();
        if (printInput.equalsIgnoreCase("Y")) {
            System.out.println(prettyFlightBooking); // print to user
            bookingFacade.printFlightToText(prettyFlightBooking); // print to file
        }
    }
    /**
     * A method that creates a new family member object passing in their name and DOB given by the user
     * @return name the family members name
     */
    public String addNewFamilyMember() {
        System.out.print("\nPlease input thier name: ");
        String name = scanner.next();
        System.out.print("Please input their DOB dd-mm-yyyy: ");
        String DOB = scanner.next();
        bookingFacade.currentUser.addFamilyMember(UUID.randomUUID(), name, DOB);
        return name;
    }

    /**
     * Display the seats in a 2x2 matrix
     * Note: X represents booked, O represents open
     * @param flight a flight object
     */
    public void showSeats(Flight flight) { // should this be done in the UI
        System.out.println(bookingFacade.showSeats(flight));
    }

    /**
     * Method to book a hotel
     * This method asks the user a series of questions to determine what kind of hotel they would like
     * and where they would like to book it.  Once the user has booked their hotel, they are asked if they 
     * would like to save their inforamtion.  If they do, it is saved to the users account.
     */
    public void BookHotel() {
        System.out.println("Let's book a hotel! Please input the following");
        System.err.print("Destination City: ");
        String destinationCity = scanner.next();
        System.out.println();

        ArrayList<Hotel> sortedHotels = new ArrayList<Hotel>();
        sortedHotels = bookingFacade.validHotels(destinationCity); // check enough rooms and exists
        
        if (sortedHotels.size() == 0) {
            System.out.println("No hotels available");
            return;
        }

        switch (usersChoice(hotelSortingOptions, "How would you like to sort your hotel options?")) { // 1 = cheapest, 2 = highest rated
            case (1):
                sortedHotels = bookingFacade.sortCheapestHotels(sortedHotels);
                break;
            case (2):
                sortedHotels = bookingFacade.sortRatingHotels(sortedHotels);
                break;
            default:
                sortedHotels = bookingFacade.sortCheapestHotels(sortedHotels);
                System.out.println("Showing cheapest hotles"); // default sort
                break;
        }

        System.out.println(bookingFacade.printSortedHotels(sortedHotels)); //display sorted hotels

        System.out.println("Which hotel would you like to book? Choose from the hotels 1 - " + sortedHotels.size());
        System.out.print("Choice: ");
        int input = scanner.nextInt();
        scanner.nextLine();
        Hotel pickedHotel = null;

        if (input > 0 && input <= sortedHotels.size()) { // check the number picked is in bounds
            pickedHotel = sortedHotels.get(input - 1);// get the hotel at the user's request
        } else {
            System.out.println("Invalid hotel number, please try again\n");
            BookHotel();
        }

        System.out.print("How many rooms would you like to book? ");
        int numRooms = scanner.nextInt();
        scanner.nextLine();

        System.out.print("How many beds would you like in each room? ");
        int numOfBeds = scanner.nextInt();
        scanner.nextLine();

        System.out.println("When would you like to book the room? (dd-mm-yyyy)");
        String dateBooked = scanner.nextLine();

        System.out.println("How many days would you like to book the room for?");
        int numOfDays = scanner.nextInt();
        scanner.nextLine(); 

        String roomsInformation = bookingFacade.getRoom(pickedHotel, numRooms, numOfBeds, dateBooked, numOfDays);
        System.out.println(roomsInformation);

        String prettyHotelBooking = "\n" + bookingFacade.printHotel(pickedHotel) + "\n" + roomsInformation;

        System.out.println("Hotel is being added to your account...");
        bookingFacade.currentUser.addHotel(pickedHotel);
        bookings.add(prettyHotelBooking);

        System.out.println("\nWould you like to print our your hotel information? (Y/N)");
        String printChoice = scanner.nextLine();
        if (printChoice.equalsIgnoreCase("Y")) {
            System.out.println(prettyHotelBooking); // print to user
            bookingFacade.printHotelToText(prettyHotelBooking); // print to file
        }
    }
    /**
     * This method allows the user to veiw their purchase history for flights and hotels.  Additionally, they 
     * can print out information of what they currently have booked or return to the main menu.
     * @param input An integer that determines what the user would like to do in View Account.
     */
    public void ViewAccount() {
        int input = usersChoice(accountOptions, "Viewing account information. What would you like to do?");

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
    /**
     * A method that returns flight history
     */
    public void checkFlightHistory() {
        System.out.println(bookingFacade.getFlightHistory());
    }
    /**
     * A method that returns hotel history
     */
    public void checkHotelHistory() {
        System.out.println(bookingFacade.getHotelHistory());
    }
    /**
     * A method that prints out all the hotels and flights the user currently has booked
     */
    public void printOutBookings() {
        System.out.println(bookings);
    }
    /**
     * A method that prints a list of stars to separate the title of the page and the options.
     */
    public void printStars() {
        System.out.println("***************************************************\n");
    }

    /**
     * Method to run the program
     */
    public void run() {
        printStars();
        System.out.println(
         "                   __|__"
        + "\n             *---o--(_)--o---*\n");
        System.out.println(WELCOME);

        Login();
        MainMenu();
    }
    /**
     * A method that is used to log the user out of their account and end the program
     */
    public void logOut() {
        bookingFacade.logOut();
    }
    /**
     * A method used to run a new instance of ui
     */
    public static void main(String[] args) {
        UI ui = new UI();
        ui.run();
    }
}