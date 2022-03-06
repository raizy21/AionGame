/**
 * class for the goal on the map
 *
 * @author andrei
 */
public class Goal extends Tile implements PlayerAction {

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public void startAction(final Player player) {
        System.out.println("Level completed");
        System.exit(0);
    }

    @Override
    public String toString() {
        return "G";
    }
}