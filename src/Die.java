import java.util.Random;

public class Die {
    Random random = new Random();

    private int value;

     public int roll() {
         value = random.nextInt(6) - 1;

         return value;
     }

}
