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

        Color fromPacked = new Color(packedRgb); 
        Color fromChannels = new Color(red, green, blue); 
        int packedRed = fromPacked.getRed(); 
        int packedGreen = fromPacked.getGreen();
        int packedBlue = fromPacked.getBlue(); 
        int packedAlpha = fromPacked.getAlpha();
        int directRed = fromChannels.getRed(); 
        int directGreen = fromChannels.getGreen(); 
        int directBlue = fromChannels.getBlue(); 
        int directAlpha = fromChannels.getAlpha(); 

        // PROVIDED OUTPUT: preserve these labels, order, and spacing.
        System.out.println("Packed input " + packedRgb + " -> RGB " + packedRed + ", " + packedGreen + ", " + packedBlue + "; alpha " + packedAlpha);
        System.out.println("Direct channels " + red + ", " + green + ", " + blue + " -> RGB " + directRed + ", " + directGreen + ", " + directBlue + "; alpha " + directAlpha);
        input.close();
    }
}

//alpha is opaque bc if none provided defaults to opaque
//when packing skips all the gritty math of multiplying having to individually move each rgb value to the left/right 8 places to convert. 
//To call it on a packed RGB you need to understand how packing works to correctly call it, or else the two values will not equal, it also hides the rounding aspect