import java.util.Scanner;

public class UnAndNoneJuliusCeaser {

	public static void encrypt() {
		// input deivce thing
		Scanner sc = new Scanner(System.in);
		// input define
		System.out.println("Enter text to encrypt");
		String phrase = sc.nextLine();
		for(int i = 0; i < phrase.length();i++){
			// Gets 0th Character and stores it
			char letter = phrase.charAt(i);
			// Does stuff with it/casting (changes datatype)
			int code = (int) letter;
			int result = code -14;
			char finalResult = (char)result;
			System.out.print(finalResult);
		}
		sc.close();
	}

	public static void decrypt() {
		// input deivce thing
		Scanner sc = new Scanner(System.in);
		// input define
		System.out.println("Enter text to decrypt");
		String phrase = sc.nextLine();
		for(int i = 0; i < phrase.length();i++){
			// Gets 0th Character and stores it
			char letter = phrase.charAt(i);
			// Does stuff with it/casting (changes datatype)
			int code = (int) letter;
			//moves it
			int result = code +14;
			//final result + printing
			char finalResult = (char)result;
			System.out.print(finalResult);
		}
		sc.close();
	}



	public static void main(String[] args) {
		//original input device
		Scanner chooseType = new Scanner(System.in);
		//original input define
		System.out.println("Select mode: 'un' (decrypt) or 'none' (encrypt)");
		String type = chooseType.nextLine();

		if (type.equals("un")) {
			decrypt();
		}
		else if (type.equals("none")) {
			encrypt();
		}
	}
}
