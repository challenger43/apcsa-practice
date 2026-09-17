
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class BinaryDisplay {
    public static void main(String[] args) throws IOException {
        // PROVIDED INPUT: run, click the Terminal, type an integer, and press Enter.
        // Use whole numbers within Java's int range; text/decimal handling is not
        // today's task.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int clockValue = input.nextInt();
        System.out.println("You entered: " + clockValue);
        Color onEvenColor = new Color(255, 180, 50);
        Color offEvenColor = new Color(96, 51, 255);
        Color onOddColor = new Color(214, 83, 255);
        Color offOddColor = new Color(65, 75, 95);

        // PROVIDED IMAGE SETUP: creates a fresh image on every run.
        BufferedImage image = new BufferedImage(720, 220, BufferedImage.TYPE_INT_ARGB);
        Graphics2D canvas = image.createGraphics();
        canvas.setColor(new Color(245, 245, 245));
        canvas.fillRect(0, 0, 720, 220);
        canvas.setFont(new Font("SansSerif", Font.PLAIN, 20));
        canvas.setColor(Color.BLACK);
        if ((clockValue <= 63) && (clockValue >= 0)) {
            int remaining = clockValue;
            int bit1 = remaining % 2;
            remaining /= 2;
            int bit2 = remaining % 2;
            remaining /= 2;
            int bit4 = remaining % 2;
            remaining /= 2;
            int bit8 = remaining % 2;
            remaining /= 2;
            int bit16 = remaining % 2;
            remaining /= 2;
            int bit32 = remaining % 2;
            String bits = "" + bit32 + bit16 + bit8 + bit4 + bit2 + bit1;
            canvas.drawString("Value: " + clockValue, 30, 35);
            System.out.println(clockValue + " -> " + bits);
            // PROVIDED LABELS: the display reads highest place value first.
            canvas.drawString("32", 30, 65);
            canvas.drawString("16", 145, 65);
            canvas.drawString("8", 260, 65);
            canvas.drawString("4", 375, 65);
            canvas.drawString("2", 490, 65);
            canvas.drawString("1", 605, 65);
            String reversedBits = new StringBuilder(bits).reverse().toString();
            boolean ifEven = clockValue % 2 == 0;
            for (int i = 0; i < bits.length();i++) {
                int originalXValue = 605;// each time - 115
                if (reversedBits.charAt(i) == '1') {
                    canvas.setColor(ifEven ? onEvenColor : onOddColor);
                    canvas.fillRect(originalXValue - 115 * (i), 80, 85, 85);
                } else { 
                    canvas.setColor(ifEven ? offEvenColor: offOddColor);
                    canvas.fillRect(originalXValue - 115 * (i), 80, 85, 85);
                }
            }
        } else {
            System.out.println("Outside six bit range. No binary report for you.");
            canvas.drawString("Follow directions.", 280, 110);
        }

        canvas.dispose();
        File output = new File("binary-display.png");
        ImageIO.write(image, "png", output);
        System.out.println("Saved " + output.getAbsolutePath());
    }
}
