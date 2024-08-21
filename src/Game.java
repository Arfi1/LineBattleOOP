import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private Die die;
    private Player player;
    private Enemy enemy;
    private Scanner scanner = new Scanner(System.in);




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


            player.showStats();
            enemyMove();
            playerMove();
        }

        if (player.getSoldiers() <= 0) {
            System.out.println("You have lost. Enemy wins!");
        } else if (enemy.getSoldiers() <= 0) {
            System.out.println("You have won!");

        }

    }


    private void playerMove() {
        System.out.println("\nPlayer's turn:");
        System.out.println("Choose an action: [Move Forward / Move Backward / Attack / Place Bomb / Detonate Bomb / Scout / Surrender]");
        String action = scanner.nextLine().trim().toLowerCase();

        switch (action) {
            case "move forward":
                player.moveForward();
                break;
            case "move backward":
                player.moveBackwards();
                break;
            case "attack":
                player.attack(enemy);
                break;
            case "place bomb":
                player.placeBomb();
                break;
            case "detonate bomb":
                player.detonateBomb(enemy);
                break;
            case "scout":
                player.scout(enemy);
                break;
            case "surrender":
                player.surrender();
                break;
            default:
                System.out.println("Invalid action. Try again.");
                playerMove();
                break;
        }
    }



    private void enemyMove() {
        System.out.println("\nEnemy's turn:");
        if (enemy.getPosition() > player.getPosition()) {
            enemy.moveBackwards();
        } else {
            enemy.moveForward();
        }

        if (enemy.getPosition() == player.getPosition()) {
            enemy.attack(player);
        }
    }




    public static void main(String[] args) {
        Game game = new Game();
        game.welcomeMessage();

        game.play();
    }

}

