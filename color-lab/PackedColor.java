import java.util.Scanner;
//8 bits have 256 possible values because it has 8 places, and each place has 2 potential options (0 or 1) meaning you have 2^8 options or 256. moving left 8 bits means multiplying by 256
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
        int red = (int) (redLevel*255 + 0.5); 
        int green = (int) (greenLevel*255 + 0.5); 
        int blue = (int) (blueLevel*255 + 0.5); 
        int packedRgb = red*65536 + green*256 + blue; 
        int recoveredRed = packedRgb/65536 % 256; // puts it back right 16 steps
        int recoveredGreen = (packedRgb/256) % 256; // moves it right back 8 steps
        int recoveredBlue = packedRgb%256; // doesn't need to move already is at the end
        int largestPackedRgb = 255*65536 + 255*256 + 255; // i didn't know what to do here is it supposed to be a set value?

        // PROVIDED OUTPUT: preserve these labels, order, and spacing.
        System.out.println("Input levels: " + redLevel + ", " + greenLevel + ", " + blueLevel);
        System.out.println("Rounded RGB: " + red + ", " + green + ", " + blue);
        System.out.println("Packed RGB: " + packedRgb);
        System.out.println("Recovered RGB: " + recoveredRed + ", " + recoveredGreen + ", " + recoveredBlue);
        System.out.println("Largest packed RGB: " + largestPackedRgb);
        input.close();
    }
}
//substring prediction: green-blue