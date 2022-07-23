import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class ImageBinaryViewer {

	public static void main(String[] args) throws IOException {

		BufferedImage img = ImageIO.read(new File("troll-face.png"));
		
		for (int row = 0; row < img.getHeight(); row++) {
			for (int col = 0; col < img.getWidth(); col++) {
				System.out.printf("%08X ", img.getRGB(col, row));
			}
			System.out.println();
		}

	}
	
}
