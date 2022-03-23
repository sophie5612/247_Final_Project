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

    public ArrayList<Hotel> getHotels() {
        return hotelList;
    }

    public void Hotel(UUID ID, String namOfHotel, Date checkInDate, Date checkOutDate, boolean noSmoking, String[][] rooms, boolean hasPool) {
        hotelList.add(new Hotel(ID, namOfHotel, checkInDate, checkOutDate, noSmoking, rooms, hasPool));
    }

    public void logout() {
        DataWriter.saveHotel();
    }
}
