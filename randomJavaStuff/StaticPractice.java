package randomJavaStuff;

import java.util.Scanner;

public class StaticPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello World");
        String test = scanner.nextLine();
        say(test);
        scanner.close();
    }

    public static String say(String input) {
        System.out.println("Why " + input);
        return "absolutely useless return";
    }
}