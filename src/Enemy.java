import java.util.Scanner;

public class Enemy {
    private Die die;
    private Game game;
    private Player player;

    Scanner keyboard = new Scanner(System.in);

    private int position;
    private int soldiers;
    private int firepower;
    private int bombs;

    boolean bombPlaced = false;
    boolean isGameRunning = false;

    public Enemy (int position, int soldiers, int firepower, int bombs) {
        this.position = position;
        this.soldiers = soldiers;
        this.firepower = firepower;
        this.bombs = bombs;
        die = new Die();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
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

    public void moveForward() {

        int move = die.roll();
        position += move;
        if (position > 10) {
            position = 10;
        }
        System.out.println("Enemy moved forward " + move + " tiles. New position: " + position);
    }



    public void moveBackwards() {

        int move = die.roll();
        position -= move;
        if (position < -10) {
            position = -10;
        }
        System.out.println("Enemy moved backwards " + move + " tiles. New position: " + position);
    }



    public void attack(Player player) {


        int attackPower = die.roll() * 100;
        firepower -= attackPower;
        int distance = Math.abs(position - player.getPosition());
        int soldiersLost = Math.max(0, 6 - distance);
        player.setSoldiers(player.getSoldiers() - soldiersLost);
        System.out.println("Enemy attacked! Player lost " + soldiersLost + " soldiers.");
    }

    public void placeBomb() {
        if (bombs > 0 && position > 0) {
            bombs--;
            System.out.println("Enemy placed a bomb at position " + position);
        } else {
            System.out.println("Enemy cannot place a bomb.");
        }
    }



    public void detonateBomb(Player player) {
        if (bombs == 0 && Math.abs(position - player.getPosition()) >= 6) {
            player.setSoldiers(player.getSoldiers() - 10);  // Arbitrary damage amount
            System.out.println("Enemy detonated the bomb! Player loses 10 soldiers.");
        } else {
            System.out.println("Enemy cannot detonate the bomb.");
        }
    }
}

