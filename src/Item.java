import java.util.ArrayList;

public class Item {

    private String shortName;
    private String longName;

    public Item(String shortName, String longName) {
        this.shortName = shortName;
        this.longName = longName;
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

    // helper method
    public static Item findItemByShortName(String itemShortName, ArrayList<Item> items){
        int length = items.size();

        if (!items.isEmpty()) {
            for (int i = 0; i < length; i++){
                Item item = items.get(i);
                if (item.getShortName().equals(itemShortName)){
                    return item;
                }
            }
        }
        return null;
    }

}
