import java.util.Scanner;

public class RGBer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// System.out.println(rgb);
		int rgb = Integer.parseInt(sc.next(), 16);
		// System.out.printf("%06X\n", rgb << 8);
		System.out.println(String.format("%24s", Integer.toBinaryString(rgb)).replaceAll(" ", "0"));
		//move the red to the back of the train
		int red = rgb >>> 16;
		System.out.println(String.format("%8s", Integer.toBinaryString(red)).replaceAll(" ", "0"));
		//move the  to green the back of the train
		int green = (rgb & 0b000000001111111100000000) >>> 8;
		System.out.println("        " + String.format("%8s", Integer.toBinaryString(green)).replaceAll(" ", "0"));
		//move the blue to the back of the train
		int blue = (rgb & 0b000000000000000011111111);
		System.out.println("                " + String.format("%8s", Integer.toBinaryString(blue)).replaceAll(" ", "0"));
		sc.close();
		//
	   //
	  //
	 //
	}
}
