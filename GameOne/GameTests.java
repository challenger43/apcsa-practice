import java.io.ByteArrayInputStream;
import java.util.Random;

public class GameTests {
    public static void main(String[] args) {
        // Add at least three cases per game method before Checks.finish().
        // Checks.equal(Game.yourMethod(chosenInput), expectedResult, "case description");
        // checkRoll
        Checks.equal((Game.checkRoll(1)), true, "catches 1");
        Checks.equal((Game.checkRoll(4)), false, "should pass"); // aka equal false;
        Checks.equal((Game.checkRoll(6)), false, "should pass");

        //checkWinner
        Checks.equal((Game.checkWinner(3, 15)), false, "checks if any player score >= 100");
        Checks.equal((Game.checkWinner(100, 15)), true, "checks if any player score >= 100");
        Checks.equal((Game.checkWinner(105, 116)), true, "checks if any player score >= 100");

        //whoWon

        Checks.equal((Game.whoWon(100, "player1", 0, "player2")), "Player1", "Checks who has bigger score, given at least 1 score greater than 100");
        Checks.equal((Game.whoWon(100, "player1", 105, "player2")), "Player2", "Checks who has bigger score, given at least 1 score greater than 100");
        Checks.equal((Game.whoWon(100, "player1", 100, "player2")), "Player2", "Checks who has bigger score, given at least 1 score greater than 100");
        //checks roll
        Random rng = new Random(0);
        int[] results = { 5, 2, 4, 4, 4, 2, 3, 6, 6, 6 };
        for (int i = 0; i < results.length; i++) {
            Checks.equal(Game.roll(rng), results[i], "deterministic rng, seed 0");
        }
        Random rng1 = new Random(1); // other two tests are here
        int[] results1 = { 5, 1, 5, 2, 4, 5, 6, 2, 5, 1 };
        for (int i = 0; i < results1.length; i++) {
            Checks.equal(Game.roll(rng1), results1[i], "deterministic rng, seed 1");
        }
        Random rng3 = new Random(3);
        int[] results3 = { 4, 1, 1, 4, 6, 1, 2, 3, 1, 6 };
        for (int i = 0; i < results3.length; i++) {
            Checks.equal(Game.roll(rng3), results3[i], "deterministic rng, seed 3");
        }
          //score updater
        Checks.equal((Game.scores(5, 10)), new int[] {5+Game.roll(rng)}, "score updater given original score 5, plus whatever roll it rolled");
                // Checks.equal(Game.turn("player", new ByteArrayInputStream("n".getBytes())),
        // 0, "turn test 1");
        // Checks.equal(Game.turn("player", new
        // ByteArrayInputStream("yyyn".getBytes())), 1, "turn test 1");
        // Checks.equal(Game.turn("player", new
        // ByteArrayInputStream("nyyyn".getBytes())), 1, "turn test 1");
        Checks.finish();
    }
}
