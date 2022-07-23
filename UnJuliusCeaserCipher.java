import java.util.Scanner;

public class UnJuliusCeaserCipher {
	public static void decrypt() {
		// input deivce thing
		Scanner sc = new Scanner(System.in);
		// input define
		String phrase = sc.nextLine();
		for(int i = 0; i < phrase.length();i++){
			// Gets 0th Character and stores it
			char letter = phrase.charAt(i);
			// Does stuff with it/casting (changes datatype)
			int code = (int) letter;
			//moves it
			int result = code +3;
			//final result + printing
			char finalResult = (char)result;
			System.out.print(finalResult);
		}
		sc.close();
	}

	public static void main(String[] args) {
		decrypt();
	}
}
