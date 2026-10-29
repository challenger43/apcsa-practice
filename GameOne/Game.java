import java.io.InputStream;
import java.util.Scanner;

public class Game {
    // Define your own public static methods here.
    public static int roll() {
        return (int) (Math.random() * 6) + 1;
    }

    public static boolean checkRoll(int firstRoll) {
        return firstRoll == 1;
    }

    public static int turn(String player, InputStream s) {
        System.out.println("Welcome " + player);
        Scanner scanner = new Scanner(s);
        int tempTotal = 0;
        while (!scanner.nextLine().equals("n")) {
            System.out.println("roll? y/n");
            int roll = roll();
            System.out.println("This was your roll: " + roll);
            if (checkRoll(roll)) {
                System.out.println("You rolled a 1, so your score reset.");
                return 0;
            }
            tempTotal += roll;
            System.out.println("Turn Total: " + tempTotal);
        }
        // scanner.close();
        return tempTotal;
    }

    public static boolean checkWinner(int player1Score, int player2Score) {
        return (player1Score <= 100 || player2Score <= 100);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int player1Score = 0;
        int player2Score = 0;
        System.out.println("Play with clanker? True/False");
        boolean humanMode = input.nextBoolean();
        if (!humanMode) {
            System.out.println("Your turn first: ");
            while (checkWinner(player1Score, player2Score)) {
                player1Score = turn("player1", System.in);
                player2Score = turn("player2", System.in);
            }
        }

        // Build your playable game here, calling your methods.
    }
}
