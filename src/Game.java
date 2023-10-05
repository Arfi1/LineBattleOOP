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


    public void welcomeMessage() {
        System.out.println("Welcome to Line Battle");
        System.out.println("The game will begin!");
        System.out.println("May the best player win!");

        System.out.printf("%n_____________________________________________________________________________%n%n");
    }


    public void play() {

        while (player.getSoldiers() > 0 && enemy.getSoldiers() > 0) {

            System.out.println("Spillerens tur");
            System.out.println("Roll the dice");
            System.out.println("Player rolled a " + player );

            System.out.println("Do you want to Move forward" + "YES/NO");
            String response = keyboard.nextLine();
            if (response.equalsIgnoreCase("Yes")) {
                player.moveForward();
            } else
           if (response.equalsIgnoreCase("No"))
               System.out.println("Do you want to Move Backwards" + "YES/NO");
            if (response.equalsIgnoreCase("Yes")){
                player.moveBackwards();
            }






            System.out.println("Fjendens tur");


            if (player.getSoldiers() <=0)
                System.out.println("Du har tabt. Enemy vandt");
            else if (enemy.getSoldiers() <=0) {
                System.out.println("Du har vundet!");
            }

        }

    }

    public static void main(String[] args) {
        Game game = new Game();
        game.welcomeMessage();

        game.play();
    }

}

