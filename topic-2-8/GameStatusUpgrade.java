public class GameStatusUpgrade {
    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        }
        return value;
    }

    public static String filled(int origValue, int multiplier, int divisor) {
        // String result = "[";
        // int value = origValue * multiplier / divisor;
        // int amountFill = divisor / multiplier;
        // int percentFill = ((origValue / divisor + 5) / 10) * 10;
        // for (int position = 0; position < amountFill; position++) {
        //     if (position < value) {
        //         result += '#';
        //     } else {
        //         result += "-";
        //     }
        // }
        // result += "]";
        // return result;
         String result = "[";
        int value = origValue * multiplier / divisor;
        for (int position = 0; position < 10; position++) {
            if (position < value) {
                result += '#';
            } else {
                result += "-";
            }
        }
        result += "]";
        return result;
    }

    public static String durations(int secondsPassed) {
        int minutesPassed = secondsPassed / 60;
        int remainderPassed = secondsPassed % 60;
        String result = minutesPassed + ":";
        if (remainderPassed < 10) {
            result += "0";
        }
        return result + remainderPassed;
    }

    public static int findMax(int[] scores) {
        int highest = scores[0]; // find highest score
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }

    public static int findTotal(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total;
    }

    public static String level(int total) {
        if (total < 100) {
            return "Rookie";
        } else if (total < 250) {
            return "Skilled";
        } else {
            return "Expert";
        }
    }

    // Add your own static helper methods inside this class, outside other methods.
    public static String renderStatus(String name, int health, int energy, int shield,
            int elapsedSeconds, int bestSeconds, int[] scores) {
        // Bound the two meters.

        int shownEnergy = clamp(energy, 0, 60);
        int shownHealth = clamp(health, 0, 100);
        int shownShield = clamp(shield, 0, 40);
        // Integer division keeps the whole-number part.

        String healthBar = filled(shownHealth, 10, 100);
        String energyBar = filled(shownEnergy, 10, 60);
        String shieldBar = filled(shownShield, 10, 40);

        // Format two durations.
        String elapsedText = durations(elapsedSeconds);
        String bestText = durations(bestSeconds);
        // Summarize the recent scores.

        int highest = findMax(scores);

        int strongCount = 0; // find scores greater than 80;
        for (int score : scores) {
            if (score >= 80) {
                strongCount = strongCount + 1;
            }
        }
        int total = findTotal(scores);
        // Choose a level from the total.
        String level = level(total);
        // Return one report. \n separates its lines; there is no final \n.
        String report = "PLAYER: " + name;
        report = report + "\nHealth  " + healthBar + " " + shownHealth + "/100"; // could technically skip some of these
                                                                                 // steps further, sacrificing
                                                                                 // readability
        report = report + "\nEnergy  " + energyBar + " " + shownEnergy + "/60"; // in other words, instead of making a
                                                                                // variable called shown health, you
                                                                                // could literally call
                                                                                // clamp(argumenets), replacing that in
                                                                                // this final string
        report = report + "\nShield  " + shieldBar + " " + shownShield + "/40";
        report = report + "\nLevel:  " + level;
        report = report + "\nTime:   " + elapsedText;
        report = report + "\nBest:   " + bestText;
        report = report + "\nRecent: total=" + total;
        report = report + ", best=" + highest + ", 80+=" + strongCount;
        return report;
    }

    // Supplied demo. The test file has its own main method.
    public static void main(String[] args) {
        System.out.println(renderStatus("Nova", 75, 18, 30, 125, 119, new int[] { 40, 50, 90 }));
        System.out.println();
        System.out.println(renderStatus("Orion", 110, -4, 25, 61, 60, new int[] { 80, 80, 90 }));
    }
}
