public class IntegerRoot {
    public static void main(String[] args) {
        int n = 1000000;
        int lower = 0;
        int upper = 1001;
        int midpoint = 0;
        while ((upper - lower) > 1) {
            midpoint = (lower + upper) / 2;
            if ((midpoint*midpoint) <= n) {
                lower = midpoint;
            } else {
                upper = midpoint;
            }
        }
        System.out.println(lower);
    }
}
