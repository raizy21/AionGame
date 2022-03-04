/**
 * Class to represent a player with heal points, max heal points, attack power, a hit chance and an amount of heal potions with a value of 50.
 *
 * @author andrei
 */
public class Player {
    /**
     * attack power
     */
    public final int atk;
    /**
     * hit chance
     */
    private final int hit;
    /**
     * maximum health points
     */
    private final int maxHP;
    /**
     * amount of health healed by a heal potion
     */
    private final int healPotionValue = 50;
    /**
     * health points
     */
    public int hp;
    /**
     * number of heals potions
     */
    public int healPotions = 3;

    /**
     * creates a player object
     *
     * @param hp  health point (positive integer value)
     * @param atk attack power (positive integer value)
     * @param hit hit chance (between 0 and 100)
     */
    public Player(int hp, int atk, int hit) {
        this.hp = hp;
        this.maxHP = hp;
        this.atk = atk;
        this.hit = hit;
    }

    /**
     * use heals potion to heal the player
     */
    public void usePotion() {
        if (healPotions <= 0) {
            System.out.println("Sorry, no heal potions left :(");
            return;
        }
        healPotions--;
        int old = hp;
        hp += healPotionValue;
        if (hp > maxHP) {
            hp = maxHP;
        }
        System.out.println("Player healed for " + (hp - old) + " HP.");
    }

    /**
     * simulates an attack
     *
     * @return -1 iff the hit is a miss otherwise the damage (atk)
     */
    public int calculateAttackDamage() {
        int random = (int) (100 * Math.random());
        if (random <= hit) {
            return atk;
        } else {
            return -1;
        }
    }

    /**
     * player takes the damage
     *
     * @param damage the amount of damage
     */
    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    /**
     * checks if the player is still alive
     *
     * @return true iff the player is alive otherwise false
     */
    public boolean isAlive() {
        return hp > 0;
    }

    /**
     * returns the player as a string representation
     *
     * @return string representation of the player
     */
    public String toString() {
        return "Player has " + hp + " HP.";
    }
}
