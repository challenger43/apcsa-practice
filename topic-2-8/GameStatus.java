public class GameStatus {

    public static int clamp(int value, int min, int max) {
        if (value < min) {
            return min;
        } else if (value > max) {
            return max;
        }
        return value;
    }

    // Keep this method's name, parameters, and returned report.
    public static String filled(int origValue, int multiplier, int divisor){
        String result = "[";
        int value = origValue * multiplier/ divisor;  
        for (int position = 0; position< 10; position++){
            if (position < value){
                result = result + '#';
            }
            else{
                result = result + "-";
            }
        }
        result = result + "]";
        return result; 
    }
    public static String durations(int secondsPassed){
        int minutesPassed = secondsPassed /60;
        int remainderPassed = secondsPassed %60; 
        String result = minutesPassed + ":";
        if (remainderPassed < 10){
            result  = result + "0";
        }
        return result + remainderPassed;
    }
    public static int findMax(int[] scores){
        int highest = scores[0]; //find highest score
        for (int score : scores) {
            if (score > highest) {
                highest = score;
            }
        }
        return highest;
    }
    // Add your own static helper methods inside this class, outside other methods.
    public static String renderStatus(String name, int health, int energy,
            int elapsedSeconds, int bestSeconds, int[] scores) {
        // Bound the two meters.

        int shownEnergy = clamp(energy, 0, 60);
        int shownHealth = clamp(health, 0, 100);
        // Integer division keeps the whole-number part.

       String healthBar = filled(shownHealth, 10, 100);
       String energyBar = filled(shownEnergy, 10, 60);

        // Format two durations.
        String elapsedText = durations(elapsedSeconds);
        String bestText = durations(bestSeconds);
        // Summarize the recent scores.
        int total = 0;
        for (int score : scores) {
            total = total + score;
        }
        int highest = findMax(scores);
       
        int strongCount = 0;  //find scores greater than 80; 
        for (int score : scores) {
            if (score >= 80) {
                strongCount = strongCount + 1;
            }
        }

        // Choose a level from the total.
        String level;
        if (total < 100) {
            level = "Rookie";
        } else if (total < 250) {
            level = "Skilled";
        } else {
            level = "Expert";
        }

        // Return one report. \n separates its lines; there is no final \n.
        String report = "PLAYER: " + name;
        report = report + "\nHealth  " + healthBar + " " + shownHealth + "/100";
        report = report + "\nEnergy  " + energyBar + " " + shownEnergy + "/60";
        report = report + "\nLevel:  " + level;
        report = report + "\nTime:   " + elapsedText;
        report = report + "\nBest:   " + bestText;
        report = report + "\nRecent: total=" + total;
        report = report + ", best=" + highest + ", 80+=" + strongCount;
        return report;
    }

    // Supplied demo. The test file has its own main method.
    public static void main(String[] args) {
        System.out.println(renderStatus("Nova", 75, 18, 125, 119, new int[] { 40, 50, 90 }));
        System.out.println();
        System.out.println(renderStatus("Orion", 110, -4, 61, 60, new int[] { 80, 80, 90 }));
    }
}
