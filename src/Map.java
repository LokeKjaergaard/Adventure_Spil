import java.util.ArrayList;
import java.util.Random;

import Items.*;

public class Map {

    private Room currentRoom;
    private Room next;
    private Room previousRoom = null;
    private Room xyzzy = null;

    private Room room1 = new Room("Room 1", "The entrance to the abandoned building.", false);
    private Room room2 = new Room("Room 2", "An old office with a desk and some documents.", true);
    private Room room3 = new Room("Room 3", "A meeting room with notes left on the board.", false);
    private Room room4 = new Room("Room 4", "An old kitchen that looks like it was left in a hurry.", false);
    private Room room5 = new Room("Room 5", "A storage room filled with old boxes and equipment.", false);
    private Room room6 = new Room("Room 6", "A technical room with old machines and electrical panels.", false);
    private Room room7 = new Room("Room 7", "An archive containing reports about an old incident.", false);
    private Room room8 = new Room("Room 8", "A break room with a few personal belongings left behind.", false);
    private Room room9 = new Room("Room 9", "An empty room with a strange map of the building.", false);
    private Room room10 = new Room("Room 10", "A dark corridor with strange writings on the walls", true);
    private Room room11 = new Room("Room 11", "A small laboratory filled with old chemicals", false);
    private Room room12 = new Room("room 12", "A security room with old moniters and flickering lights", true);
    private Room room13 = new Room("Room 13", "A dark storage with old and run-down furniture", true);
    private Room room14 = new Room("Room 14", "A small, worn bathroom with a dripping faucet", false);
    private Room room15 = new Room("Room 15", "A large room with an old wooden bed placed in the middle", false);


    Item item1 = new Item("test", "this is a test", 2);
    Item item2 = new Item("another", "another item", 2);

    ArrayList<Room> roomList = new ArrayList<Room>();

    private void addRooms() {
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);
        roomList.add(room4);
        roomList.add(room5);
        roomList.add(room6);
        roomList.add(room7);
        roomList.add(room8);
        roomList.add(room9);
        roomList.add(room10);
        roomList.add(room11);
        roomList.add(room12);
        roomList.add(room13);
        roomList.add(room14);
        roomList.add(room15);
    }

    Random random = new Random();

    //List for random, objects in rooms
    ArrayList<Item> possibleRoomItems = new ArrayList<>();
    ArrayList<Enemy> possibleEnemies = new ArrayList<>();


    //ArrayList<Food> possibleRoomFood = new ArrayList<>();

    // Items
    Item lamp = new Item("lamp", "a shiny brass lamp", 1);
    Item clothes = new Item("Shoes", "Shiny shoes", 2);


    // Foods
    Food bread = new Food("bread", "a loaf of stale bread", 2, 35);
    Food mushroom = new Food("mushroom", "a pale glowing mushroom", 3, -50);
    Food pizza = new Food("PIZZA", "A delicous PIZZA", 4, 50);


    //Weapons
    Weapon sword = new MeleeWeapon("Sword", "a long rusty sword", 2, 35);
    Weapon bomb = new ExplosiveWeapon("Bomb", "a old faulty bomb?", 3, 70);
    Weapon gun = new RangedWeapon("Gun", "A Sniper riffle", 4, 45, 6);
    Weapon magicwand = new MagicWeapon("Magic Wand", "A mysterious magic wand", 5, 40, 10);


    //Enemies
    Enemy guard = new Enemy("Guard", "Security Guard", "A former security guard still protecting the abandoned building.", 100, gun, null);

    Enemy wizard = new Enemy("Scientist", "Exiled Scientist", "A scientist who seems to know more about the building than he admits.", 70, magicwand, null);

    Enemy creature = new Enemy("Creature", "Mutated Creature", "A strange creature hiding in the darkness of the basement.", 150, bomb, null);


    public void addRandom() {

        //items
        possibleRoomItems.add(lamp);
        possibleRoomItems.add(clothes);

        //food
        possibleRoomItems.add(bread);
        possibleRoomItems.add(mushroom);
        possibleRoomItems.add(pizza);

        //Weapons
        possibleRoomItems.add(sword);
        possibleRoomItems.add(bomb);
        possibleRoomItems.add(gun);

        //Enemy
        possibleEnemies.add(guard);
        possibleEnemies.add(wizard);
        possibleEnemies.add(creature);

        for (Room room : roomList) {
            for (Item possibleRoomItem : possibleRoomItems) {
                boolean b = random.nextBoolean();
                if (b) {
                    room.addItem(possibleRoomItem);

                    // System.out.println(room.getName() + " fik: " + possibleRoomItem.getShortName());
                }
            }
            for (Enemy possibleEnemy : possibleEnemies) {
                boolean a = random.nextBoolean();
                if (a) {
                    room.addEnemy(possibleEnemy);

                    //System.out.println(room.getName() + " fik " + possibleEnemy.getShortName());
                }

            }
        }

    }


    public void setupMap() {

        addRooms();
        currentRoom = room1;

        room1.addItem(item1);
        room1.setEast(room2);
        room1.setSouth(room4);

        room2.setEast(room3);
        room2.setWest(room1);

        room3.setSouth(room6);
        room3.setWest(room2);

        room4.setSouth(room7);
        room4.setNorth(room1);

        room5.setSouth(room8);

        room6.setSouth(room9);
        room6.setNorth(room3);

        room7.setEast(room8);
        room7.setNorth(room4);

        room8.setEast(room9);
        room8.setWest(room7);
        room8.setNorth(room5);

        room9.setSouth(room10);
        room9.setNorth(room6);

        room10.setEast(room11);
        room10.setNorth(room9);

        room11.setNorth(room12);
        room11.setSouth(room15);
        room11.setEast(room13);
        room11.setWest(room10);

        room12.setSouth(room11);

        room13.setSouth(room14);
        room13.setWest(room11);

        room14.setNorth(room13);
        room14.setWest(room15);

        room15.setNorth(room11);
        room15.setEast(room14);

    }

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public Room getNext() {
        return next;
    }

    public void setNext(Room room) {
        next = room;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room room) {
        previousRoom = room;

    }

    public Room getXyzzy() {
        return xyzzy;
    }

    public void setXyzzy(Room room) {
        this.xyzzy = room;
    }

    public Room getRoom1() {
        return room1;
    }
}

