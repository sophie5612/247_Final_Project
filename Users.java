/**
 * @author Sophie Azula
 */
import java.util.Date;
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

    public static void addUser(String name, Date DOB, String username, String password) {
        userList.add(new RegisteredUser(name, DOB, username, password));

    }

    public void logout() {
        DataWriter.saveUser();
    }
}
