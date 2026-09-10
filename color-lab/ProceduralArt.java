import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ProceduralArt {
    public static void main(String[] args) throws IOException {
        // PROVIDED: image setup. The image is 720 pixels wide and 460 high.
        BufferedImage image = new BufferedImage(720, 460, BufferedImage.TYPE_INT_ARGB);
        Graphics2D canvas = image.createGraphics();
        canvas.setColor(new Color(24, 31, 58));
        canvas.fillRect(0, 0, 720, 460);

        // EDIT: a constrained warm palette and a shared skyline baseline.
        int warmGreen = 110 + (int) (Math.random() * 71); // 110..180
        Color base = new Color(230, warmGreen, 75);
        Color accent = base.brighter();
        Color shade = base.darker();
        int baseline = 400;

        // EDITABLE BLOCK 1: positive width/height, with its bottom on baseline.
        int width1 = 60 + (int) (Math.random() * 61); // 60..120
        int height1 = 100 + (int) (Math.random() * 181); // 100..280
        canvas.setColor(base);
        canvas.fillRect(40, baseline - height1, width1, height1);

        // EDITABLE BLOCK 2: same rules, different generated dimensions.
        int width2 = 60 + (int) (Math.random() * 61);
        int height2 = 100 + (int) (Math.random() * 181);
        canvas.setColor(accent);
        canvas.fillRect(210, baseline - height2, width2, height2);

        // EDITABLE BLOCK 3.
        int width3 = 60 + (int) (Math.random() * 61);
        int height3 = 100 + (int) (Math.random() * 181);
        canvas.setColor(shade);
        canvas.fillRect(380, baseline - height3, width3, height3);

        // EDITABLE BLOCK 4.
        int width4 = 60 + (int) (Math.random() * 61);
        int height4 = 100 + (int) (Math.random() * 181);
        canvas.setColor(base);
        canvas.fillRect(550, baseline - height4, width4, height4);

        // EDIT: common ground joins the buildings into one composition.
        canvas.setColor(new Color(13, 19, 37));
        canvas.fillRect(0, baseline, 720, 60);

        // PROVIDED: saving. Each run replaces art.png; copy favorites first.
        canvas.dispose();
        File output = new File("art.png");
        ImageIO.write(image, "png", output);
        System.out.println("Saved " + output.getAbsolutePath());
        System.out.println("Green=" + warmGreen + "; widths=" + width1 + "," + width2 + "," + width3 + "," + width4);
        System.out.println("Heights=" + height1 + "," + height2 + "," + height3 + "," + height4);
    }
}