import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

public class HeHeIHideFile {
	public static void main(String[] args) throws IOException {
		BufferedImage img = ImageIO.read(new File("hehesneaky.png"));
		for (int x = 0; x < 100; x++){
			for (int y = 0; y < 100; y++) {
				int rgb = img.getRGB(x, y);
				Color c = new Color (rgb);
				int red = c.getRed();
				int green = c.getGreen();
				int blue = c.getBlue();
				int red2 = red & 0b11111100;
				int green2 = green & 0b11111100; //change to random numbers from 0
				int blue2 = blue & 0b11111100;
				Color c2 = new Color (red2, green2, blue2);
				int rgb2 = c2.getRGB();
				img.setRGB(x, y, rgb2);
			}	
		}
		ImageIO.write(img, "png", new File("totallynormalresume.png"));
	}
}