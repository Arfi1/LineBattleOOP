import java.util.Scanner;

public class Game {
    private Player player;
    private Player enemy;

    public Game() {
        player = new Player (10, 25, 2500, 1);
        enemy = new Player (-10, 25, 2500, 1);
    }

    public void play() {
        Scanner keyboard = new Scanner(System.in);

        while (player.getSoldiers() > 0 && enemy.getSoldiers() > 0) {

            System.out.println("Spillerens tur");


        }

    }


}

