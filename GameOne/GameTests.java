import java.io.ByteArrayInputStream;
import java.util.Random;

public class GameTests {
    public static void main(String[] args) {
        // Add at least three cases per game method before Checks.finish().
        // Checks.equal(Game.yourMethod(chosenInput), expectedResult, "case
        // description");
        // checkRoll
        Checks.equal((Game.checkRoll(1)), true, "catches 1");
        Checks.equal((Game.checkRoll(4)), false, "should pass"); // aka equal false;
        Checks.equal((Game.checkRoll(6)), false, "should pass");
        // Checks.equal(Game.turn("player", new ByteArrayInputStream("n".getBytes())),
        // 0, "turn test 1");
        // Checks.equal(Game.turn("player", new
        // ByteArrayInputStream("yyyn".getBytes())), 1, "turn test 1");
        // Checks.equal(Game.turn("player", new
        // ByteArrayInputStream("nyyyn".getBytes())), 1, "turn test 1");
        Random rng = new Random(0); //in theory i could make 3 random tests, but if I did that it would fully mess up the game, so I made a new file, called GameRNG.java
        int[] results = { 5, 2, 4, 4, 4, 2, 3, 6, 6, 6 };
        for (int i = 0; i < results.length; i++) {
            Checks.equal(Game.roll(rng), results[i], "deterministic rng");
        }
        Random rng1 = new Random(1); //other two tests are here 
         int[] results1= { 5, 1, 5, 2, 4, 5, 6, 2, 5, 1 };
        for (int i = 0; i < results1.length; i++) {
            Checks.equal(GameRNG.roll(rng1), results1[i], "deterministic rng");
        }
        Random rng3 = new Random(3);
        int [] results3 = {4, 1, 1, 4, 6, 1, 2, 3, 1, 6};   
         for (int i = 0; i < results3.length; i++) {
            Checks.equal(GameRNG.roll(rng3), results3[i], "deterministic rng");
        }
        Random rng0 = new Random(0); 
        int[] results0 = { 5, 2, 4, 4, 4, 2, 3, 6, 6, 6 };
        for (int i = 0; i < results0.length; i++) {
            Checks.equal(GameRNG.roll(rng0), results0[i], "deterministic rng");
        }
                Checks.finish();
    }
}
