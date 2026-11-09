//potential extensions: 
//give ai more intelligence/add an ai mode, e.g. if the ai's turn total has exceeded 15 then bank it, or if their current turn count is greater than 5, or if it is their last chance
//to win, then make it make educated decisions rather than randomly inputting y/n. 
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Game {
    public static Random defaultRNG = new Random();

    public static int roll() {
        return roll(defaultRNG);
    }

    public static int roll(Random rng) {
        int roll = (int) (rng.nextDouble() * 6) + 1;
        return roll;
    }

    public static boolean checkRoll(int roll) {
        return roll == 1;
    }

    // new format for turn: split into better categories per functionality as right
    // before changes all the stuff was mixed into one function
    // rolling(user input), calculate total--do stuff with user input,
    // displayturnresult - tell player stuff, turn should be mainly function calls

    public static int turn(String player, Scanner scanner, Random rng) {
        System.out.println("Welcome " + player);
        ArrayList<Integer> rolls = getRolls(scanner, rng);
        int turnTotal = calculateTurnTotal(rolls);
        displayTurn(player, turnTotal);
        return turnTotal;
    }

    public static void displayTurn(String player, int turnTotal) { // dont rly need to return anything
        System.out.println(player + " " + turnTotal);
        if (turnTotal == 0) {
            System.out.println("You rolled a 1 so your score reset lol");
        } else {
            System.out.println("Here's your turn total: " + turnTotal);
        }
    }

    public static int calculateTurnTotal(ArrayList<Integer> rolls) {
        int total = 0;
        for (int roll : rolls) {
            if (checkRoll(roll)) {
                return 0;
            }
            total += roll;
        }
        return total;
    }

    public static ArrayList<Integer> getRolls(Scanner scanner, Random rng) {
        ArrayList<Integer> rolls = new ArrayList<>();
        System.out.println("roll? y/n");
        while (scanner.hasNextLine() && !scanner.nextLine().equalsIgnoreCase("n")) {
            int currentRoll = roll(rng);
            rolls.add(currentRoll);
            System.out.println("This was your roll: " + currentRoll);
            if (checkRoll(currentRoll)) {break;}
            System.out.println("roll again? y/n");
        }
        return rolls;
    }

    public static boolean checkWinner(int player1Score, int player2Score) {
        return (player1Score >= 100 || player2Score >= 100);
    }

    public static String whoWon(int player1Score, String player1, int player2Score, String Player2) {
        return player1Score > player2Score ? "Player 1" : "Player 2";
    } //yes i know techincally player 1 should win immediately but i felt like giving player 2 a chance to redemption
    //basically if player 1 rolls a 100 and calls it a day, player2 still gets their chance to try and get above player 1 to win

    public static void gamePlay() {
        System.out.println("Your turn first: ");
        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();
        String winner = "";
        boolean hasWinner = false;
        int turnCount = 0;
        int player1Score = 90; // used for ease of testing, set to 0 for a true game
        int player2Score = 90;
        while (turnCount <= 50 && !hasWinner) { // make another function
            int[] updatedScores = scores(player1Score, player2Score, scanner, rng); // not sure if this actually conslidated anything but it looks a bit cleaner?
            player1Score = updatedScores[0];
            System.out.println("Player 1 total: " + updatedScores[0]);
            player2Score = updatedScores[1];
            System.out.println("Player 2 total: " + updatedScores[1]);
            turnCount++;
            if (checkWinner(player1Score, player2Score)) {
                winner = whoWon(player1Score, "player1", player2Score, "player2");
                System.out.println("We have a winner: " + winner);
                break;
            }
        }
    }

    public static int[] scores(int player1Score, int player2Score, Scanner scanner, Random rng) {
        player1Score += turn("player1", scanner, rng);
        player2Score += turn("player2", scanner, rng);
        return new int[] { player1Score, player2Score }; // make array to return two values at a time
    }

    public static void main(String[] args) {
        gamePlay();
    }
}
