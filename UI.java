/**
 * @author Sophie Azula
 */

public class UI {
    String welcome = "Welcome to Syntax Errorz Beautiful Booking System";
    User user;

    /**
     * A default constructor for UI
     */
    public UI(){
        this.user = new User();
    }

    /**
     * A parameterized constructor for UI
     * @param user
     */
    public UI(User user){
        this.user = user;
    }

    /**
     * UI Screens
     */
    public void MainMenu(){}
    public void SignUp(){}
    public void Login(){}
    public void LoginAsGuest(){}
    public void Exit(){}
    public void FamilyMember(){}
    public void BookFlight(){}
    public void BookHotel(){}
    public void TicketHistory(){}
    public void FrequentFlier(){}
    public void SearchFlight(){}
    public void SearchHotel(){}
    public void Pet(){}
    public void SeatPicker(){}
    public void PrintInformation(){}
    public void RoomPicker(){}
    public void DurationOfStay(){}
    public void BedScreen(){}

    public String getWelcome(){
        return welcome;
    }

    public static void main(String[] args) {

        UI ui = new UI();
        System.out.println(ui.getWelcome());
    }
}
