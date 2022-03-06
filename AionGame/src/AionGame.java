import java.io.IOException;
import java.util.Scanner;
/**
 * Launcher class for an interactive battle between a player and a monster.
 *
 * @author andrei
 */
public class AionGame {

/**
 * The main method of the simulation.
 *
 * @param args values for the player. args[0] player hp, args[1] player atk, args[2] player hit
 */
	public static void main(String[] args) {
        // checks if there are enough arguments and if all are integers
        if (args.length < 3 || !isNumber(args[0]) || !isNumber(args[1]) || !isNumber(args[2])) {
            System.out.println("Please start with three arguments");
            System.out.println("java AionGame 100 50 80");
            return;
        }

        final int hp = Integer.parseInt(args[0]);
        final int atk = Integer.parseInt(args[1]);
        final int hit = Integer.parseInt(args[2]);

        if (hp <= 0) {
            System.out.println("The heal points must be over 0.");
            return;
        }

        if (atk <= 0) {
            System.out.println("The attack power must be over 0.");
            return;
        }

        if (hit <= 0 || hit >= 100) {
            System.out.println("The hit chance must between 0 and 100.");
            return; 
        }

        Player player = new Player(hp, atk, hit);
        Map map = new Map("C:\\Users\\razvan\\git\\AionGame\\AionGame\\src\\map.txt", player);
        try {
            map.load();
        } catch (IOException e) {
            System.out.println("The map does not exist!");
            return;
        }
        map.start(); 
	}

    /**
     * checks if the given parameter is a integer number or not
     * this variant is not perfect and the use of exceptions are better
     * @param input the possible integer number
     * @return true iff the parameter is a integer number otherwise false
     */
    private static boolean isNumber(String input) {
        try (Scanner scanner = new Scanner(input)) {
			return scanner.hasNextInt();
		}
    }
}