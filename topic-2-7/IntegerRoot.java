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

//extension: each check preserves that lower^2 < n <upper^2 because if midpoint is greater than lower,  lower will be the new midpoint, and otherwise, the new midpoint will be the upper number
// this means that no matter what, midpoint will never be lower than lower or higher than higher. kidn of hard to explain but yes as in my comment it just squishes the number into bounds by closing off distance
//you know youve found your number when margin = 1 because there is no more lower or upper to split/ halve.
