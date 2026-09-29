public class IterationDay17 {
    public static void main(String[] args) {
        int a = 7;
        int b = 7;
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        System.out.println(a);
    }
}
