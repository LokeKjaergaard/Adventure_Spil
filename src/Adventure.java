import java.util.Scanner;

public class Adventure {
    public static void start(Map map) {

        UserInterface ui = new UserInterface("UI 1");
        Scanner scanner = new Scanner(System.in);
        String input;

        Player player = new Player("John Doe", map.getRoom1());

        Item item1 = new Item("test", "this is a test");
        Item item2 = new Item("another", "another item");

        player.addItem(item1);
        player.removeItem(item2);

        System.out.println("Hello " + player.getName() + "!");
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
                case "take":
                    String itemName = UserInterface.awaitInput(scanner, "Write the name of the item you want to take.");
                    boolean found = false;
                    if (itemName.isEmpty()){
                        System.out.println("Invalid input");
                    } else {
                        int size = player.getCurrentRoom().getRoomItems().size();
                        for (int i = 0; i < size; i++){
                            Item roomItem = player.getCurrentRoom().getRoomItems().get(i);
                            if (roomItem.getShortName().equals(itemName)) {
                                player.addItem(roomItem);
                                player.getCurrentRoom().removeItem(roomItem);
                                found = true;
                                break;
                            }
                        }
                        if (!found){
                            System.out.println("That item is not in this room");
                        } else {
                            System.out.println("You took the item");
                        }
                        break;
                    }


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

