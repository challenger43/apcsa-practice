import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections; 

public class binaryValue {
    public static void main(String[] args) {
        System.out.print("Please type an integer: ");
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("You need to type an integer.");
            input.next();
        }
        List<Integer> binary = new ArrayList<>();
        int integer = input.nextInt();
        if (integer == 0){
            binary.add(0);
        }
        while (integer > 0) {
            binary.add(integer % 2);
            integer /= 2;
        }
        Collections.reverse(binary);
        System.out.println(binary);
    }
}