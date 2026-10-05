public class DigitCollapse { //all values match provided tests
    public static void main(String[] arg) {
        int number = 9875;
        int steps = 0;
        while (number > 9) { //while number is two digit number
            int sum = 0; //set a "temporary sum" to be used in the following while loop, it resets each time the outerloop passes
            while (number > 9) { //while number is still two digit number
                int digit = number % 10; //digit = last digit of number 
                sum += digit; //add to the temporary sum
                number /= 10; //take off that digit from the number
            } //repeats until 
            number += sum; //after the first pass in the case of 9875, sum is 20. which means it passes back, as 20>9, to be reiterated over again. this will lead to it equalling 2.
            steps++;
        }

        System.out.println("Sum: " + number);
        System.out.println("Steps: " + steps);
    }
}
