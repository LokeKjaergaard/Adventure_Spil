import java.util.Scanner;

public class Adventure {
    public static void start(){
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

        room2.setWest(room1);
        room2.setEast(room3);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);

        room6.setNorth(room3);
        room6.setSouth(room9);

        room7.setNorth(room4);
        room7.setEast(room8);

        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);

        room9.setNorth(room6);
        room9.setWest(room8);

        Scanner scanner = new Scanner(System.in);
        String input;


        Room next = null;


        while (true) {
            // Room info

            if (!currentRoom.isVisited()){
                System.out.println("You are in " + currentRoom.getName() + ", " + currentRoom.getDescription());
                currentRoom.makeVisited();
            } else System.out.println("You are in " + currentRoom.getName());
            currentRoom.printConnectedRooms();

            // Await player input
            System.out.println();
            System.out.print("What do you want to do?");
            input = scanner.nextLine();

            // Check player input and do action
            if (input.equalsIgnoreCase("Go east")) {
                next = currentRoom.getEast();
                if (next != null) {
                    currentRoom = next;
                } else System.out.println("You cannot go that way!");
            }
            else if (input.equalsIgnoreCase("Go west")) {
                next = currentRoom.getWest();
                if (next != null) {
                    currentRoom = next;
                } else System.out.println("You cannot go that way!");
            }
            else if (input.equalsIgnoreCase("Go north")) {
                next = currentRoom.getNorth();
                if (next != null) {
                    currentRoom = next;
                } else System.out.println("You cannot go that way!");

            } else if (input.equalsIgnoreCase("Go south")) {
                next = currentRoom.getSouth();
                if (next != null) {
                    currentRoom = next;
                } else System.out.println("You cannot go that way!");

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
                case "help":
                    UserInterface.printHelp();
                    break;
                case "look":
                    System.out.println(currentRoom.getDescription());
                    break;

                case "exit":
                    break;

                default:
                    System.out.println("That direction is not possible");
                    break;

            }

            if (next != null) {
                currentRoom = next;
            } else System.out.println("You cannot go that way!");

            }
        }
    }
