import java.util.Date;
import java.util.UUID;

/**
 * @author Sophie Azula
 */

public class User {
    private UUID ID;
    private String name;
    private Date DOB;
    private String address;
    private int age;

    /**
     * A default constructor for User
     */
    public User(){
        this.ID = UUID.randomUUID();
        this.name = " ";
        this.DOB = new Date();
        this.address = " ";
        this.age = 0; 
    }

    /**
     * A parameterized constructor for USer
     * @param ID
     * @param name
     * @param DOB
     * @param address
     * @param age
     */
    public User(UUID ID, String name, Date DOB, String address, int age){
        this.ID = ID;
        this.name = name;
        this.DOB = DOB;
        this.address = address;
        this.age = age;
    }
}
