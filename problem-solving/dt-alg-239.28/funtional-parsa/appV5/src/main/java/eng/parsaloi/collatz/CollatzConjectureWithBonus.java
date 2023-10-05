package eng.parsaloi.collatz;

import java.util.stream.Stream;

public class CollatzConjectureWithBonus {

	public static int findLongestSequence(int max) {
		return Stream.iterate(max, x -> x % 2 == 0 ? x / 2 : 3 * x + 1)
			.limit(max)
			.map(n -> (int) Stream.iterate(n, x -> x % 2 == 0 ? x / 2 : 3 * x + 1).count())
			.max(Integer::compareTo)
			.orElse(0);
	}

	public static void main(String[] args) {
		int max = 15;
		int longestSequenceLength = findLongestSequence(max);

		System.out.println("The longest sequence for n <= " + max + " has length " + longestSequenceLength);
	}
}
