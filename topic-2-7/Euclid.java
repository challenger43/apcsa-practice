public class Euclid {
    public static void main(String[] args) {
        int a = 7;
        int b = 0;
        int steps = 0;
        if (b == 0 || a == 0) {
            System.out.println(a);
            System.out.println(0);
        }
        while (b != 0) {
            if (!(a > 0 && b >= 0 && a <= 1000000 && b <= 1000000)) {
                return;
            }
            int tempVar = a % b;
            a = b;
            b = tempVar;
            steps++;
            System.out.println("A: " + a + " Count: " + steps);
        }
    }
}