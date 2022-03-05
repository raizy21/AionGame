/**
 * Class for tank monsters with a shield
 *
 * @author andrei
 */
public class Tank extends Monster {
    /**
     * maximum shield value
     */
    private final int maxShield;
    /**
     * shield to reduce incoming damage
     */
    private int shield;

    /**
     * creates a tank monster object
     *
     * @param player for a balanced tank monster to be created
     */
    public Tank(final Player player) {
        super(player);
        hp = player.hp; // for balancing
        shield = 50;
        maxShield = 50;
    }

    /**
     * reduce the shield and health points
     *
     * @param damage the amount of incoming damage
     * @return the amount of reduced damage
     */
    public int takeDamage(final int damage) {
        int reducedDamage = Math.max(damage / 2 - shield, 0);
        shield = Math.max(shield - damage / 2, 0);

        return super.takeDamage(reducedDamage);
    }

    /**
     * attacks a target and regenerate the shield
     *
     * @return -1 iff the attack is missed otherwise the amount of damage
     */
    public int calculateAttackDamage() {
        int damage = super.calculateAttackDamage();
        if (damage > 0) {
            shield = Math.min(maxShield, shield + damage / 5);
        }
        return damage;
    }

    /**
     * returns the monster as a string representation
     *
     * @return string representation of the monster
     */
    public String toString() {
        return super.toString() + " and " + shield + " shield";
    }
}