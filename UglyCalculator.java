import java.util.Scanner;

public class UglyCalculator {
	public static void main(String[] args) {
		double prevNum = 1;
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 5; i++){
			double num_a = sc.nextDouble();
			prevNum = num_a*prevNum;
		}



		System.out.printf("%f\n", prevNum);
		
		sc.close();
	}

}
