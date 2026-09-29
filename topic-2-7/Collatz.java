import java.util.ArrayList;

public class Collatz {
    public static void main(String[] args) {
        int startInt = 999999;
        int steps = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        while (startInt != 1) {
            if (!(steps < 1000 && startInt <= 1000000)) {
                System.out.println("LIMIT REACHED");
                return;
            }
            if (startInt % 2 == 0) {
                startInt /= 2;
            } else {
                startInt *= 3;
                startInt++;
            }
            numbers.add(startInt);
            steps++;
            System.out.println("Step: " + steps + " Current Value: " + startInt);
        }
        int peak = numbers.get(0);
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > peak) {
                peak = numbers.get(i);
            }
        }
        System.out.println(peak);
    }
}
