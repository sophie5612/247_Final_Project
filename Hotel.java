import java.util.*;
/**
 * @author Ben Goodman
 */
public class Hotel implements Comparable<Hotel>{
    private UUID ID;
    private String nameOfHotel; 
    private boolean hasPool;
    private String city;
    private double price;
    private double rating;
    private ArrayList<Room> rooms;

    public Hotel(){
        this.ID = UUID.randomUUID();
        this.nameOfHotel = " ";
        this.hasPool = false;
        this.price = 0.0;
        this.city = "";
        this.rating = 0;
        this.rooms = null;
    }

    public Hotel(UUID ID, String namOfHotel, boolean hasPool, double price, double rating, ArrayList<Room> rooms, String city){
            this.ID = ID;
            this.nameOfHotel = namOfHotel;
            this.hasPool = hasPool;
            this.price = price;
            this.rating = rating;
            this.rooms = rooms;
            this.city = city;
        }

    public UUID getUuid() {
        return ID;
    }
    public String getName() {
        return nameOfHotel;
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
    public double getRatings() {
        return rating;
    }
    public String getCity() {
        return city;
    }

    public int compareTo(Hotel hotel) {
        if (price == hotel.price) {
            return 0;
        } else if (price > hotel.price) {
            return 1;
        } else {
            return -1;
        }
    }
}

