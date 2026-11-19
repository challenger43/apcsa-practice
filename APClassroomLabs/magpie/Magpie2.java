package APClassroomLabs.magpie;

public class Magpie2 {
    /**
     * Pick a default response to use if nothing else fits.
     * 
     * @return a non-committal string
     */
    private String getRandomResponse() {
        final int NUMBER_OF_RESPONSES = 6;
        int whichResponse = (int) (Math.random() * 6); // revise this assignment statement
        String response = "";

        if (whichResponse == 0) {
            response = "Interesting.";
        } else if (whichResponse == 1) {
            response = "Okay.";
        } else if (whichResponse == 2) {
            response = "And...?";
        } else if (whichResponse == 3) {
            response = "Did you hit your head?";
        } else if (whichResponse == 4) {
            response = "Why are you telling me this?";
        } else if (whichResponse == 5) {
            response = "Sounds like a skill issue.";
        }
        return response;
    }

    /**
     * Get a default greeting
     * 
     * @return a greeting
     */
    public String getGreeting() {
        return "Hello, this is your neighborhood clanker. Type in \"Bye\" to end our chat.";
    }

    /**
     * Gives a response to a user statement
     * 
     * @param statement the user statement
     * @return a response based on the rules given
     */

    private int findPhrase(String statement, String goal, int startPos) {
        String phrase = statement.toLowerCase();
        goal = goal.toLowerCase();
        int position = phrase.indexOf(goal, startPos);
        while (position >= 0) {
            String before = " ", after = " ";
            if (position > 0) {
                before = phrase.substring(position - 1, position);
            }
            if (position + goal.length() < phrase.length()) {
                after = phrase.substring(position + goal.length(),
                        position + goal.length() + 1);
            }

            /*
             * determine the values of index, before, and after at this point in the method.
             */
            if (((before.compareTo("a") < 0) || (before.compareTo("z") > 0)) &&
                    ((after.compareTo("a") < 0) || (after.compareTo("z") > 0))) {
                return position;
            }
            position = phrase.indexOf(goal, position + 1);
        }
        return -1;
    }

    public String getResponse(String statement) {
        String response = "";
        if (findPhrase(statement, "science", 0) !=-1 || findPhrase(statement, "math", 0) !=-1 ){
            response = "STEM nerd wow you so smart.";
        }
        else if (findPhrase(statement, "rhs", 0) != -1) {
            response = "wow you go to RHS so amazing";
        } 
        else if (findPhrase(statement, "why", 0) != -1) {
            response = "why not.";
        } 
        else if (findPhrase(statement, "mean", 0) != -1){
            response = "what? you want me to be a good clanker and glaze you?";
        }
        else {
            response = getRandomResponse();
        }

        return response;
    }
}
