public class DigitCollapse {
    public static void main(String[] arg) {
        int number = 999;
        int steps = 0;
        while (number > 9) {
            int sum = 0;
            while (number > 9) {
                int digit = number % 10;
                sum += digit;
                number /= 10;

            }
            number += sum;
            steps++;
        }

        System.out.println("Sum: " + number);
        System.out.println("Steps: " + steps);
    }
}
