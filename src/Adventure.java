import java.util.Scanner;

public class Adventure {
    public static void start(Map map) {

        Scanner scanner = new Scanner(System.in);
        String input;


        while (true) {
            // Room info
            boolean roomChanged = false;
            UserInterface.printWelcome(map.getCurrentRoom());

            // Await player input
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.print(": ");
            input = scanner.nextLine();

            map.setNext(null);

            boolean triedToMove = false;
            boolean goingBack = false;
            switch (input.toLowerCase()) {
                case "go north":
                    triedToMove = true;
                    map.setNext(map.getCurrentRoom().getNorth());
                    break;
                case "go south":
                    triedToMove = true;
                    map.setNext(map.getCurrentRoom().getSouth());
                    break;
                case "go east":
                    triedToMove = true;
                    map.setNext(map.getCurrentRoom().getEast());
                    break;

                case "go west":
                    triedToMove = true;
                    map.setNext(map.getCurrentRoom().getWest());
                    break;
                case "go back":
                    triedToMove = true;
                    goingBack = true;
                    map.setNext(map.getPreviousRoom());
                    break;

                case "xyzzy":
                    if(map.getXyzzy() == null) {
                        triedToMove = true;
                        map.setXyzzy(map.getCurrentRoom());
                        map.setNext(map.getRoom1());
                        break;

                    }
                    else {
                        triedToMove = true;
                        map.setNext(map.getXyzzy());
                        map.setXyzzy(map.getCurrentRoom());
                        break;
                    }



                case "turn on light":
                    map.getCurrentRoom().turnOnLight();
                    break;
                case "turn off light":
                    map.getCurrentRoom().turnOffLight();
                    break;
                case "help":
                    UserInterface.printHelp();
                    break;
                case "look":
                    UserInterface.printRoomDescription(map.getCurrentRoom());
                    break;
                case "exit":

                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid command!");
                    break;
            }

            if (triedToMove) {
                if (map.getCurrentRoom().isDark() && !goingBack) {
                    System.out.println("It's too dark to navigate. You can only go back.");
                } else if (map.getNext() == null) {
                    System.out.println("That's not a valid direction");
                } else {
                    roomChanged = true;
                }
            }

            if (roomChanged) {
                map.setPreviousRoom(map.getCurrentRoom());
                map.setCurrentRoom(map.getNext());
            }


        }
    }
}

