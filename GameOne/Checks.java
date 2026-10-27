import java.util.Objects;

public class Checks {
    private static int passed = 0;
    private static int failed = 0;

    public static void equal(Object actual, Object expected, String label) {
        if (Objects.equals(actual, expected)) {
            passed++;
            System.out.println("PASS: " + label);
        } else {
            failed++;
            System.out.println("FAIL: " + label + " (expected " + expected
                    + ", got " + actual + ")");
        }
    }

    public static void finish() {
        if (passed + failed == 0) {
            throw new AssertionError("No tests yet. Add a check before Checks.finish().");
        }
        System.out.println(passed + " passed, " + failed + " failed.");
        if (failed > 0) {
            throw new AssertionError("One or more tests failed.");
        }
    }
}
