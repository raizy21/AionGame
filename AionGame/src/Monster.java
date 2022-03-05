/**
 * class to represent a monster with heal points, attack power and a hit chance
 *
 * @author andrei
 */
public class Monster extends Character {

    /**
     * creates a monster object
     *
     * @param player for a balanced monster to be created
     */
    public Monster(final Player player) {
        super(player.hp * 2, player.atk / 2, 50);
    }

    /**
     * returns the monster as a string representation
     *
     * @return string representation of the monster
     */
    public String toString() {
        return getClass().getSimpleName() + " has " + hp + " HP";
    }
}