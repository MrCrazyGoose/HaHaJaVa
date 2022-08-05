import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;


public class unStego {

    public static void main(String[] args) throws IOException {
        BufferedImage img = ImageIO.read(new File("output.png"));
        OutputStream dataFile = new BufferedOutputStream(new FileOutputStream("unOutput"));
        
        L: for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rgb = img.getRGB(x, y);  // gets a single pixel's RGB values as single int
                Color c = new Color(rgb);  // convert int to Color (which splits up the red, green, blue fields)
                
                // store each color field into seperate local variables
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                
                // extract "secret data" from RGB fields
                int[] data = new int[3];
                data[0] = red   & 0b00000011;
                data[1] = green & 0b00000011;
                data[2] = blue  & 0b00000011;


            }
        }

        dataFile.close();
    }
    
}