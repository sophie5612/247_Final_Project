/**
 * @author Sophie Azula
 */

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;


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
    public User(String name, Date DOB){
        this.ID = UUID.randomUUID();
        this.name = name;
        this.DOB = DOB;
    }

    public UUID getID(){
        return this.ID;
    }

    public Date getDOB(){
        return this.DOB;
    }

    public String getName(){
        return this.name;
    }

    public int calculateAge(Date DOB){
        Date currentDate = new Date();
        LocalDate currentLocalDate = convertToLocalDate(currentDate);

            return Period.between(convertToLocalDate(DOB), currentLocalDate).getYears();
    }

    public LocalDate convertToLocalDate(Date date){
        return LocalDate.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
