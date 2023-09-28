package eng.parsaloi.collatz;

import java.util.*;

public class CollatzConjecture {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a positive integer: ");
		int n = scanner.nextInt();

		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}

			System.out.println(n);
		}

		System.out.println("The Collatz sequence for " + n + " eventually reaches 1.");
	}
}
