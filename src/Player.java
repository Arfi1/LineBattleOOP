import java.util.Random;
import java.util.Scanner;

public class Player {

    Scanner keyboard = new Scanner(System.in);
    Random random = new Random();

    private int dice = random.nextInt(6) - 1;
    private int postion;
    private int soldiers;
    private int firepower;
    private int bombs;

    public Player(int postion, int soldiers, int firepower, int bombs) {
        this.postion = postion;
        this.firepower = firepower;
        this.bombs = bombs;
        this.postion = postion;
        this.dice = dice;
    }


    public int getPostion() {
        return postion;
    }

    public int getSoldiers() {
        return soldiers;
    }

    public int getFirepower() {
        return firepower;
    }

    public int getBombs() {
        return bombs;
    }


    public void moveForward() {


    }

    public void moveBackwards() {

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

    public void surrender() {

    }


    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }
}
