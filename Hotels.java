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
    /**
     * A method that adds a new hotel
     * @param ID a new hotel id
     * @param namOfHotel a new name of a hotel
     * @param hasPool a boolean that returns true if the hotel has a pool
     * @param price the hotel price
     * @param rating the hotel rating
     * @param rooms the list of rooms that a hotel has
     * @param city the city a hotel is in
     */
    public void addHotel(UUID ID, String namOfHotel, boolean hasPool, double price, double rating, ArrayList<Room> rooms, String city) {
        hotelList.add(new Hotel(ID, namOfHotel, hasPool, price, rating, rooms, city));
    }

    public static void logout() {
        DataWriter.saveHotels();
    }
}
