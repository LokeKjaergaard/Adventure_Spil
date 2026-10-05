import java.util.Scanner;
import java.util.ArrayList;

public class Adventure {
    public static void start(Map map) {

        UserInterface ui = new UserInterface("UI 1");
        Scanner scanner = new Scanner(System.in);
        String input;

        //Items in rooms
        map.addRandomItems();

        Player player = new Player("John Doe", map.getRoom1());

        ui.printTests();

        while (true) {
            // Room info
            boolean roomChanged = false;
            ui.printWelcome(map.getCurrentRoom());

            input = UserInterface.awaitInput(scanner, "What do you want to do?");

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1].trim() : "";

            map.setNext(null);

            boolean triedToMove = false;
            boolean goingBack = false;
            switch (command.toLowerCase()) {
                case "go":
                    switch (argument) {
                        case "north":
                            triedToMove = true;
                            map.setNext(player.getCurrentRoom().getNorth());
                            break;
                        case "south":
                            triedToMove = true;
                            map.setNext(player.getCurrentRoom().getSouth());
                            break;
                        case "east":
                            triedToMove = true;
                            map.setNext(player.getCurrentRoom().getEast());
                            break;
                        case "west":
                            triedToMove = true;
                            map.setNext(player.getCurrentRoom().getWest());
                            break;
                        case "back":
                            triedToMove = true;
                            goingBack = true;
                            map.setNext(map.getPreviousRoom());
                            break;
                    }
                    break;


                case "xyzzy":
                    if (map.getXyzzy() == null) {
                        triedToMove = true;
                        map.setXyzzy(map.getCurrentRoom());
                        map.setNext(map.getRoom1());
                        break;

                    } else {
                        triedToMove = true;
                        map.setNext(map.getXyzzy());
                        map.setXyzzy(map.getCurrentRoom());
                        break;
                    }

                case "turn":
                    switch (argument){
                        case "on light":
                            player.getCurrentRoom().turnOnLight();
                            break;
                        case "off light":
                            player.getCurrentRoom().turnOffLight();
                            break;
                    }
                    break;
                case "help":
                    ui.printHelp();
                    break;
                case "inventory":
                    ui.listItems(player.getItems(), "your inventory");
                    break;
                case "take":
                    String itemName = argument;

                    if (itemName.isEmpty()) {
                        System.out.println("Invalid item name");
                    } else {

                        Item item = player.getCurrentRoom().findItemByShortName(itemName);
                        if (item != null) {
                            player.addItem(item, player.getCurrentRoom());
                            System.out.println("You took the item");
                        } else System.out.println("That item is not in this room");
                    }
                    break;
                case "drop":
                    if (argument.isEmpty()) {
                        System.out.println("Invalid input");
                    } else {
                        Item item = player.findItemByShortName(argument);
                        if (item != null) {
                            player.removeItem(item);
                            System.out.println("You took the item");
                        } else System.out.println("That item is not in this room");
                    }
                case "equip":
                    player.equip(argument);
                    break;
                case "health":
                    ui.printPlayerHealth(player);
                    break;
                case "eat":
                    ui.eat(player, argument);
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

