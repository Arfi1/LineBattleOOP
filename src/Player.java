import java.util.Random;
import java.util.Scanner;

public class Player {
    private Die die;
    private Game game;
    private Enemy enemy;

    Scanner keyboard = new Scanner(System.in);

    private int position;
    private int soldiers;
    private int firepower;
    private int bombs;

    boolean bombPlaced = false;
    boolean isGameRunning = false;

    public Player(int position, int soldiers, int firepower, int bombs) {
        this.soldiers = soldiers;
        this.firepower = firepower;
        this.bombs = bombs;
        this.position = position;
        die = new Die();
    }

    public int getSoldiers() {
        return soldiers;
    }

    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }

    public int getFirepower() {
        return firepower;
    }

    public void setFirepower(int firepower) {
        this.firepower = firepower;
    }

    public int getBombs() {
        return bombs;
    }

    public void setBombs(int bombs) {
        this.bombs = bombs;
    }

    public int getPosition() {
        return position;
    }

    public void setPostion(int position) {
        this.position = position;
    }

    public void moveForward() {
        int move = die.roll();
        position += move;
        if (position > 10) {
            position = 10;
        }
        System.out.println("Player moved forward " + move + " tiles. New position: " + position);
        System.out.printf("%n_____________________________________________________________________________%n%n");

    }

    public void moveBackwards() {

        int move = die.roll();
        position -= move;
        if (position < -10) {
            position = -10;
        }
        System.out.println("Player moved backwards " + move + " tiles. New position: " + position);
        System.out.printf("%n_____________________________________________________________________________%n%n");

    }



    public void attack(Enemy enemy) {

        int attackPower = die.roll() * 100;
        firepower -= attackPower;
        int distance = Math.abs(position - enemy.getPosition());
        int soldiersLost = Math.max(0, 6 - distance);
        enemy.setSoldiers(enemy.getSoldiers() - soldiersLost);
        System.out.println("Player attacked! Enemy lost " + soldiersLost + " soldiers.");

    }

    public void placeBomb() {

        if (bombs > 0 && position < 0) {
            bombs--;
            System.out.println("Player placed a bomb at position " + position);
        } else {
            System.out.println("Player cannot place a bomb.");
        }

    }

    public void detonateBomb(Enemy enemy) {


        if (bombs == 0 && Math.abs(position - enemy.getPosition()) >= 6) {
            enemy.setSoldiers(enemy.getSoldiers() - 10);  // Arbitrary damage amount
            System.out.println("Player detonated the bomb! Enemy loses 10 soldiers.");
        } else {
            System.out.println("Player cannot detonate the bomb.");
        }

    }


    public void scout(Enemy enemy) {

        int distance = Math.abs(position - enemy.getPosition());
        if (distance <= 2) {
            System.out.println("Enemy is very close!");
        } else if (distance <= 5) {
            System.out.println("Enemy is at a medium distance.");
        } else {
            System.out.println("Enemy is far away.");
        }
    }

    public void showStats() {

        System.out.println("Player Stats: Position: " + position + ", Soldiers: " + soldiers + ", Firepower: " + firepower + ", Bombs: " + bombs);
    }

    public void surrender() {

        System.out.println("Player surrenders. Enemy wins!");
        System.exit(0);
    }
}
