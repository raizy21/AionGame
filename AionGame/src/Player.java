/**
 * class to represent a player with heal points, max heal points, attack power, a hit chance and an amount of heal potions with a value of 50.
 *
 * @author andrei
 */
public class Player extends Character {
    /**
     * maximum health points
     */
    private final int maxHP;
    /**
     * number of heals potions
     */
    private int healPotions;

    /**
     * creates a player object
     *
     * @param hp  health points (positive integer value)
     * @param atk attack power (positive integer value)
     * @param hit hit chance (between 0 and 100)
     */
    public Player(final int hp, final int atk, final int hit) {
        super(hp, atk, hit);
        this.maxHP = hp;
        healPotions = 3;
    }

    /**
     * use heals potion to heal the player
     *
     * @return -1 iff all of the players heal potions are empty otherwise number of restored heal points
     */
    public int usePotion() {
        if (healPotions > 0) {
            healPotions--;
            int old = hp;
            hp = Math.min(hp + 50, maxHP);
            return hp - old;
        }
        return -1;
    }

    /**
     * returns the player as a string representation
     *
     * @return string representation of the player
     */
    public String toString() {
        return "Player has " + hp + " HP";
    }

    /**
     * returns the number of heal potions
     *
     * @return number of heal potions
     */
    public int getHealPotions() {
        return healPotions;
    }
    
    /**
     * resets the player
     */
    public void reset() {
        hp = maxHP;
        healPotions = 3;
    }
}