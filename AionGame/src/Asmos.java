/**
 * Class for asmos monsters who never miss a attack
 *
 * @author asmos
 */

public class Asmos extends Monster {
	/**
     * asmos constant attack power
     */
    protected int constATK;
	
	/**
     * creates a asmos monster object
     *
     * @param player for a balanced asmos monster to be created
     */
    public Asmos(final Player player) {
        super(player);
        constATK = atk;
    }
    
    /**
     * attacks a target 
     * 
     * @return always a constant amount of damage player attack / 2
     */
    public int calculateAttackDamage() {
    	return constATK;
    }
}