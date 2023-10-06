import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Die die;
    private Player player;
    private Enemy enemy;
    private Scanner keyboard = new Scanner(System.in);

   /* private Player player;
    private Enemy enemy;*/


    public Game() {
        player = new Player(10, 25, 2500, 1);
        enemy = new Enemy(-10, 25, 2500, 1);
        die = new Die();
    }


    public void welcomeMessage() {
        System.out.println("Welcome to Line Battle");
        System.out.println("The game will begin!");
        System.out.println("May the best player win!");

        System.out.printf("%n_____________________________________________________________________________%n%n");
    }


    public void play() {

        while (player.getSoldiers() > 0 && enemy.getSoldiers() > 0) {


            int dieRoll = die.roll();
            System.out.println("Roll the dice" );
            keyboard.nextLine();
            System.out.println("Player rolled a " + dieRoll);
            int updatedPlayerPosition = player.getPosition() - dieRoll;
            player.setPostion(updatedPlayerPosition);

            System.out.println("Player position: " + updatedPlayerPosition);

            System.out.printf("%n_________________________________________________%n%n");


            int dieRollEnemy = die.roll();
            System.out.println("Enemy rolled a " + dieRollEnemy);
            int updatedEnemyPosition = enemy.getPosition() + dieRollEnemy;
            player.setPostion(updatedEnemyPosition);


            System.out.println("Enemy position: " + updatedEnemyPosition);

            System.out.printf("%n_________________________________________________%n%n");

            System.out.println("\nSpillerens tur");


            if (player.getPosition() < 9) {
                System.out.println("Do you want to Move forward" + " YES/NO");
            }
            String response = keyboard.nextLine();
            if (response.equalsIgnoreCase("Yes")) {
                player.moveForward();
            } else if (response.equalsIgnoreCase("No"))
                System.out.println("Do you want to Move Backwards" + "YES/NO");
            String response2 = keyboard.nextLine();
            if (response2.equalsIgnoreCase("Yes")) {
                do {
                    player.moveBackwards();
                } while (player.getPosition() < 9 && player.getPosition() > -10);


                System.out.println("Fjendens tur");




            }



            enemy.moveForward();
            enemy.moveBackwards();


            if (player.getSoldiers() <= 0)
                System.out.println("Du har tabt. Enemy vandt");
            else if (enemy.getSoldiers() <= 0) {
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

