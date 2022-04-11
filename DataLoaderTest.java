import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class DataLoaderTest {
	ArrayList<User> userList = Users.getUsers();

    @BeforeEach
    public void setup() {
        userList.clear();
        userList.add(new User(UUID.randomUUID(), "bob", "02-01-1999", "bobTheMan", "bobsPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
        userList.add(new User(UUID.randomUUID(), "man", "03-05-1989", "manIsBob", "mansPass", new ArrayList<String>(), new ArrayList<String>(), new ArrayList<FamilyMember>()));
        System.out.println(userList.size());
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        Users.getInstance().getUsers().clear();
		DataWriter.saveUsers();
    }

    @Test
    public void testGetUsersSize() {
        userList = DataLoader.loadUsers();
        assertEquals(2, userList.size());
    }

    @Test
    public void teestGetUsersSizeZero() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, userList.size());
    }

    @Test
    public void testGetUserFirstUserName() {
        userList = DataLoader.loadUsers();
        assertEquals("bobTheMan", userList.get(0).getUserName());
    }

}
