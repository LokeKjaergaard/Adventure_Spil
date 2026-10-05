package Items;

public class Food extends Item {

    private int healthPoints;

    public Food(String shortName, String longName, int weight, int healthPoints) {
        super(shortName, longName, weight);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void printLongName(){
        System.out.println(longName);
    }
    @Override
    public String getLongName() {
        return longName + " (" + healthPoints + " health)";
    }



}
