import java.util.Scanner;

public class Adventure {
    public static void start() {
        Room room1 = new Room("Room 1", "The entrance to the abandoned building.", false);
        Room room2 = new Room("Room 2", "An old office with a desk and some documents.", false);
        Room room3 = new Room("Room 3", "A meeting room with notes left on the board.", false);
        Room room4 = new Room("Room 4", "An old kitchen that looks like it was left in a hurry.", false);
        Room room5 = new Room("Room 5", "A storage room filled with old boxes and equipment.", false);
        Room room6 = new Room("Room 6", "A technical room with old machines and electrical panels.", false);
        Room room7 = new Room("Room 7", "An archive containing reports about an old incident.", false);
        Room room8 = new Room("Room 8", "A break room with a few personal belongings left behind.", false);
        Room room9 = new Room("Room 9", "An empty room with a strange map of the building.", false);

        Room currentRoom = room1;
        Room next;


        room1.setEast(room2);
        room1.setSouth(room4);


        room2.setEast(room3);


        room3.setSouth(room6);


        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setSouth(room9);

        room7.setEast(room8);

        room8.setEast(room9);

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            // Room info

            if (!currentRoom.isVisited()) {
                System.out.println("You are in " + currentRoom.getName() + ", " + currentRoom.getDescription());
                currentRoom.makeVisited();
            } else System.out.println("You are in " + currentRoom.getName());
            currentRoom.printConnectedRooms();

            // Await player input
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.print(": ");
            input = scanner.nextLine();

            next = null;
            switch (input.toLowerCase()) {
                case "go north":
                    next = currentRoom.getNorth();
                    break;
                case "go south":
                    next = currentRoom.getSouth();
                    break;

                case "go east":
                    next = currentRoom.getEast();
                    break;

                case "go west":
                    next = currentRoom.getWest();
                    break;

                case "turn on light":
                    currentRoom.turnOnLight();
                    break;
                case "turn off light":
                    currentRoom.turnOffLight();
                    break;

                case "help":
                    UserInterface.printHelp();
                    break;
                case "look":
                    System.out.println(currentRoom.getDescription());
                    break;

                case "exit":
                    break;

                default:
                    System.out.println("Invalid command!");
                    break;
            }

            if (next != null) {
                currentRoom = next;
            } else System.out.println("You cannot go that way! ");

        }
    }
}

