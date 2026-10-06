public class Euclid { //tested values all succeed 
    public static void main(String[] args) {
        int a = 7;
        int b = 0;
        int steps = 0;
        if (b == 0 || a == 0) { //initial check to make sure that the values actually work and aren't 0, make sure something is printed in case the while loop
        //value is false (meaning it won't print anything without this line)
            System.out.println(a);
            System.out.println(0);
        }
        while (b != 0) { //while b doesn't equal 0
            if (!(a > 0 && b >= 0 && a <= 1000000 && b <= 1000000)) {
                return;
            }
            int tempVar = a % b;
            a = b;
            b = tempVar; //changes value of b to the value of a%b, meaning eventually it should hit 0 once the GCD has been found
            steps++; //increase count 
            System.out.println("A: " + a + " Count: " + steps);
        }
    }
}
