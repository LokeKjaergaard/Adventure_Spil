import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private String name;

    public UserInterface(String name) {
        this.name = name;
    }

    public void printHelp(){
        System.out.println("Possible commands:");
        System.out.println("- Go North");
        System.out.println("- Go South");
        System.out.println("- Go West");
        System.out.println("- Go East");
        System.out.println("- Go back - goes back to the previous room you just were in");
        System.out.println("- Turn on light - turns on the light in the current room");
        System.out.println("- Turn off light - turns off the light in the current room");
        System.out.println("- Look - Describe the current room");
        System.out.println("- Exit - End game");
    }

    public void printRoomDescription(Room room){
        System.out.println("You look around the room. It looks like: " + room.getDescription());
    }

    public void printWelcome(Room room){
        String text;

        System.out.println();
        if (room.isDark()) {
            text = "The room is dark you cant see anything";
            if (!room.isVisited()){
                room.makeVisited();
            }
        } else {
            if (!room.isVisited()) {
                text = "You are in " + room.getName() + ", " + room.getDescription();
                room.makeVisited();
            } else text = "You are in " + room.getName();

        }
        generateBorder(text);

        printRoomItems(room);
    }

    public void generateBorder(String text){
        String border = "";
        int length = text.length();

        for (int i = 0; i < length; i++){
            border += "-";
        }
        border = ("*-" + border + "-*");
        System.out.println(border);
        System.out.println("| " + text + " |");
        System.out.println(border);
    }
    public static String awaitInput(Scanner scanner, String text){
        // Await player input
        System.out.println();
        System.out.println(text);
        System.out.print("> ");
        return scanner.nextLine();
    }

    public void printRoomItems(Room room){
        ArrayList<Item> list = room.getRoomItems();
        int length = room.getRoomItems().size();

        if (!list.isEmpty()) {
            System.out.println("Items in this room:");
            for (int i = 0; i < length; i++){
                System.out.println("-" + list.get(i).getLongName());
            }
        } else System.out.println("There's nothing of note in this room.");

    }
}
