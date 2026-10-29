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
        while (scanner.hasNextLine() && !scanner.nextLine().equalsIgnoreCase("n")) {
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
        return tempTotal;
    }

    public static int clankerTurn(InputStream s) {
        System.out.println("Clanker turn: ");
        int tempTotal = 0;
        int turnCount = 0;
        while (tempTotal <= 20 && turnCount < 3) {
            int roll = roll();
            if (checkRoll(roll)) {
                return 0;
            }
            tempTotal += roll;
        }
        return tempTotal;
    }

    public static boolean checkWinner(int player1Score, int player2Score) {
        return (player1Score <= 100 || player2Score <= 100);
    }
    public static String whoWon(int player1Score, String player1, int player2Score, String Player2){
        return player1Score > player2Score ? "Player1" : "Player2"; 
    }
    public static String game(String player1, String player2, boolean gameMode){
        int player1Score = 0;
        int player2Score = 0;      
        String winner = "";
        if (gameMode) {
            System.out.println("Your turn first: ");
            int turnCount = 0;
            while (turnCount <= 50) {
                player1Score = turn("player1", System.in);
                player2Score = turn("player2", System.in);
                turnCount++; 
                if (checkWinner(player1Score,player2Score)){
                    System.out.println("we have a winner.");
                    winner = whoWon(player1Score, "player1", player2Score, "player2" );
                    System.out.println(winner);
                }
            }
        } else {
            while (checkWinner(player1Score, player2Score)) {
                System.out.println("your turn first");
                player1Score = turn("player1", System.in);
                player2Score = clankerTurn(System.in);
            }
        }
        return winner; 
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean humanMode = input.nextBoolean();
        System.out.println("Play with clanker? True/False");
        game("player1", "player2", humanMode);
       

        // Build your playable game here, calling your methods.
    }
}
