import java.util.Random;
import java.util.Scanner;

public class Player {
private Die die;
private Game game;


    private int postion;
    private int soldiers;
    private int firepower;
    private int bombs;

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

        if (postion == 10 && bombs == 0) {
            bombs = 1;
        }
    }



    public void attack() {
       /* //terningen slås igen
        int dice = random.nextInt(6)+1;
        // 100 ildkraft * terningens øjne (man kan ikke bruge mere ildkraft end hvad man har)
        firepower = 100 * dice;

        //Hvis distance er større eller lig med 1 && hvis distance er mindre eller lig med 6
        if (distance >= 1 && distance <= 6) {
            //Math.min bliver brugt for at sikre der ikke trækkes flere soldater fra modstanderen end der er.
            //Player soldiers bliver trukket fra ift distancen.
            soldiers -= Math.min(6, distance); */

    }

    public void placeBomb() {

    }

    public void detonateBomb() {

    }

    public void spejder () {

    }

    public void surrender() {

    }


}
