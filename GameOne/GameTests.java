import java.io.ByteArrayInputStream;

public class GameTests {
    public static void main(String[] args) {
        // Add at least three cases per game method before Checks.finish().
        // Checks.equal(Game.yourMethod(chosenInput), expectedResult, "case description");
        // Checks.equal(Game.turn("player",     new ByteArrayInputStream("n".getBytes())), 0,  "turn test 1");
        Checks.equal(Game.turn("player",     new ByteArrayInputStream("yyyn".getBytes())), 1,  "turn test 1");
        // Checks.equal(Game.turn("player", new ByteArrayInputStream("nyyyn".getBytes())),  1, "turn test 1");
        Checks.finish();
    }
}
