import static org.junit.Assert.assertSame;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


class UsersTest{
    private ArrayList<User> userList = Users.getUsers();
    private UUID uuID = UUID.randomUUID(); 

   @Before
   public void setUp(){
       userList.add(new User( uuID, "Austin", "01-01-2001", "cap", "password", null, null, null));
        DataWriter.saveUsers();
    }

    @After
    public void tearDown(){
        DataWriter.saveFlight();
    }

    @Test 
    public void testAddUser(){
        User austin = new User( uuID, "Austin", "01-01-2001", "cap", "password", null, null, null);
        assertSame(userList.get(0), austin);
    }
 }