public class shieldBar {
    public static String filled(int origValue, int multiplier, int divisor) {
        String result = "[";
        int value = origValue * multiplier / divisor;
        for (int position = 0; position < 10; position++) {
            if (position < value) {
                result = result + '#';
            } else {
                result = result + "-";
            }
        }
        result = result + "]";
        return result;
    }
    public static String renderString(int shield){
        String shieldReport = filled(shield, 10, 40);
        return shieldReport;
    }
    public static void main(String[] args){
        System.out.println(renderString(25));
    }

}
