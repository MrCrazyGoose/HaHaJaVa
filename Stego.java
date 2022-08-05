import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class Stego {

    private static class EOFException extends Exception {}

    private static final int CHUNKS_PER_BYTE = 4;
    private static int chunkCounter = 0;
    private static int currByte = 0;

    private static int nextChunk(InputStream dataFile) throws EOFException, IOException {
        // need to read next byte if needed
        if (chunkCounter <= 0) {
            currByte = dataFile.read();
            chunkCounter = CHUNKS_PER_BYTE;

            // check for end-of-file (EOF)
            if (currByte < 0)
                throw new EOFException();
        }

        // get chunk from byte
        int data = currByte & 0b00000011;
        currByte = currByte >>> 2;
        chunkCounter--;

        // return chunk
        return data;
    }

    public static void main(String[] args) throws IOException {
        BufferedImage img = ImageIO.read(new File("farm.jpg"));
        InputStream dataFile = new BufferedInputStream(new FileInputStream("secret.txt"));
        
        L: for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                try {
                    int rgb = img.getRGB(x, y);  // gets a single pixel's RGB values as single int
                    Color c = new Color(rgb);  // convert int to Color (which splits up the red, green, blue fields)
                    
                    // store each color field into seperate local variables
                    int red = c.getRed();
                    int green = c.getGreen();
                    int blue = c.getBlue();

                    // read data and modify rgb fields
                    int red2   = (red   & 0b11111100) | nextChunk(dataFile);  // rrrrrr00 | 000000dd == rrrrrrdd
                    int green2 = (green & 0b11111100) | nextChunk(dataFile);
                    int blue2  = (blue  & 0b11111100) | nextChunk(dataFile);

                    Color c2 = new Color(red2, green2, blue2); // package fields togeather using Color
                    int rgb2 = c2.getRGB();  // convert Color to int
                    img.setRGB(x, y, rgb2);  // modify 1 pixel of BufferedImage img
                
                } catch(EOFException ex) {
                    break L;
                }
            }
        }
        dataFile.close();
        ImageIO.write(img, "png", new File("output.png"));
    }
    
}