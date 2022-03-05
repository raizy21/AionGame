/**
 * Class for vampire monsters who regenerate health points for 10% of outgoing damage
 *
 * @author andrei
 */
public class Vampire extends Monster {
    /**
     * maximum health points
     */
    private final int maxHP;

    /**
     * creates a vampire monster object
     *
     * @param player for a balanced vampire monster to be created
     */
    public Vampire(final Player player) {
        super(player);
        maxHP = hp;
    }

    /**
     * attacks a target and restore health points for 10% of outgoing damage
     *
     * @return -1 iff the attack is missed otherwise the amount of damage
     */
    public int calculateAttackDamage() {
        int damage = super.calculateAttackDamage();
        if (damage > 0) {
            hp = Math.min(maxHP, hp + damage / 10);
        }
        return damage;
    }
}