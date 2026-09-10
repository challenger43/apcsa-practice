import java.awt.Color;
import java.util.Scanner;

public class ColorApi {
    public static void main(String[] args) {
        // PROVIDED INPUT: packed RGB, red, green, blue. Example: 16744448 255 128 0
        // Keep this setup. You do not need to implement input parsing.
        Scanner input = new Scanner(System.in);
        int packedRgb = input.nextInt();
        int red = input.nextInt();
        int green = input.nextInt();
        int blue = input.nextInt();

        Color fromPacked = new Color(packedRgb); // TODO PACKED CONSTRUCTOR: use packedRgb
        Color fromChannels = new Color(red, green, blue); // TODO CHANNEL CONSTRUCTOR: use the channel variables
        int packedRed = fromPacked.getRed(); 
        int packedGreen = fromPacked.getGreen();
        int packedBlue = fromPacked.getBlue(); 
        int packedAlpha = fromPacked.getAlpha();
        int directRed = fromChannels.getRed(); // TODO DIRECT RED: call the getter on fromChannels
        int directGreen = fromChannels.getGreen(); // TODO DIRECT GREEN: call the getter on fromChannels
        int directBlue = fromChannels.getBlue(); // TODO DIRECT BLUE: call the getter on fromChannels
        int directAlpha = fromChannels.getAlpha(); // TODO DIRECT ALPHA: call the getter on fromChannels

        // PROVIDED OUTPUT: preserve these labels, order, and spacing.
        System.out.println("Packed input " + packedRgb + " -> RGB " + packedRed + ", " + packedGreen + ", " + packedBlue + "; alpha " + packedAlpha);
        System.out.println("Direct channels " + red + ", " + green + ", " + blue + " -> RGB " + directRed + ", " + directGreen + ", " + directBlue + "; alpha " + directAlpha);
        input.close();
    }
}