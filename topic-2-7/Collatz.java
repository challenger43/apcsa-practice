import java.util.ArrayList;
//tested inputs, all do succeed, e.g. 999999=transformation 1, peak 2999998, but prints Limit Reached because it is greater than 1000000
public class Collatz {
    public static void main(String[] args) {
        int startInt = 999999;
        int steps = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        while (startInt != 1) { //first condition, overall to ensure the whole loop runs correctly and that the loop correctly stops when the answer has been hit
            if (!(steps < 1000 && startInt <= 1000000)) { //checks per iteration that it is not out of range, if it is, then escape from loop and end program
                System.out.println("LIMIT REACHED");
                return;
            }
            if (startInt % 2 == 0) { //if even, divide by 2
                startInt /= 2;
            } else { //if odd, 3n-1
                startInt *= 3;
                startInt++;
            }
            numbers.add(startInt); //put in array for future sorting purposes
            steps++; //increase steps
            System.out.println("Step: " + steps + " Current Value: " + startInt);
            //what changes: startInt is changed by either being divided by 2 or 3n-1, and once it equals 1, you can know that you have a result
        }
        int peak = numbers.get(0);  //find greatest number. temporarily set the largest number to the first number
        for (int i = 0; i < numbers.size() - 1; i++) { //loop over
            if (numbers.get(i) > peak) { //if the current number is greater than peak, make that the new peak
                peak = numbers.get(i);
            }
        }
        System.out.println(peak);
    }
}
//extension: 
//if i put 3 it makes an infinite loop bc it will infinitely iterate as follows: 3 is not even ,so it will be multiplied by 3n-1, aka 8. 8 is even. 8%2 =0. 8/2 = 4 thiss is where the repetition starts.
// start int is now 4. 4 is even. 4/2 = 2. 2 is even. 2/2 = 1. 1 is odd. 3(1) + 1 = 4. and so goes on.   since it is and infinite loop, that means that it will check out past 1000 passes to prevent crash from infinite loop.