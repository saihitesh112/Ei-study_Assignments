public interface Command {
    void execute();
}

public class BookRoomCommand implements Command {
    private Room room;

    public BookRoomCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        if (!room.isOccupied()) {
            room.setOccupied(true);
            System.out.println("Room " + room.getId() + " booked.");
        } else {
            System.out.println("Room " + room.getId() + " is already booked.");
        }
    }
}

public class CancelRoomCommand implements Command {
    private Room room;

    public CancelRoomCommand(Room room) {
        this.room = room;
    }

    @Override
    public void execute() {
        if (room.isOccupied()) {
            room.setOccupied(false);
            System.out.println("Booking for Room " + room.getId() + " cancelled.");
        } else {
            System.out.println("Room " + room.getId() + " is not booked.");
        }
    }
}
