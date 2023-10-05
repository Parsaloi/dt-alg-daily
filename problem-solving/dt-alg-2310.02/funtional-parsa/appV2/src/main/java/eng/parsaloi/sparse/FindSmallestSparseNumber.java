package eng.parsaloi.sparse;

import java.util.stream.Stream;

public class FindSmallestSparseNumber {

	public static int findSmallestSparseNumber(int n) {

		// Convert the input number to binary representation.
		String binaryRepresentation = Integer.toBinaryString(n);

		// Create a Stream of bits in the binary representation.
		// Stream<Integer> bits = Stream.of(binaryRepresentation.chars().map(Character::getNumericValue));
		// The error message indicates that the compiler is unable to infer the type of the stream `bits` in the `Stream.of()` method
		// This is beacuse the `chars()` method of the `String` class returns an `IntStream` which is a stream of primitive `int` values. However, the `of()` method 
		// expects a stream of objects of type `T`, where `T` is a generic type parameter
		//
		// To fix this error, I can either explicitly specify the type of the stream `bits`, or I can use the `boxed()` method to covert the `InStream` to a a stream of `Integer` objects
		//
		// Here we explicitly specify the type of the stream `bits`
		Stream<Integer> bits = Stream.of(binaryRepresentation.chars().map(Character::getNumbericValue).boxed());

		// Find the index of the first pair of adjacent ones in the binary representation.
		int firstPairOfAdjacentOnesIndex = bits.reduce(-1, (previousIndex, currentBit) -> {
			if (previousIndex != -1 && currentBit == 1) {
				return previousIndex;
			}

			return previousIndex == -1 ? currentBit == 1 ? 0 : -1 : -1;
		});

		// if there are no adjacent onces in the binary representation, then the input number is already sparse
		if (firstPairOfAdjacentOnesIndex ==  -1) {
			return n;
		}

		// Flip the bits after th first pair of adjacent onces in the binary representation
		String newBinaryRepresentation = binaryRepresentation.subString(0, firstPairOfAdjacentOnesIndex) +  "0" + binaryRepresentation.subString(firstPairOfAdjacentOnesIndex + 2);

		// Convert the new binary representation to an integer
		return Integer.parseInt(newBinaryRepresentation, 2);
	}

	public static void main(String[] args) {
		int n = 10;

		int smallestSparseNumber = findSmallestSparseNumer(n);

		System.out.println(smallestSparseNumber);
	}
}
