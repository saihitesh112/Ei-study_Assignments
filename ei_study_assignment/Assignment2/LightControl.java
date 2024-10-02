public interface RoomObserver {
    void update(Room room);
}

public class LightControl implements RoomObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            System.out.println("Lights turned on for Room " + room.getId());
        } else {
            System.out.println("Lights turned off for Room " + room.getId());
        }
    }
}

public class ACControl implements RoomObserver {
    @Override
    public void update(Room room) {
        if (room.isOccupied()) {
            System.out.println("AC turned on for Room " + room.getId());
        } else {
            System.out.println("AC turned off for Room " + room.getId());
        }
    }
}

public class Room {
    private int id;
    private int maxCapacity;
    private boolean occupied;
    private List<RoomObserver> observers = new ArrayList<>();

    public Room(int id) {
        this.id = id;
    }

    public void addObserver(RoomObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RoomObserver observer) {
        observers.remove(observer);
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
        notifyObservers();
    }

    public boolean isOccupied() {
        return occupied;
    }

    private void notifyObservers() {
        for (RoomObserver observer : observers) {
            observer.update(this);
        }
    }

    public int getId() {
        return id;
    }
}
