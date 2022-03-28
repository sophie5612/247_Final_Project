import java.util.*;
/**
 * @author Ben Goodman
 */
public class Hotel {
    protected int row;
    protected int col;
    private UUID ID;
    private Date checkInDate;
    private Date checkOutDate;
    private String nameOfHotel; 
    private boolean noSmoking;
    private boolean hasPool;
    private double price;
    private ArrayList<Room> rooms;
    private int rating;

    public Hotel(){
        this.ID = UUID.randomUUID();
        this.nameOfHotel = " ";
        this.checkInDate = new Date();
        this.checkOutDate = new Date();
        this.noSmoking = false;
        this.hasPool = false;
        this.rating = 0;
    }

    public Hotel(UUID ID, String namOfHotel, int rating, Date checkInDate, Date checkOutDate, boolean noSmoking, ArrayList<Room> rooms, boolean hasPool){
            this.ID = ID;
            this.nameOfHotel = namOfHotel;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.noSmoking = noSmoking;
            this.rooms = rooms;
            this.hasPool = hasPool;
            this.rating = rating;
        }

    public UUID getUuid() {
        return ID;
    }
    public String getHotel() {
        return nameOfHotel;
    }
    public Date getCheckinDate() {
        return checkInDate;
    }
    public Date getCheckoutDate() {
        return checkOutDate;
    }
    public boolean getSmoking() {
        return noSmoking;
    }
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    public boolean getPool() {
        return hasPool;
    }
    public double getPrice() {
        return price;
    }
    public int getRatings() {
        return rating;
    }
}

