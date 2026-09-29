import java.util.Scanner;

public class Adventure {
    public static void start(Map map) {

        UserInterface ui = new UserInterface("UI 1");
        Scanner scanner = new Scanner(System.in);
        String input;

        Item Gun = new Item("Gun","A Sniper riffle", 4);
        Item lamp = new Item("lamp","a shiny brass lamp", 1);
        Item clothes = new Item("Shoes", "Shiny shoe", 2);

        ArrayList<Item> possibleRoomItems = new ArrayList<>();
            possibleRoomItems.add(Gun);
            possibleRoomItems.add(lamp);
            possibleRoomItems.add(clothes);

        map.addRandomItems(possibleRoomItems);

        Player player = new Player("John Doe", map.getRoom1());

        Item item1 = new Item("test", "this is a test");
        Item item2 = new Item("another", "another item");


        System.out.println("=== TESTING ===");
        player.addItem(item1);
        player.removeItem(item2);

        System.out.println("Hello " + player.getName() + "!");
        System.out.println("= END TESTING =");
        while (true) {
            // Room info
            boolean roomChanged = false;
            ui.printWelcome(map.getCurrentRoom());

            input = UserInterface.awaitInput(scanner, "What do you want to do?");

            map.setNext(null);

            boolean triedToMove = false;
            boolean goingBack = false;
            switch (input.toLowerCase()) {
                case "go north":
                    triedToMove = true;
                    map.setNext(player.getCurrentRoom().getNorth());
                    break;
                case "go south":
                    triedToMove = true;
                    map.setNext(player.getCurrentRoom().getSouth());
                    break;
                case "go east":
                    triedToMove = true;
                    map.setNext(player.getCurrentRoom().getEast());
                    break;

                case "go west":
                    triedToMove = true;
                    map.setNext(player.getCurrentRoom().getWest());
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
                    player.getCurrentRoom().turnOnLight();
                    break;
                case "turn off light":
                    player.getCurrentRoom().turnOffLight();
                    break;
                case "help":
                    ui.printHelp();
                    break;
                case "look":
                    ui.printRoomDescription(player.getCurrentRoom());
                    break;
                case "exit":

                    System.out.println("Goodbye!");
                    return;



                default:
                    System.out.println("Invalid command!");
                    break;

            }

            if (triedToMove) {
                if (player.getCurrentRoom().isDark() && !goingBack) {
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
                player.setCurrentRoom(map.getNext());
            }


        }
    }
}

