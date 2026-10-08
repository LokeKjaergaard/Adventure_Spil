import Items.Item;
import Items.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private String name;

    public UserInterface(String name) {
        this.name = name;
    }

    public void printHelp(){
        generateBorder("Possible commands");
        System.out.println("- Go North");
        System.out.println("- Go South");
        System.out.println("- Go West");
        System.out.println("- Go East");
        System.out.println("- Go back - goes back to the previous room you just were in");
        System.out.println("============================================================");
        System.out.println("- Take <item>");
        System.out.println("- Drop <item>");
        System.out.println("- Use <item>");
        System.out.println("- Eat <food>");
        System.out.println("- Equip <weapon>");
        System.out.println("=============================================================");
        System.out.println("- Health - prints your current health");
        System.out.println("- Turn on light - turns on the light in the current room");
        System.out.println("- Turn off light - turns off the light in the current room");
        System.out.println("- Look - Describe the current room");
        System.out.println("- Exit - End game");
        System.out.println("- xyzzy");
    }

    public void printRoomDescription(Room room){
        System.out.println("You look around the room. It looks like: " + room.getDescription());
    }

    public void printConnectedRooms(Room room) {
        // holds the string of all possible directions.
        String doors = "";

        // north is always the first possible value, we don't need to add a comma (,)
        if (room.getNorth() != null && room.getNorth().isVisited()) {
            doors += "north";
        }

        // add a comma (,) if it's empty
        if (room.getSouth() != null && room.getSouth().isVisited()) {
            if (doors.isEmpty()) {
                doors += "south";
            } else doors += ", south";
        }

        if (room.getEast() != null && room.getEast().isVisited()) {
            if (doors.isEmpty()) {
                doors += "east";
            } else doors += ", east";
        }

        // west is always the last value we can end the sentence with an "and" here.
        if (room.getWest() != null && room.getWest().isVisited()) {
            if (doors.isEmpty()) {
                doors += "west";
            } else doors += " and west";

        }

        if (doors.isEmpty()){

            System.out.println("Possible directions unknown. Try to go different directions to find new rooms");
        } else System.out.println("There are doors to the: " + doors + ".");

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
            } else text = "You are in " + room.getName();

        }
        generateBorder(text);

        if (!room.isDark()){
            listItems(room.getRoomItems(), "this room");
        }
        printConnectedRooms(room);

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

    public void listItems(ArrayList<Item> listItems, String text){
        int length = listItems.size();

        if (!listItems.isEmpty()) {
            System.out.println("Items in " + text + ".");
            for (int i = 0; i < length; i++){
                System.out.println("- " + listItems.get(i).getShortName() + ": " + listItems.get(i).getLongName());
            }
        } else System.out.println("There's nothing of note in " + text + ".");

    }

    public void printPlayerHealth(Player player){
        int health = player.getHealth();
        String text;

        if (health >= 100) {
            text = "you are in perfect health";
        } else if (health >= 50){
           text = "you are in good health, but avoid fighting right now";
        } else if (health >= 25){
            text = "you are wounded - find something healthy to eat";
        } else if (health >= 1) {
            text = "you are barely alive";
        } else text = "you should be dead";
        System.out.println("You have " + player.getHealth() + "/100 health. " + text + ".");
    }

    public void printTests() {
        System.out.println("=== TESTING ===");
        System.out.println();
        generateBorder("No tests");
        System.out.println();
        System.out.println("= END TESTING =");
    }

    public void eat (Player player, String argument){
        if (argument.isEmpty()) {
            System.out.println("Invalid item name");
        } else {
            EatOutcome outcome = player.eat(argument);
            EatResult result = outcome.getResult();
            int healthGain = outcome.getHealthChange();

            switch (result) {
                case NOT_FOUND:
                    System.out.println("That food tem doesn't exist in your inventory or this room!");
                    break;
                case NOT_FOOD:
                    System.out.println("That is not a food!");
                    break;
                case EATEN:
                    if (healthGain > 0) {
                        System.out.println("Yummy, you gained " + healthGain + " health!");
                    } else if (healthGain == 0) {
                        System.out.println("That food wasn't nutritious. You gained no health.");
                    } else
                        System.out.println("Ouch! That food was poison. You lose " + healthGain + " health!");
                    break;
            }
        }
    }

    public void printAttackOutcome(hitOutcome hitOutcome, String enemyShortName, Weapon weapon){

        switch (hitOutcome){
            case ENEMY_HIT -> System.out.println("You attacked '" + enemyShortName + "' Doing " + weapon.getDamage() + ".");
            case NO_ENEMY -> System.out.println("There's nothing to attack. You attack the air.");
            case NO_WEAPON -> System.out.println("You dont have a weapon equipped!");
            case ENEMY_DIED -> System.out.println("You attack the enemy. The enemy died.");
            case WEAPON_EMPTY -> System.out.println("Your weapon cannot be used!");
        }
    }

    public void printEnemyAttackOutcome(hitOutcome hitOutcome, Enemy enemy, Weapon weapon){
        switch (hitOutcome){
            case ENEMY_HIT -> System.out.println("The enemy hit you and dealt ");
            case WEAPON_EMPTY -> System.out.println("The enemy attempted to use it weapon, nothing happened.");
        }
    }
}
