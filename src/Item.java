import java.util.ArrayList;


public class Item {

    private String shortName;
    private String longName;

    Item Gun = new Item(
      "Gun",
      "A Sniper riffle"
    );
    Item lamp = new Item(
            "lamp",
            "a shiny brass lamp"
    );
    Item clothes = new Item(
            "Shoes",
            "Shiny shoes"
    );

    public Item(String shortName, String longName ) {
        this.shortName = shortName;
        this.longName = longName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName(){
        return longName;
    }

    public void setShortName() {

    }

    public void setLongName(){

    }

    ArrayList<String> roomItems = new ArrayList<>();


}
