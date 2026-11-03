import java.util.Random;
import java.util.ArrayList;

public class getRandomValues {

    public static void main(String[] args) {
        Random rng1 = new Random(1);
        ArrayList<Integer> values1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            values1.add((int) (rng1.nextDouble() * 6) + 1);
        }
        System.out.println(values1 + " rng1");
         Random rng3 = new Random(3);
        ArrayList<Integer> values3 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            values3.add((int) (rng3.nextDouble() * 6) + 1);
        }
        System.out.println(values3 + " rng3");
    }
}
