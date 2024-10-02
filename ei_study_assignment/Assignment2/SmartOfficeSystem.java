import java.util.Scanner;

public class SmartOfficeSystem {
    public static void main(String[] args) {
        // Get the single instance of OfficeConfiguration
        OfficeConfiguration office = OfficeConfiguration.getInstance();
        
        // Setup observers (AC and lights control)
        LightControl lightControl = new LightControl();
        ACControl acControl = new ACControl();

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Enter a command:");
            String input = scanner.nextLine();
            String[] commands = input.split(" ");

            switch (commands[0]) {
                case "Config":
                    if (commands.length == 3 && commands[1].equals("room") && commands[2].equals("count")) {
                        int roomCount = Integer.parseInt(commands[3]);
                        office.configureRooms(roomCount);

                        // Attach observers (sensors) to each room
                        for (Room room : office.getRooms()) {
                            room.addObserver(lightControl);
                            room.addObserver(acControl);
                        }
                    } else if (commands.length == 5 && commands[1].equals("room") && commands[2].equals("max") && commands[3].equals("capacity")) {
                        int roomId = Integer.parseInt(commands[4]);
                        int maxCapacity = Integer.parseInt(commands[5]);
                        Room room = office.getRooms().get(roomId - 1);
                        room.setMaxCapacity(maxCapacity);
                        System.out.println("Room " + roomId + " maximum capacity set to " + maxCapacity + ".");
                    } else {
                        System.out.println("Invalid config command.");
                    }
                    break;

                case "Block":
                    if (commands.length == 5) {
                        int roomId = Integer.parseInt(commands[2]);
                        Room room = office.getRooms().get(roomId - 1);
                        Command bookCommand = new BookRoomCommand(room);
                        bookCommand.execute();
                    } else {
                        System.out.println("Invalid booking command.");
                    }
                    break;

                case "Cancel":
                    if (commands.length == 3) {
                        int roomId = Integer.parseInt(commands[2]);
                        Room room = office.getRooms().get(roomId - 1);
                        Command cancelCommand = new CancelRoomCommand(room);
                        cancelCommand.execute();
                    } else {
                        System.out.println("Invalid cancellation command.");
                    }
                    break;

                case "Add":
                    if (commands.length == 5 && commands[1].equals("occupant")) {
                        int roomId = Integer.parseInt(commands[2]);
                        int occupants = Integer.parseInt(commands[3]);
                        Room room = office.getRooms().get(roomId - 1);
                        if (occupants >= 2) {
                            room.setOccupied(true);
                            System.out.println("Room " + roomId + " is now occupied by " + occupants + " persons.");
                        } else {
                            room.setOccupied(false);
                            System.out.println("Room " + roomId + " occupancy insufficient to mark as occupied.");
                        }
                    } else {
                        System.out.println("Invalid occupant command.");
                    }
                    break;

                case "Exit":
                    running = false;
                    break;

                default:
                    System.out.println("Unknown command.");
                    break;
            }
        }
        scanner.close();
    }
}
