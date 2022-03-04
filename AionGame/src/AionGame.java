/**
 * Launcher class for an interactive.
 * Battle simulation between a player and a monster.
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
        // checks if there are enough arguments
        if (args.length < 3) {
            System.out.println("Please start the simulation with three arguments!");
            System.out.println("java AionGame 100 50 80");
            return;
        }
       
        // creates a both participants
        Player player = new Player(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
        Monster monster = new Monster(player);

        // create and start the fight
        Fight fight = new Fight(player, monster);
        fight.start();

        if (player.isAlive() && monster.isAlive()) {
            System.out.println("The fight ended in a draw.");
        } else if (player.isAlive()) {
            System.out.println("Player has won the battle!");
        } else {
            System.out.println("Monster has won the battle!");
        }
    }
}
