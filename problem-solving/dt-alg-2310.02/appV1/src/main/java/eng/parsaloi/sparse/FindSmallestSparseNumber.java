package eng.parsaloi.sparse;

import java.util.Arrays;

public class FindSmallestSparseNumber {

	public static int findSmallestSparseNumber(int n) {
		
		// Check if N is already sparse
		if (!isSparse(n)) {
			// Find the next sparse greater than or equal to N.
			int nextSparseNumber = n;
			while (!isSparse(nextSparseNumber)) {
				nextSparseNumber++;
			}
			return nextSparseNumber;
		} else {
			return n;
		}
	}

	private static boolean isSparse(int n) {

		// Convert the number to its binary representation
		String binaryRepresentation = Integer.toBinaryString(n);

		// Check if there are any adjacent ones in the binary representation
		for (int i = 0; i < binaryRepresentation.length() -1; i++) {
			if (binaryRepresentation.charAt(i) == '1' && binaryRepresentation.charAt(i + 1) == '1' ) {
				return false;
			}
		}
		return true;
	}

	// Basic unit test
	public static void main(String[] args) {

		int value1 = 21;

		int value2 = 22;

		System.out.println("Concrete example with test value=21:");
		findSmallestSparseNumber(value1);

		System.out.println("Concrete example with test value=22");
		findSmallestSparseNumber(value2);
	}
}
