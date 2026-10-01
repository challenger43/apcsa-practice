public class IterationDay17 {
    public static void main(String[] args) {
        int a = 256;
        int b = 42;
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
