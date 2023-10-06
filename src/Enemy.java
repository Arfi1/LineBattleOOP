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

    public int moveForward() {

        // Move forward within the extended enemy territory (-10 to 10)
        if (position < 10) {
            if (position + 2 <= 10) {
                position += 2;
            } else {
                position = 10;
            }
        }
        System.out.println("Position: " + position);
        return position;

    }

    public int moveBackwards() {

        // Move backwards within the extended enemy territory (-10 to 10)
        int dieRollResult = die.roll();
        int moveAmount;

        if (position >= -10 && position < 10) {
            if (dieRollResult <= 2) {
                moveAmount = 1;
            } else if (dieRollResult == 3 || dieRollResult == 4) {
                moveAmount = 2;
            } else {
                moveAmount = 3;
            }

            if (position - moveAmount >= -10) {
                position -= moveAmount;
            } else {
                position = -10;
            }
            firepower += 250;
        } else {
            System.out.println("Cannot move backwards outside the extended enemy territory.");
        }
        return position;
    }



    public String attack(Player player) {

        firepower -= die.roll() * 100;
        int difference = Math.abs(position - player.getPosition());

        if (difference < 6) {
            soldiers = (6 - difference);
        } else
            soldiers = (5 - difference);

        return "You attacked " + soldiers + " Soldiers";

    }

    public void placeBomb() {


        if (position < 0 && player.getPosition() > 0) {
            bombs -= bombs;
        }

    }

    public void detonateBomb() {
        if (bombs == 1 && position >= -10 && position >= 0) {
            if (position >= player.getPosition() + 6) {
                System.out.println("Player detonated BOMB in enemys territory");
                bombs -= bombs;
            } else
                System.out.println("Player needs to be atleats 6 fields away from Enemy to detonate the BOMB");
        } else
            System.out.println("Cannot detonate BOMB. Make sure the bomb is placed and you are on your own territory.");

    }
}

