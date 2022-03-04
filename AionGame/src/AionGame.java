/**
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
        // player
        int playerHP = Integer.parseInt(args[0]);
        int playerATK = Integer.parseInt(args[1]);
        int playerHIT = Integer.parseInt(args[2]);
        // monster
        int monsterHP = playerHP * 2;
        int monsterATK = playerATK / 2;
        int monsterHIT = 50;

        // simulate the battle until someone has died
        while (playerHP > 0 && monsterHP > 0) {
            System.out.println("---------------");
            int random = (int) (100 * Math.random());
            System.out.println("Player has " + playerHP + " HP.");
            if (random <= playerHIT) {
                System.out.println("Player hits Monster for " + playerATK + " damage.");
                monsterHP -= playerATK;
            } else {
                System.out.println("Player missed!");
            }
            // is the monster still alive?
            if (monsterHP > 0) {
                System.out.println("Monster has " + monsterHP + " HP.");
                random = (int) (100 * Math.random());
                if (random <= monsterHIT) {
                    System.out.println("Monster hits Player for " + monsterATK + " damage.");
                    playerHP -= monsterATK;
                } else {
                    System.out.println("Monster missed!");
                }
            } 
        }
        System.out.println("---------------");
        if (monsterHP <= 0) {
            System.out.println("Player has won the battle!");
        } else {
            System.out.println("Monster has won the battle!");
        }
    }
}
