/**
 * @author Sophie Azula
 */

public class BusinessUser extends User{
    private Login login;
    private String company;

    /**
     * A defualt constructor for a Business User
     */
    public BusinessUser(){
        super();
        this.login = new Login(" ", " ");
        this.company = " ";
    }

    /**
     * A parameterized constructor for a Business User
     * @param login
     * @param company
     */
    public BusinessUser(Login login, String company){
        super();
        this.login = login;
        this.company = company;
    }
}
