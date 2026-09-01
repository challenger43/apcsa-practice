import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class binaryValue {
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

            // while (individualBinary.size() < 6) {
            //     individualBinary.add(0, 0);
            // }

            Collections.reverse(individualBinary);
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