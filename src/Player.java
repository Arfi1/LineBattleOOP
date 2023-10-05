import java.util.Random;
import java.util.Scanner;

public class Player {
    private Die die;
    private Game game;

    Scanner keyboard = new Scanner(System.in);

    private int postion;
    private int soldiers;
    private int firepower;
    private int bombs;

    boolean bombPlaced = false;
    boolean isGameRunning = false;

    public Player(int postion, int soldiers, int firepower, int bombs) {
        this.soldiers = soldiers;
        this.firepower = firepower;
        this.bombs = bombs;
        this.postion = postion;
        die = new Die();
        game = new Game();
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

    public int getPostion() {
        return postion;
    }

    public void setPostion(int postion) {
        this.postion = postion;
    }

    public void moveForward() {
        // hvis dice er lig med et heltal, rykker enemy position 2 frem

        if (die.roll() % 2 == 0) {
            postion += 2;
            System.out.println("Position: " + postion);
        } else {
            postion += 1;
            System.out.println("Position: " + postion);
        }


    }

    public void moveBackwards() {

        int dieRollResult = die.roll();

        if (dieRollResult <= 2) {
            // Træk 1 felt tilbage
            postion += 1;
        } else if (dieRollResult == 3 || dieRollResult == 4) {
            // Træk 2 felter tilbage
            postion += 2;
        } else {
            // Træk 3 felter tilbage
            postion += 3;
        }
        firepower += 250;

        //her skal der tages hensyn til at der er en enemy- og play-position
        if (postion == 10 && bombs == 0) {
            bombs = 1;
        }
    }


    public void attack(Player enemy) {
        int dieRollResult = die.roll();

        firepower -= dieRollResult * 100;
        int difference = Math.abs(postion - enemy.getPostion());

        if (difference < 6) {
            soldiers = (6 - difference);
        } else
            soldiers = (5 - difference);


    }

    public void placeBomb(Player enemy) {

        if (postion < 0 && enemy.getPostion() > 0) {
            bombs -= bombs;
        }

    }

    public void detonateBomb(Player enemy) {

        if (bombs == 1 && postion <= 10 && postion >= 0) {
            if (postion >= enemy.getPostion() + 6) {
                System.out.println("Player detonated BOMB in enemys territory");
            } else
                System.out.println("Player needs to be atleats 6 fields away from Enemy to detonate the BOMB");
        } else
            System.out.println("Cannot detonate BOMB. Make sure the bomb is placed and you are on your own territory.");


    }



    /*public void spejder(Player enemy) {
        int difference = Math.abs( postion - enemy.getPostion());


        if (difference == 1) {
                System.out.println("The enemy is one position away");
            }
        if (difference == 2) {
            System.out.println("The enemy is two postions away");
        }
        if (difference = ( 3- difference)) {
            System.out.println();
        } */

    public void spejderBesked(Player enemy) {
        int afstand = Math.abs(postion - enemy.getPostion());

        if (afstand <= 2) {
            if (postion < enemy.getPostion()) {
                System.out.println("Fjenden er tæt på, " + afstand + " felter foran dig.");
            } else if (postion > enemy.getPostion()) {
                System.out.println("Fjenden er tæt på, " + afstand + " felter bag dig.");

            } else if (afstand <= 5){
                 if (postion < enemy.getPostion()) {
                    System.out.println("Fjenden er lidt længere væk, " + afstand + " felter foran dig.");
                } else if (
                        postion > enemy.getPostion()) {
                    System.out.println("Fjenden er lidt længere væk, " + afstand + " felter bag dig.");
                }
            }
        }



    }
    public void stats(Player enemy) {


        System.out.println("Player has:" + firepower + " Firepower");
        System.out.println("Enemy has: " + enemy.getFirepower() + " Firepower");
        System.out.println("Bomb placed: " + (bombPlaced ? "Yes" : "No"));
        System.out.println("Bomb placed: " + (bombPlaced ? "Yes" : "No"));
        System.out.println("Player has: " + soldiers + " soldiers");
        System.out.println("Enemy has: " + enemy.getSoldiers() + "soldiers");



    }

    public void surrender(Player enemy) {

        System.out.println("Do you want to surrender Yes og No");
        keyboard.nextLine();

        isGameRunning = false;

    }
}
