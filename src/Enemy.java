import Items.Weapon;

public class Enemy {

    private String shortName;
    private String longName;
    private String description;
    private int health;
    private Weapon weapon;
    private Room room;
    private final Fight.AggressionType aggression;


    public Enemy(String shortName, String longName, String description, int health, Weapon weapon, Room room, Fight.AggressionType aggression){
        this.shortName = shortName;
        this.longName = longName;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
        this.room = room;
        this.aggression = aggression;
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public String getDescription() {
        return description;
    }

    public int getHealth() {
        return health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Room getRoom() {
        return room;
    }

    public Fight.AggressionType getAggression() {
        return aggression;
    }

    public void attack(Player player){
        int damage = weapon.getDamage();

        if (weapon.canUse()){
            weapon.use();
            player.hit(damage);
        }

    }

    public hitOutcome hit(int damage){
        health -= damage;

        if (health <= 0){
            room.addItem(weapon);
            room.removeEnemy(this);
            return hitOutcome.ENEMY_DIED;
        } else return hitOutcome.ENEMY_HIT;
    }
}
