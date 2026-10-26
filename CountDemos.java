public class CountDemos {
    public static void main(String[] args) {
        int charges[] = { 62, 28, 85, 14, 47 };
        int lowCount = countBelow(charges, 80);
        int atLeast = countAtLeast(charges, 80);
        System.out.println(lowCount);
        System.out.println(atLeast);
    }

    public static int countBelow(int[] charges, int threshold) { // parameters: variables that can be interchangeable in
        // a function. for example, instead of needing to
        // manually change each variable each time you run
        // (which would be impractical for users who don't
        // understand code)
        // you simply can just input what you want into the function, meaning you can
        // call a function multiple times without needing to rewrite it each time.
        int count = 0;
        for (int value : charges) {
            if (value < threshold) {
                count++;
            }
        }
        return count;
    }

    public static int countAtLeast(int[] charges, int threshold) {
        int count = 0;
        for (int value : charges) {
            if (value >= threshold) {
                count++;
            }
        }
        return count;
    }
}
