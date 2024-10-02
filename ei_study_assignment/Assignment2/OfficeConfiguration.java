public class OfficeConfiguration {
    private static OfficeConfiguration instance;
    private List<Room> rooms;

    private OfficeConfiguration() {
        rooms = new ArrayList<>();
    }

    public static synchronized OfficeConfiguration getInstance() {
        if (instance == null) {
            instance = new OfficeConfiguration();
        }
        return instance;
    }

    public void configureRooms(int roomCount) {
        for (int i = 1; i <= roomCount; i++) {
            rooms.add(new Room(i));
        }
        System.out.println("Office configured with " + roomCount + " meeting rooms.");
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
