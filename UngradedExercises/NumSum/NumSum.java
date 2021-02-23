import java.util.Scanner;

public class NumSum {

	public static void main(String[] args) {

		System.out.print("Enter an integer: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();

		int power = digits(n)-1;

		if (power < 1){
			System.out.println(n);
			return;
		}

		boolean firstRound = true;
		
		while (power != 0){
			int powerOfTen = power(10, power);
			int main = n / powerOfTen;
			main = main * powerOfTen;
			if (main != 0){
				if (firstRound)
					System.out.print(main);
				else 
					System.out.print(" + " + main);
			}
			n = n - main;
			power--;
			firstRound = false;
		}
		
		if (n != 0)
			System.out.println(" + " + n);
		else
			System.out.println("\n");
		}

	public static int digits(int num){
		int count = 0;
		while (num != 0){
			num /= 10;
			count++;
		}
		return count;
	}

	public static int power(int base, int pow){
		if (pow == 0) return 1;
		for (int i = 1; i < pow; i++){
			base = base * 10;
		}
		return base;
	}
}