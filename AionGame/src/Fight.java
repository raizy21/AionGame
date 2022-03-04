import java.util.Scanner;

/**
 * Class for an interactive fight to death between a player and a monster.
 *
 * @author andrei
 */
public class Fight {
    /**
     * the player object
     */
    private final Player player;
    /**
     * the monster object
     */
    private final Monster monster;
    /**
     * a scanner object for user inputs
     */
    private final Scanner stdin;

    /**
     * creates a new fight between a player and a monster
     *
     * @param player  the player
     * @param monster the monster
     */
    public Fight(Player player, Monster monster) {
        this.player = player;
        this.monster = monster;

        stdin = new Scanner(System.in);
    }

    /**
     * starts the fight to death
     * In each round the player starts. The user can select between an attack or the healing potion.
     * After that the monster attacks.
     */
    public void start() {
        while (player.isAlive() && monster.isAlive()) {
            System.out.println(player);
            System.out.println(monster);

            String input = askWhetherToAttack();

            if ("1".equals(input)) { // attack
                int damage = player.calculateAttackDamage();
                if (damage == -1) {
                    System.out.println("Player missed!");
                } else {
                    System.out.println("Player hits Monster for " + damage + " damage.");
                    monster.takeDamage(damage);
                }
            } else if ("0".equals(input)) { // use heal potion, no error checking!
                player.usePotion();
            } else if ("x".equals(input)) {
                System.out.println("---------------");
                return;
            } else {
                System.out.println("Wrong input.");
            }

            if (!monster.isAlive()) {
                System.out.println("---------------");
                return;
            }
            int damage = monster.calculateAttackDamage();
            if (damage == -1) {
                System.out.println("Monster missed!");
            } else {
                System.out.println("Monster hits Player for " + damage + " damage.");
                player.takeDamage(damage);
            }
            System.out.println("---------------");
        }
    }

    /**
     * asks the user for an input to attack the monster or to use a heal potion
     *
     * @return the user input
     */
    private String askWhetherToAttack() {
        System.out.println("Use \"1\" for attack, \"0\" for an healing potion - you have " + player.healPotions + " or \"x\" for exit.");
        return stdin.next();
    }
}
