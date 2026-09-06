import java.util.Scanner;

public class StringPractice {

    public static String practice(String input) {
        int split = input.indexOf(" ");
        int length = input.length();
        String firstWord = input.substring(0, split);
        String secondWord = input.substring(split + 1);
        return firstWord + "," + secondWord + "," + length;
    }

    public static String oneSpace(String input) {
        int space1 = input.indexOf(' ');
        return Boolean.toString(space1 != -1 && space1 == input.lastIndexOf(' '));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String startPhrase = "The first two evolution stages of the ";
        // String phrase1 = "Wooper Quagsire";
        // String phrase2 = "Psyduck Golduck";
        System.out.println("Enter the first two stages of a pokemon with two evolutions, separated by a space. Do not include other spaces");
        while (!input.hasNextLine()) {
            System.out.println("make sure to type something.");
            input.nextLine();
        }
        String tempValue = input.nextLine();
        while (!tempValue.contains(" ") || oneSpace(tempValue).equals("false")) {
            System.out.println("Follow directions.");
            if (input.hasNextLine()) {
                tempValue = input.nextLine();
            } else {
                input.nextLine();
            }
        }

        String phrase = practice(tempValue);
        String[] parts = phrase.split(",");
        String firstWord = parts[0];
        String secondWord = parts[1];
        String length = parts[2];
        String summary = startPhrase + firstWord + " line are " + firstWord + " and " + secondWord
                + ". " + " It contains " + length + " characters";
        // boolean unchanged = phrase.equals("Wooper Quagsire");

        System.out.println(summary);
        // System.out.println("Original unchanged: " + unchanged);
    }
}
