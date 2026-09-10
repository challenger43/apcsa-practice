import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ColorPalette {
    public static void main(String[] args) throws IOException {
        // PROVIDED SETUP: creates an image in memory, not a desktop window.
        BufferedImage image = new BufferedImage(720, 460, BufferedImage.TYPE_INT_ARGB);
        Graphics2D canvas = image.createGraphics();
        canvas.setColor(new Color(245, 245, 245));
        canvas.fillRect(0, 0, 720, 460);
        canvas.setFont(new Font("SansSerif", Font.PLAIN, 18));
        canvas.setColor(Color.BLACK);
        canvas.drawString("Base", 30, 35);
        canvas.drawString("Brighter", 270, 35);
        canvas.drawString("Darker", 510, 35);

        // EDIT HERE: choose a base and use Color methods to make variants.
        Color base = new Color(51, 102, 204);
        Color lighter = base.brighter();
        Color darker = base.darker();

        // fillRect arguments: x, y, width, height, measured in pixels.
        // (0,0) is the top-left. x increases right; y increases downward.
        canvas.setColor(base);
        canvas.fillRect(30, 50, 180, 140);
        canvas.setColor(lighter);
        canvas.fillRect(270, 50, 180, 140);
        canvas.setColor(darker);
        canvas.fillRect(510, 50, 180, 140);

        // PROVIDED BACKGROUNDS for the transparency experiment.
        canvas.setColor(Color.BLACK);
        canvas.drawString("Same color over light and dark backgrounds", 30, 235);
        canvas.setColor(new Color(235, 235, 235));
        canvas.fillRect(30, 255, 300, 170);
        canvas.setColor(new Color(35, 35, 35));
        canvas.fillRect(390, 255, 300, 170);

        // ADD EXPERIMENT HERE: draw the same translucent Color on both panels.
        // Left rectangle: (70, 295, 220, 90).
        // Right rectangle: (430, 295, 220, 90).

        // PROVIDED SAVE: leave this at the end, after all drawing calls.
        canvas.dispose();
        File output = new File("palette.png");
        ImageIO.write(image, "png", output);
        System.out.println("Saved " + output.getAbsolutePath());
    }
}