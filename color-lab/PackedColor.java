import java.util.Scanner;

public class PackedColor {
    public static void main(String[] args) {
        // PROVIDED INPUT: enter three levels, such as 1.0 0.5 0.0, then press Enter.
        // Keep this setup. You do not need to implement input parsing.
        Scanner input = new Scanner(System.in);
        input.useLocale(java.util.Locale.ROOT);
        double redLevel = input.nextDouble();
        double greenLevel = input.nextDouble();
        double blueLevel = input.nextDouble();

        // YOUR CALCULATIONS: replace the placeholders. Use the input variables.
        int red = 0; // TODO RED: round redLevel * 255
        int green = 0; // TODO GREEN: round greenLevel * 255
        int blue = 0; // TODO BLUE: round blueLevel * 255
        int packedRgb = 0; // TODO PACK: multiplication and addition
        int recoveredRed = 0; // TODO RECOVER RED: from packedRgb only
        int recoveredGreen = 0; // TODO RECOVER GREEN: from packedRgb only
        int recoveredBlue = 0; // TODO RECOVER BLUE: from packedRgb only
        int largestPackedRgb = 0; // TODO MAXIMUM: calculate from the maximum channels

        // PROVIDED OUTPUT: preserve these labels, order, and spacing.
        System.out.println("Input levels: " + redLevel + ", " + greenLevel + ", " + blueLevel);
        System.out.println("Rounded RGB: " + red + ", " + green + ", " + blue);
        System.out.println("Packed RGB: " + packedRgb);
        System.out.println("Recovered RGB: " + recoveredRed + ", " + recoveredGreen + ", " + recoveredBlue);
        System.out.println("Largest packed RGB: " + largestPackedRgb);
        input.close();
    }
}