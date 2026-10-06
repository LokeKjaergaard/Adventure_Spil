package Items;


import java.util.ArrayList;

public class Item {

    private String shortName;
    protected String longName;
    private int weight;

    public Item(String shortName, String longName, int weight) {

        this.shortName = shortName;
        this.longName = longName;
        this.weight = weight;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setShortName() {
        //todo
    }

    public void setLongName() {
        //todo
    }

    public int getWeight() {
        return weight;
    }
    // helper method
    public static Item findItemByShortName(String itemShortName, ArrayList<Item> items){

        if (!items.isEmpty()) {
            for (Item item : items) {
                String name = item.getShortName().toLowerCase();
                if (name.equals(itemShortName)) {
                    return item;
                }
            }
        }
        return null;
    }

}


