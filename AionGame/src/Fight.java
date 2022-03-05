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
     * asks the user for an input to attack the monster or to use a heal potion
     *
     * @return the user input
     */
    private String askWhetherToAttack() {
        String input = "";
        do {
            System.out.println("Use \"1\" for attack, \"0\" for an healing potion - you have " + player.getHealPotions() + " or \"x\" for exit.");
            input = stdin.next();
        } while (input.length() != 1 || !"01x".contains(input));

        return input;
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

            switch (input) {
                case "1":
                    int damage = player.calculateAttackDamage();
                    if (damage == -1) {
                        System.out.println("Player missed!");
                    } else {
                        int realDamage = monster.takeDamage(damage);
                        System.out.println("Player hits Monster for " + damage + " damage and the Monster lose " + realDamage + " HP.");
                    }
                    break;
                case "0":
                    int heal = player.usePotion();
                    if (heal == -1) {
                        System.out.println("Sorry, no heal potions left :(");
                    } else {
                        System.out.println("Player healed for " + heal + " HP.");
                    }
                    break;
                case "x":
                    System.out.println("---------------");
                    return;
            }

            if (!monster.isAlive()) {
                System.out.println("---------------");
                return;
            }
            int damage = monster.calculateAttackDamage();
            if (damage == -1) {
                System.out.println("Monster missed!");
            } else {
                int realDamage = player.takeDamage(damage);
                System.out.println("Monster hits Player for " + damage + " damage and the Player lose " + realDamage + " HP.");
            }
            System.out.println("---------------");
        }
    }
}