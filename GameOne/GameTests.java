import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameTests {
    public static void main(String[] args) {
        // Add at least three cases per game method before Checks.finish().
        // Checks.equal(Game.yourMethod(chosenInput), expectedResult, "case
        // description");
        // checkRoll
        Checks.equal((Game.checkRoll(1)), true, "catches 1");
        Checks.equal((Game.checkRoll(4)), false, "should pass"); // aka equal false;
        Checks.equal((Game.checkRoll(6)), false, "should pass");

        // checkWinner
        Checks.equal((Game.checkWinner(3, 15)), false, "checks if any player score >= 100");
        Checks.equal((Game.checkWinner(100, 15)), true, "checks if any player score >= 100");
        Checks.equal((Game.checkWinner(105, 116)), true, "checks if any player score >= 100");

        // whoWon
        Checks.equal((Game.whoWon(100, "player1", 0, "player2")), "Player1",
                "Checks who has bigger score, given at least 1 score greater than 100");
        Checks.equal((Game.whoWon(100, "player1", 105, "player2")), "Player2",
                "Checks who has bigger score, given at least 1 score greater than 100");
        Checks.equal((Game.whoWon(100, "player1", 100, "player2")), "Player2",
                "Checks who has bigger score, given at least 1 score greater than 100");
        // checks roll
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
        // calculating total:
        // list of: immutable
        Checks.equal(Game.calculateTurnTotal(new ArrayList<>(List.of(1, 4, 6))), 0, "should sum up array"); // cannot
                                                                                                                // pass
                                                                                                                // in
                                                                                                                // array
                                                                                                                // with
                                                                                                                // curly
                                                                                                                // brackets
        Checks.equal(Game.calculateTurnTotal(new ArrayList<>(List.of(4, 4, 6))), 14, "should sum up array");
        Checks.equal(Game.calculateTurnTotal(new ArrayList<>(List.of(6, 4, 1))), 0, "should sum up array");

        // getRolls
        // empty roll aka uesr no roll
        Checks.equal(Game.getRolls(new Scanner(new ByteArrayInputStream("n\n".getBytes())), new Random(16)),
                new ArrayList<Integer>(), "returns empty list if user doesn't wanna roll");
        // rolls 4 then chickens
        Random rngTester = new Random(16);
        ArrayList<Integer> expected4 = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            expected4.add((int)(rngTester.nextDouble()*6) + 1);
        }
          ArrayList<Integer> expected6 = new ArrayList<>();
        Random rngTester2 = new Random(17);
        for (int i = 0; i < 6; i++) {
            expected6.add((int)(rngTester2.nextDouble()*6) + 1);
        }

        Checks.equal(Game.getRolls(new Scanner(new ByteArrayInputStream("y\ny\ny\ny\nn\n".getBytes())), new Random(16)),
                expected4, "returns result of 4 rolls, whatever random seed 16 wants it to be");
        //17a
        Checks.equal(Game.getRolls(new Scanner(new ByteArrayInputStream("y\ny\ny\ny\ny\ny\nn\n".getBytes())), new Random(17)),
                expected6, "returns result of 6 rolls, should fail bc random seed of 17 has 1 as 3rd value");
        //check 17a should fail, because its seed is 551, meaning that at the 1 it should cut off, which wouldn't comopare correctly to 6 value array
        //17b
        //this one should succeed, i modified array
        ArrayList<Integer> expected6b = new ArrayList<>();
        Random rngTester6b = new Random(17);
        for (int i = 0; i < 6; i++) {
            int currentRoll = ((int)(rngTester6b.nextDouble()*6) + 1);
            expected6b.add(currentRoll);
            if (currentRoll == 1){
                break;
            } 
        }
        Checks.equal(Game.getRolls(new Scanner(new ByteArrayInputStream("y\ny\ny\ny\ny\ny\nn\n".getBytes())), new Random(17)),
                expected6b, "should work, chop off array if 1 is spotted");

        // Checks.equal(Game.turn("player", new ByteArrayInputStream("n".getBytes())),
        // 0, "turn test 1");
        // Checks.equal(Game.turn("player", new
        // ByteArrayInputStream("yyyn".getBytes())), 1, "turn test 1");
        // Checks.equal(Game.turn("player", new
        // ByteArrayInputStream("nyyyn".getBytes())), 1, "turn test 1");
        Checks.finish();
    }
}
