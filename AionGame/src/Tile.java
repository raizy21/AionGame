/**
 * Mother class for all tiles of the map
 *
 * @author andrei
 */
abstract public class Tile {
    /**
     * returns true if the tile is walkable, otherwise false
     * @return true if the tile is walkable, otherwise false
     */
    public abstract boolean isWalkable();

    @Override
    public String toString() {
        return " ";
    }
}
