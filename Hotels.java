import java.util.*;

public class Hotels {

    private static Hotels hotels = null;
    private static ArrayList<Hotel> hotelList;

    private Hotels() {
        hotelList = DataLoader.loadHotels();
    }

    public static Hotels getInstance() {
        if (hotels == null) {
            hotels = new Hotels();
        }

        return hotels;
    }

    public static ArrayList<Hotel> getHotels() {
        return hotelList;
    }

    public void addHotel(UUID ID, String namOfHotel, boolean hasPool, double price, double rating, ArrayList<Room> rooms, String city) {
        hotelList.add(new Hotel(ID, namOfHotel, hasPool, price, rating, rooms, city));
    }

    public static void logout() {
        DataWriter.saveHotels();
    }
}
