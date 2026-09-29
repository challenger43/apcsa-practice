public class DigitCollapse {
    public static void main(String[] arg) {
        int number = 9875;
        int steps = 0;
        while (number > 9) {
            int sum = 0;
            while (number > 9) {
                int digit = number % 10;
                sum += digit;
                number /= 10;
                System.out.println(" number " + number);
                System.out.println(" sum " + sum);
                System.out.println("digit: " + digit);
            }
            number = sum;
            steps++;
        }
        // while (number > 9){
        // int digit = number % 10;
        // sum += digit;
        // number /= 10;
        // }
        System.out.println("Sum: " + number);
        System.out.println("Steps: " + steps);
    }
}
