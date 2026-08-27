public class StringPractice {
    public static void main(String[] args) {
        String phrase = "training report";

        int split = phrase.indexOf(" ");
        String firstWord = phrase.substring(0, split);
        String secondWord = phrase.substring(split + 1);
        String summary = firstWord + " / " + secondWord
                + " / " + phrase.length() + " characters";
        boolean unchanged = phrase.equals("training report");

        System.out.println(summary);
        System.out.println("Original unchanged: " + unchanged);
    }
}
