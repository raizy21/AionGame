/**
 * Class to represent a monster with heal points, attack power and a hit chance
 *
 * @author andrei
 */
public class Monster {
    /**
     * attack power
     */
    private final int atk;
    /**
     * hit chance
     */
    private final int hit = 50;
    /**
     * health points
     */
    private int hp;

    /**
     * creates a monster object
     *
     * @param player for a balanced monster to be created
     */
    public Monster(Player player) {
        this.hp = player.hp * 2;
        this.atk = player.atk / 2;
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
     * monster takes the damage
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
     * checks if the monster is still alive
     *
     * @return true iff the monster is alive otherwise false
     */
    public boolean isAlive() {
        return hp > 0;
    }

    /**
     * returns the monster as a string representation
     *
     * @return string representation of the monster
     */
    public String toString() {
        return "Monster has " + hp + " HP.";
    }
}
