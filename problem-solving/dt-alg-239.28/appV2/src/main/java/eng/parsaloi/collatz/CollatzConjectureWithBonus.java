package eng.parsaloi.collatz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CollatzConjectureWithBonus {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a positive integer: ");
		int n = scanner.nextInt();

		Map<Integer, Integer> sequenceLengths = new HashMap<>();

		int longestSequenceLength = 1;
		int inputWithLongestSequence = 1;

		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}

			System.out.println(n);

			sequenceLengths.put(n, sequenceLengths.getOrDefault(n, 0) + 1);

			if (sequenceLengths.get(n) > longestSequenceLength) {
				longestSequenceLength = sequenceLengths.get(n);
				inputWithLongestSequence = n;
			}
		}

		System.out.println("The Collatz sequence for " + n + " eventually reaches 1");
		System.out.println("The longest Collatz sequence for an input <= 1000000 is " + longestSequenceLength + " steps long, starting with the input " + inputWithLongestSequence + ".");
		System.out.println("The input number that produces the longest Collatz sequence is " + inputWithLongestSequence + ".");
	}
}
