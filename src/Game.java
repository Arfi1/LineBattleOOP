import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Scanner keyboard = new Scanner(System.in);

    private Player player;
    private Player enemy;


    public Game() {
        player = new Player (10, 25, 2500, 1);
        enemy = new Player (-10, 25, 2500, 1);
    }




    public void play() {

        while (player.getSoldiers() > 0 && enemy.getSoldiers() > 0) {

            System.out.println("Spillerens tur");




            System.out.println("Fjendens tur");


            if (player.getSoldiers() <=0)
                System.out.println("Du har tabt. Enemy vandt");
            else if (enemy.getSoldiers() <=0) {
                System.out.println("Du har vundet!");
            }

        }

    }


}

