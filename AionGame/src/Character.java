/**
 * mother class for all "characters" as players and monsters...
 *
 * @author andrei
 */
public abstract class Character {
    /**
     * hit chance
     */
    protected final int hit;
    /**
     * health points
     */
    protected int hp;
    /**
     * attack power
     */
    protected int atk;

    /**
     * creates a character
     *
     * @param hp  health point (positive integer value)
     * @param atk attack power (positive integer value)
     * @param hit hit chance (between 0 and 100)
     */
    public Character(final int hp, final int atk, final int hit) {
        if (hp <= 0 || atk <= 0 || hit < 0 || hit > 100) {
            throw new IllegalArgumentException();
        }
        this.hp = hp;
        this.atk = atk;
        this.hit = hit;
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
     * character takes the damage
     *
     * @param damage the amount of damage
     * @return the damage after all reducing effects
     */
    public int takeDamage(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
        return damage;
    }

    /**
     * returns true iff the character is alive otherwise false
     *
     * @return true iff the character is alive otherwise false
     */
    public boolean isAlive() {
        return hp > 0;
    }
}