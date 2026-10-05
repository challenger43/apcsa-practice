public class IntegerRoot {
    public static void main(String[] args) {
        int n = 1000000;
        int lower = 0;
        int upper = 1001;
        int midpoint = 0;
        while ((upper - lower) > 1) { //while lower and upper are not one number apart
            midpoint = (lower + upper) / 2; //reset midpoint 
            if ((midpoint*midpoint) <= n) { //progressively "squishes" the number into a bounds
                lower = midpoint;
            } else {
                upper = midpoint;
            }
        }
        System.out.println(lower);
    }
}
