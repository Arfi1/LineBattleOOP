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

    public int moveForward() {
        // hvis dice er lig med et heltal, rykker enemy position 2 frem

        if (die.roll() % 2 == 0) {
            position -= 2;
            System.out.println("Position: " + position);
        } else {
            position -= 1;
            System.out.println("Position: " + position);
        }

        return position;

    }

    public int moveBackwards() {

        int dieRollResult = die.roll();

        if (dieRollResult <= 2) {
            // Træk 1 felt tilbage
            position += 1;
        } else if (dieRollResult == 3 || dieRollResult == 4) {
            // Træk 2 felter tilbage
            position += 2;
        } else {
            // Træk 3 felter tilbage
            position -= 3;
        }
        firepower += 250;

        //her skal der tages hensyn til at der er en enemy- og play-position
        if (position == 10 && bombs == 0) {
            bombs = 1;
        }

        return position;
    }



    public String attack(Player enemy) {
        int dieRollResult = die.roll();

        firepower -= dieRollResult * 100;
        int difference = Math.abs(position - enemy.getPosition());

        if (difference < 6) {
            soldiers = (6 - difference);
        } else
            soldiers = (5 - difference);

        return "You attacked " + soldiers + " Soldiers";

    }

    public void placeBomb(Player enemy) {

        if (position < 0 && enemy.getPosition() > 0) {
            bombs -= bombs;
        }

    }

    public void detonateBomb(Player enemy) {

        // hvis bomb er lig med 1 og position er mindre eller lig med 10 og position er mindre eller lig med nul
        if (bombs == 1 && position <= 10 && position >= 0) {
            if (position >= enemy.getPosition() + 6) {
                System.out.println("Player detonated BOMB in enemys territory");
                bombs -= bombs;
            } else
                System.out.println("Player needs to be atleats 6 fields away from Enemy to detonate the BOMB");
        } else
            System.out.println("Cannot detonate BOMB. Make sure the bomb is placed and you are on your own territory.");


    }


    public void spejderBesked() {

        int position = this.getPosition();

        int afstand = Math.abs(position - enemy.getPosition());

        if (afstand <= 2) {
            if (position < enemy.getPosition()) {
                System.out.println("Fjenden er tæt på, " + afstand + " felter foran dig.");
            } else if (position > enemy.getPosition()) {
                System.out.println("Fjenden er tæt på, " + afstand + " felter bag dig.");

            } else if (afstand <= 5){
                 if (position < enemy.getPosition()) {
                    System.out.println("Fjenden er lidt længere væk, " + afstand + " felter foran dig.");
                } else if (position > enemy.getPosition()) {
                    System.out.println("Fjenden er lidt længere væk, " + afstand + " felter bag dig.");
                }
            }
        }
    }

    public void stats() {


        System.out.println("Player has:" + firepower + " Firepower");
        System.out.println("Enemy has: " + enemy.getFirepower() + " Firepower");
        System.out.println("Bomb placed: " + (bombPlaced ? "Yes" : "No"));
        System.out.println("Player has: " + soldiers + " soldiers");
        System.out.println("Enemy has: " + enemy.getSoldiers() + "soldiers");



    }

    public void surrender(Player enemy) {

        System.out.println("Do you want to surrender Yes og No");
        String response = keyboard.nextLine();

        if (response.equalsIgnoreCase("Yes")) {
            isGameRunning = false;
        }
    }
}
