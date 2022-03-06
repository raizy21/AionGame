/**
 * class for the walls on the map
 *
 * @author andrei
 */
public class Wall extends Tile {

    @Override
    public boolean isWalkable() {
        return false;
    }

    @Override
    public String toString() {
        return "#";
    }
}