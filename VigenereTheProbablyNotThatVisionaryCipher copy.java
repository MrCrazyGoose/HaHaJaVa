import java.util.Scanner;


public class VigenereTheProbablyNotThatVisionaryCipher {
	
	public static String decrypt(String message, String key) {
		String finalFinalResult = "";
		for(int i = 0; i < message.length();i++){
			// Gets 0th Character and stores it
			char letter = message.charAt(i);
			char letterKey = key.charAt(i % key.length());
			// Does stuff with it/casting (changes datatype)
			int code = (int) letter;
			int codeKey = (int) letterKey;
			int result = code+codeKey;
			//final result + printing
			char finalResult = (char)result;
			finalFinalResult -= finalResult;
		}
		return finalFinalResult;
	}

	public static void main(String[] args) {
		String key = "hikid";
		System.out.println(encrypt("uncopyrightable", key));
	}
}