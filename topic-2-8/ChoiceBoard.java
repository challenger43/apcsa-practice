import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class ChoiceBoard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This will help you pick your favorite song.");
        ArrayList<String> songs = new ArrayList<>();
        System.out.println("Please enter a song:");
        songs.add(scanner.nextLine());
        while (songs.size() < 3) {
            System.out.println("Please enter another song:");
            songs.add(scanner.nextLine());
        }
        System.out.println(
                "Would you like to continue adding songs? You can keep entering songs until you type n and press enter.");
        String input;
        while (scanner.hasNextLine() && !(input = scanner.nextLine()).equals("n")) {
            songs.add(input);
            System.out.println("registered");
        }

        System.out.println(songs);
    }
}
