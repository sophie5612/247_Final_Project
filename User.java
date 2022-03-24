import java.util.Date;
import java.util.UUID;

/**
 * @author Sophie Azula
 */

public class User {
    private UUID ID;
    private String name;
    private Date DOB;

    /**
     * A default constructor for User
     */
    public User(){
        this.ID = UUID.randomUUID();
        this.name = " ";
        this.DOB = new Date();
    }

    /**
     * A parameterized constructor for USer
     * @param ID
     * @param name
     * @param DOB
     */
    public User(UUID ID, String name, Date DOB){
        this.ID = ID;
        this.name = name;
        this.DOB = DOB;
    }
}
