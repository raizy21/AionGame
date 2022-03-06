import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * class for the map and the interactions with the map
 *
 * @author andrei
 * 
 */
public class Map {
    private Tile[][] map;
    private int playerXCoordinate;
    private int playerYCoordinate;
    private final Player player;
    private final String path;

    /**
     * creates a new map object
     * @param path path to text file with a valid map
     * @param player the player object
     */
    public Map(String path, Player player) {
        this.player = player;
        this.path = path;
    }

    /**
     * loads the map from the given path
     * @throws IOException if there are an error while loading the file
     */
    public void load() throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get(path));
        int y = 0;
        while (br.readLine() != null) {
            y++;
        }
        br = Files.newBufferedReader(Paths.get(path));
        String line;
        map = new Tile[y][];
        y = 0;
        while ((line = br.readLine()) != null) {
            map[y] = new Tile[line.length()];
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case '#':
                        map[y][i] = new Wall();
                        break;
                    case 'O':
                        map[y][i] = new Well();
                        break;
                    case 'B':
                        map[y][i] = new Battle();
                        break;
                    case 'G':
                        map[y][i] = new Goal();
                        break;
                    case 'P':
                        playerYCoordinate = y;
                        playerXCoordinate = i;
                    default: // Fall through
                        map[y][i] = new Empty();
                        break;
                }
            }
            y++;
        }
    }

    /**
     * start the game and let the player walk on the map
     */
    public void start() {
        Scanner stdin = new Scanner(System.in);
        while (true) {
            System.out.println(this);
            System.out.println("Please move with w, a, s, d");
            int x = 0;
            int y = 0;
            switch (stdin.next()) {
                case "w":  // Fall through
                case "W":
                    y--;
                    break;
                case "d":  // Fall through
                case "D":
                    x++;
                    break;
                case "s":  // Fall through
                case "S":
                    y++;
                    break;
                case "a":  // Fall through
                case "A":
                    x--;
                    break;
                case "X":
                    System.exit(0);
                default:
                    System.out.println("Wrong input!");
            }

            if (x != 0 || y != 0) {
                Tile newTile = map[playerYCoordinate + y][playerXCoordinate + x];
                if (newTile.isWalkable()) {
                    playerYCoordinate += y;
                    playerXCoordinate += x;
                    if (newTile instanceof PlayerAction) {
                        PlayerAction action = (PlayerAction) newTile;
                        action.startAction(player);
                    }
                } else {
                    System.out.println("You can not go here");
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (x == playerXCoordinate && y == playerYCoordinate) {
                    ret.append("P");
                }   else {
                    ret.append(map[y][x].toString());
                }
            }
            ret.append("\n");
        }
        return ret.toString();
    }
}
