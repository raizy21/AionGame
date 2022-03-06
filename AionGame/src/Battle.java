/**
 * class for the battle tile on the map
 *
 * @author andrei
 */
public class Battle extends Tile implements PlayerAction {
    private boolean used = false;

    @Override
    public boolean isWalkable() {
        return true;
    }

    @Override
    public void startAction(Player player) {
        if (!used) {
            // create a random monster type
            int random = (int) (4 * Math.random());
            Monster monster;
            switch (random) {
                case 0:
                    monster = new Monster(player);
                    break;
                case 1:
                    monster = new Asmos(player);
                    break;
                case 2:
                    monster = new Tank(player);
                    break;
                default:
                    monster = new Vampire(player);
            }
            // create and start the fight
            Fight fight = new Fight(player, monster);
            fight.start();

            if (player.isAlive() && monster.isAlive()) {
                System.out.println("The fight ended in a draw.");
                System.exit(0);
            } else if (player.isAlive()) {
                used = true;
                System.out.println("Player has won the battle!");
            } else {
                System.out.println("Monster has won the battle!");
                System.exit(0);
            }
        }
    }

    @Override
    public String toString() {
        if (used) {
            return " ";
        }
        return "B";
    }
}