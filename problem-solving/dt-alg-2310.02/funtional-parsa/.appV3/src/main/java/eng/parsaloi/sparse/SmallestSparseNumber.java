package eng.parsaloi.sparse;

import java.util.stream.Stream;

public class SmallestSparseNumber {

	public static int findSmallestSparseNumber(int n) {

		// Convert the input number to binary representation
		String binaryRepresentation = Integer.toBinaryString(n);

		// Create a Stream of the bits in the binary representation
		Stream<Integer> bits = binaryRepresentation.chars().map(Character::getNumericValue).boxed();

		// Find the index of the first pair of adjacent ones in the binary representation
		int firstPairOfAdjacentOnesIndex = bits.reduce(-1, (previosIndex, currentBit) -> {
			if (previousIndex != -1 && currentBit == 1) {
				return previousIndex;
			}

			return previousIndex == -1 ? currentBit == 1 ? 0 : -1 : -1;
		});

		// If there are no adjacent ones in the binary representation, then the input number is already sparese
		if (firstPairOfAdjacentOnesIndex == -1) {
			return n;
		}

		// Flip the bits after the first pair of adjacent ones in the binary representation
		String newBinaryRepresentation = binaryRepresentation.substring(0, firstPairOfAdjacentOnesIndex) + "0" + binaryRepresentation.substring(firstPairOfAdjacentOnesIndex + 2);

		// Convert the new binary representation to an integer
		return Integer.parseInt(newBinaryRepresentation, 2);
	}

	public static void main(String[] args) {

		int n = 10;

		int smallestSparseNumber = findSmallestSparseNumber(n);

		System.out.println(smallestSparseNumber); // 12
	}
}
