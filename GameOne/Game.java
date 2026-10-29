import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class Game {
    public static int roll(Random rng) {
        int roll = (int) (rng.nextDouble() * 6) + 1;
        System.out.println("This was your roll: " + roll);
        return roll;
    }

    public static boolean checkRoll(int roll) {
        return roll == 1;
    }

    public static int turn(String player, InputStream s) {
        System.out.println("Welcome " + player);
        Scanner scanner = new Scanner(s);
        int tempTotal = 0;
        System.out.println("roll? y/n");
        while (scanner.hasNextLine() && !scanner.nextLine().equalsIgnoreCase("n")) {
            int roll = roll();
            if (checkRoll(roll)) {
                System.out.println("You rolled a 1, so your score reset.");
                return 0;
            }
            tempTotal += roll;
            System.out.println("Turn Current Total: " + tempTotal);
        }
        System.out.println(player + "'s score: " + tempTotal);
        return tempTotal;
    }

    public static boolean checkWinner(int player1Score, int player2Score) {
        return (player1Score >= 100 || player2Score >= 100);
    }

    public static String whoWon(int player1Score, String player1, int player2Score, String Player2) {
        String winner = player1Score > player2Score ? "Player1" : "Player2";
        System.out.println(winner);
        return winner;
    }

    public static String gamePlay() {
        System.out.println("Your turn first: ");
        String winner = "";
        boolean hasWinner = false;
        int turnCount = 0;
        int player1Score = 90;
        int player2Score = 90;
        while (turnCount <= 50 && !hasWinner) { //make another function
            player1Score += turn("player1", System.in);
            player2Score += turn("player2", System.in);
            turnCount++;
            if (checkWinner(player1Score, player2Score)) {
                System.out.println("We have a winner");
                return whoWon(player1Score, "player1", player2Score, "player2");
            }
        }
        return "tie, max movecount hit";
    }

    public static void main(String[] args) {
        
        // Scanner input = new Scanner(System.in);
        // boolean humanMode = input.nextBoolean();
        // System.out.println("Play with clanker? True/False");
        // gamePlay();
        Random rng = new Random(0);
        
        for (int i = 0; i < 10; i++) {
            roll(rng);
        }

        // Build your playable game here, calling your methods.
    }
}
