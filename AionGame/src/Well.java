/**
 * class for the wells on the map
 *
 * @author andrei
 */

public class Well extends Tile implements PlayerAction {

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public void startAction(final Player player) {
        player.reset();
        System.out.println("Player was healed");
    }

    @Override
    public String toString() {
        return "O";
    }
}