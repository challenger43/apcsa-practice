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
        Random rng = new Random(0);
        int[] results = { 5, 2, 4, 4, 4, 2, 3, 6, 6, 6 };
        for (int i = 0; i < results.length; i++) {
            Checks.equal(Game.roll(rng), results[i], "deterministic rng");
        }
        Checks.finish();
    }
}
