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
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class binaryClockMath {
    public static void main(String[] args) {
        System.out.print(
                "Type the current time separated by 2 colons. Each value in between colons should be 1-2 digits. ");
        Scanner input = new Scanner(System.in);
        String pattern = "\\d{1,2}:\\d{1,2}:\\d{1,2}";
        while (!input.hasNext(pattern)) {
            System.out.println("Type the current time separated by 2 colons. For example, 02:54:49 ");
            input.next();
        }
        List<List<Integer>> binary = new ArrayList<>();
        String timeString = input.next();
        String[] timeParts = timeString.split(":");
        for (int i = 0; i < 3; i++) {
            int integer = Integer.parseInt(timeParts[i]);
            int ogInt = integer;
            List<Integer> individualBinary = new ArrayList<>();

            if (integer == 0) {
                individualBinary.add(0);
            }

            while (integer > 0) {
                individualBinary.add(integer % 2);
                integer /= 2;
            }
            Collections.reverse(individualBinary);
            while (individualBinary.size() < 6) {
                individualBinary.add(0, 0);
            }

            binary.add(individualBinary);
        }

        StringBuilder sb = new StringBuilder();
        String result = "";
        for (List<Integer> individualBinary : binary) {
            sb.append(individualBinary);
        }

        System.out.print(sb);
    }

}
// String timeValue = "";
// if (i==0) timeValue = "hours";
// else if (i == 1) timeValue = "minutes";
// else timeValue = "seconds";
// // System.out.print(binary + " " + timeValue + " is " + ogInt + " in base
// 10.");