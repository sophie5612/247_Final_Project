import java.util.ArrayList;
import java.util.UUID;

public class Users {
    
    private static Users users = null;
    private static ArrayList<User> userList;

    private Users() {
        userList = DataLoader.loadUsers();
    }

    public static Users getInstance() {
        if (users == null) {
            users = new Users();
        }
        return users;
    }

    public static ArrayList<User> getUsers() {
        return userList;
    }

    public static void addUser(UUID ID, String name, String DOB, String userName, String passWord, ArrayList<String> flightData, ArrayList<String> hotelData, ArrayList<FamilyMember> familyList) {
        userList.add(new User(ID, name, DOB, userName, passWord, flightData, hotelData, familyList));
    }

    public static void addUser(User user) {
        userList.add(user);
    }

    public static void logout() {
        DataWriter.saveUsers();
    }

}
