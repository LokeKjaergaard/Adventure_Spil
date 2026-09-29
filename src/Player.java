import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();

    public Player (String name, Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
            return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void addItem(Item item, Room room) {
        inventory.add(item);
        room.removeItem(item);
    }

    public void removeItem(Item item) {
        if (!inventory.isEmpty()) {
            if (inventory.contains(item)) {
                inventory.remove(item);
            } else System.out.println("Item: '" + item.getLongName() + "' is not in your inventory");

        } else System.out.println("Your inventory is empty!");
    }

    public ArrayList<Item> getItems() {
        return inventory;
    }

    public Item findItemByShortName(String shortName) {
        return Item.findItemByShortName(shortName, inventory);
    }
}
