import java.util.*;
/**
 * @author Ben Goodman
 */
public class Hotel extends Booking {
    protected int row;
    protected int col;
    private UUID ID;
    private Date checkInDate;
    private Date checkOutDate;
    private String nameOfHotel; 
    private boolean noSmoking;
    private boolean hasPool;
    private String[][] rooms = new String[row][col];

    public Hotel(){
        this.ID = UUID.randomUUID();
        this.nameOfHotel = " ";
        this.checkInDate = new Date();
        this.checkOutDate = new Date();
        this.noSmoking = false;
        this.hasPool = false;
    }

    public Hotel(UUID ID, String namOfHotel, Date checkInDate, Date checkOutDate, boolean noSmoking, String[][] rooms, boolean hasPool){
            this.ID = ID;
            this.nameOfHotel = namOfHotel;
            this.checkInDate = checkInDate;
            this.checkOutDate = checkOutDate;
            this.noSmoking = noSmoking;
            this.rooms = rooms;
            this.hasPool = hasPool;
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
    public String[][] getRooms() {
        return rooms;
    }
    public boolean getPool() {
        return hasPool;
    }
}

