
/**
 * A User Interface for the booking system
 * @author Sophie Azula 
 */

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
    }

    /**
     * 
     */
    public void BookFlight() {
        String destinationCity = " ";
        String departAirport = " ";
        System.out.println("Input the following:\nDestination City: ");
        destinationCity = scanner.nextLine();
        departAirport = scanner.nextLine();
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
     * TO DO FOR SPRINT
     */

    public void TicketHistory() {
    }

    public void FrequentFlier() {
    }

    public void SearchFlight() {
    }

    public void Pet() {
    }

    public void SeatPicker() {
    }

    public void PrintInformation() {
    }

    /**
     * Extra in progress
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