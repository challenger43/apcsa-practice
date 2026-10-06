public class DigitCollapse { // all values match provided tests
    public static void main(String[] arg) {
        int number = 8975;
        int steps = 0;
        while (number > 9) { // while number is two digit number
            int sum = 0; // set a "temporary sum" to be used in the following while loop, it resets each
                         // time the outerloop passes
            while (number > 0) { // while number is still two digit number
                int digit = number % 10; // digit = last digit of number
                sum += digit; // add to the temporary sum
                number /= 10; // take off that digit from the number
            } // repeats until
            number += sum; // after the first pass in the case of 9875, sum is 20. which means it passes
                           // back, as 20>9, to be reiterated over again. this will lead to it equalling 2.
            steps++;
        }

        System.out.println("Sum: " + number);
        System.out.println("Steps: " + steps);
        test();
    }
//extension:
    static void test() {

        for (int number = 0; number < Integer.MAX_VALUE; number++) {
            int steps = 0;
            int temp = number;
            while (temp > 9) { // while number is two digit number
                int sum = 0; // set a "temporary sum" to be used in the following while loop, it resets each
                             // time the outerloop passes
                while (temp > 0) { // while number is still two digit number
                    int digit = temp % 10; // digit = last digit of number
                    sum += digit; // add to the temporary sum
                    temp /= 10; // take off that digit from the number
                } // repeats until
                temp = sum; // after the first pass in the case of 9875, sum is 20. which means it passes
                               // back, as 20>9, to be reiterated over again. this will lead to it equalling 2.
                steps++;
            }
            if (steps == 3) {
                System.out.println("Number: " + number);
                System.out.println("Steps: " + steps);
                return;
            }
        }
        System.out.println("Test failed to find a value");

    }
}// reverse engineering a smaller number taking three passes-
 // try: 999 -- fail: inside only runs twice (which leads to sum = 18, and number
 // = 27, (9+18), on second iteration number = 2 and sum =7,which when added
 // together equal 1, failing the first condition (while number> 9) so it only
 // iterates twice ),
 // in other words, the number going into the second iteration needs to have a
 // sum greater than 9 or else it will not iterate again, which, ironically means
 // 8989 is actually ineffective - it adds up to 34,
 // so i shouldn't make the number too big, but focus on getting a number that
 // when its own digits are added together, it will still be greater than 9.
 // 558
 // maybe ill write a quick program to find it mechanically
 //ok nvm it's impossible
 //nvm it is possible i just messed up bah
