/**
 * class for free tiles on the map
 *
 * @author andrei
 */
public class Empty extends Tile {

    @Override
    public boolean isWalkable() {
        return true;
    }
}
