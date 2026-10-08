public class Fight {

    private Player player;
    private Enemy enemy;

    public Fight(Player player, String enemySortName) {
        this.player = player;
        this.enemy = player.getCurrentRoom().findEnemyByShortName(enemySortName);
    }

    public void startFight() {
        player.attack(enemy.getShortName());

        if (enemy.getHealth() <= 0) {

            System.out.println("you killed the enemy");
            enemy.getRoom().addItem(enemy.getWeapon());
            enemy.getRoom().removeEnemy(enemy);
        } else {
            enemy.attack(player);
        }

    }

    public enum AggressionType {
        PASSIVE,
        NEUTRAL,
        AGGRESSIVE
    }




}
