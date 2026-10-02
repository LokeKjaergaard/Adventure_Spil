import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private String name;
    private ArrayList<Item> inventory = new ArrayList<>();
    private int maxCarry = 20;
    private int currentHealth = 100;
    private Weapon equipped;

    public Player(String name, Room currentRoom) {
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

    public int getHealth(){
        return currentHealth;
    }



    public void addItem(Item item, Room room) {
        if (getCurrentWeight() + item.getWeight() <= maxCarry) {
            inventory.add(item);
            room.removeItem(item);
        }
        else {
            System.out.println("you are carrying too much drop something");
        }
    }

    public void removeItem(Item item) {
        if (!inventory.isEmpty()) {
            if (inventory.contains(item)) {
                inventory.remove(item);
                currentRoom.addItem(item);
            } else System.out.println("Item: '" + item.getLongName() + "' is not in your inventory");

        } else System.out.println("Your inventory is empty!");
    }

    // Attempt to eat an item by shortname.
    public EatOutcome eat(String shortName){
        EatOutcome fromInventory = attemptEatFrom(shortName, inventory);
        if (fromInventory.getResult() == EatResult.EATEN) {
            return fromInventory;
        }
        return attemptEatFrom(shortName, currentRoom.getRoomItems());
    }

    // allow you to eat an item from a chosen item storage.
    private EatOutcome attemptEatFrom(String shortName, ArrayList<Item> items){
        Item item = Item.findItemByShortName(shortName, items);
        if (item == null){
            return new EatOutcome(EatResult.NOT_FOUND, shortName, 0);
        }
        if (!(item instanceof Food food)){
            return new EatOutcome(EatResult.NOT_FOOD, shortName, 0);
        }
        items.remove(food);
        currentHealth += food.getHealthPoints();
        if (currentHealth > 100) {
            currentHealth = 100;
        }
        return new EatOutcome(EatResult.EATEN, shortName, food.getHealthPoints());
    }

    public ArrayList<Item> getItems() {
        return inventory;
    }

    public Item findItemByShortName(String shortName) {
        return Item.findItemByShortName(shortName, inventory);
    }

    public int getCurrentWeight() {
        int weight = 0;
        for (int i = 0; i < inventory.size(); i++) {
            weight = weight + inventory.get(i).getWeight();
        }
        return weight;
    }
    public void equip(String shortname) {
        Item item = findItemByShortName(shortname);
        if(item == null){
            System.out.println("Weapon could not be found in inventory");
        }
        else if(item instanceof Weapon){
            equipped = (Weapon) item;
            System.out.println("you equipped" + item.getShortName());
        }
        else{
            System.out.println("that is not a weapon");
        }

    }

}
