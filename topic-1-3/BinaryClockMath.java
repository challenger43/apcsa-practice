// // day 6
// public class BinaryClockMath {
//     public static void main(String[] args) {
//         int clockValue = 45; //thing you wanna calculate
//         int remaining = clockValue; //set remaining to clockValue which is set above

//         int bit1 = remaining % 2; //remainder of clockValue/remaining divided by 2 e.g. if 45 becomes 1
//         remaining = remaining / 2;  //changing the value of remaining by setting it to itself divided by 2, e.g. if 45/2 = 22
//         int bit2 = remaining % 2; //remainder of the current remainder (now 22)
//         remaining = remaining / 2;
//         int bit4 = remaining % 2;
//         remaining = remaining / 2;
//         int bit8 = remaining % 2;
//         remaining = remaining / 2;
//         int bit16 = remaining % 2;
//         remaining = remaining / 2;
//         int bit32 = remaining % 2;

//         String bits = "" + bit32 + bit16 + bit8 + bit4 + bit2 + bit1; //put on backwards because the first value that is calculated is actually the smallest value, and it is reversed
//         // I think you have to add the "" because it is a string type, and perhaps like double and int String overrides int?
//         System.out.println(clockValue + " -> " + bits);
//     }
// }

//day 7 
import java.util.Scanner; //allows user input from terminal
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class binaryClockMath {
    public static void main(String[] args) {
        System.out.print(
                "Type the current time separated by 2 colons. Each value in between colons should be 1-2 digits. ");
        Scanner input = new Scanner(System.in);
        String pattern = "\\d{1,2}:\\d{1,2}:\\d{1,2}"; //regex to ensure no value errors
        while (!input.hasNext(pattern)) { //validation loop
            System.out.println("Type the current time separated by 2 colons. For example, 02:54:49 ");
            input.next();
        }
        List<List<Integer>> binary = new ArrayList<>(); //create a list of array lists
        String timeString = input.next(); //take the first valid input and set it to time string
        String[] timeParts = timeString.split(":"); //split up timestring into the 3 numerical values given and put it into an array of strings
        for (int i = 0; i < 3; i++) { //loop over each numerical value of timestring
            int integer = Integer.parseInt(timeParts[i]); //convert string to an integer
            int ogInt = integer; //remember the original integer before conversion
            List<Integer> individualBinary = new ArrayList<>(); //create a "temporary" list 

            if (integer == 0) { //in case it just equals 00 as a case check
                individualBinary.add(0);
            }

            while (integer > 0) {
                individualBinary.add(integer % 2); //binary math stuff
                integer /= 2;
            }
            Collections.reverse(individualBinary); //reverse it because it is being pushed in reverse
            while (individualBinary.size() < 6) { //add 0's to the front to keep it at a 6 bit form to make it easier to read
                individualBinary.add(0, 0); //index value to add to front
            }

            binary.add(individualBinary); // push the created list into the original list of string list 
        }
        StringBuilder sb = new StringBuilder(); //make a stringbuilder object thingie
        int iterations = 0; //iteration counter
        for (List<Integer> binaryNumber : binary) { //for of/each loop equivalent
            for (int digit : binaryNumber) { //for of loop again
                sb.append(digit); //add each digit from the subList of binaryNumber to the string
            }
            if (iterations < 2) { //only add for the first two, don't add to the last one or else you end up with 03:03:03: with an extra colon which doesn't look good
                sb.append(":");
            }
            iterations++; //next iteration
        }
        // checking aka verifying it and reversing the binary calculation
        int iteration = 0; //iteration counter for my second loop (difference is iterationS vs iteration)
        StringBuilder recalculate = new StringBuilder(); //make another stringbuilder object
        for (List<Integer> binaryNumber : binary) {
            int tempSum = 0;
            for (int i = 5; i >= 0; i--) { //reverse the binary
                double digitToAdd = binaryNumber.get(i) * Math.pow(2, 5 - i); //get each integer, then multiply it by 2^(5-current iteration)
                tempSum += digitToAdd; //add to tempsum
            }
            String tempSumString = Integer.toString(tempSum); //turn tempsum into an integer so you can add it to a string
            if (tempSumString.length() < 2){ //to keep formatting consistent, if sum is just 3, put a 0 in front of it so it becomes 03:03:03
                tempSumString = "0" + tempSumString;
            }
            recalculate.append(tempSumString); //slap tempSumString(one number value) onto recalculate
            if (iteration < 2) {
                recalculate.append(":"); //same concept as explained above
            }
            iteration++;
        }
        // StringBuilder sb = new StringBuilder();

        System.out.println("The time in binary values is: " + sb + ", or in regular digits, " + recalculate);
        System.out.println("It is " + sb.substring(0,6) + " or in base ten, " + recalculate.substring(0,2) + " hours, " + sb.substring(7,13) + " or in base ten, " + recalculate.substring(3,5) + " minutes, " + sb.substring(14,20) + " or in base ten, " + recalculate.substring(6,8) + " seconds.");
    }

}
// String timeValue = "";
// if (i==0) timeValue = "hours";
// else if (i == 1) timeValue = "minutes";
// else timeValue = "seconds";
// // System.out.print(binary + " " + timeValue + " is " + ogInt + " in base
// 10.");