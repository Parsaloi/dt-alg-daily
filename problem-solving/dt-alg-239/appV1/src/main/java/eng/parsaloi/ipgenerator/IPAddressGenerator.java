package eng.parsaloi.ipgenerator;

/**
 * @version 1.0.0 2023-09-17
 *
 * Given a string if digits, generate all possible valid IP address combinations.
 * IP addresses must follow the format A.B.C.D, where A,B,C and D are numbers between 0 and 255.
 * Zero-prefixed numbers, such as 01 and 065, are not allowed, except for 0 itself.
 * For example, given "2542540123", I should return ['254.25.40.123', '254.254.0.123'].
 */

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class IPAddressGenerator {

	public static List<String> generateAllPossibleValidIPAddresses(String digits) {
		List<String> ipAddresses = new ArrayList<>();

		// Check if the string is valid.
		if (digits.length() < 4 || digits.length() > 12) {
			return ipAddresses;
		}

		// Check if the first octet has a least 3 digits.
		/*
		if (digits.substring(0, 3).length() < 3) {
			return ipAddresses;
		}
		*/

		// Try all possible combinations of dots.
		for (int i = 1; i < 4; i++) {
			for (int j = i; j < 5; j++) {
				for (int k = j; k < 6; k++) {
					for (int l = k + 1; l < 7; l++) {
						// String ipAddress = digits.substring(0, i) + "." + digits.substring(i, j) + "." + digits.substring(j, k) + "." + digits.substring(k, l);
						String ipAddress = generateIPAddress(digits, i, j, k, l);

						// Validate the IP address
						if (isValidIPAddress(ipAddress)) {
							ipAddresses.add(ipAddress);
						}
					}
				}
			}
		}

		return ipAddresses;
	}

	private static String generateIPAddress(String digits, int i, int j, int k, int l) {
		return digits.substring(0, i) + "." + digits.substring(i, j) + "." + digits.substring(j, k) + "." + digits.substring(k, l);
	}

	private static boolean isValidIPAddress(String ipAddress) {
		String[] octets = ipAddress.split("\\.");

		// Check if there are 4 octets.
		if (octets.length != 4) {
			return false;
		}

		// Check if each octet is a valid number between 0 and 255.
		for (String octet : octets) {
			try {
				int octetValue = Integer.parseInt(octet);

				if (octetValue < 0 || octetValue > 255) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}

		// check if the first octet has at least 3 digits.
		/*
		if (octets[0].length() < 3) {
			return false;
		}
		*/

		// Check if the first octet is not 0, unless it is o itself.
		if (octets[0].charAt(0) == '0' && octets[0].length() > 1) {
			return false;
		}

		// Check if the second octet has either 3 or 2 digits but not one digit
		/*
		if (octets[1].length() != 3 && octets[1].length() != 2) {
			return false;
		}
		*/

		return true;
	}

	// Basic unit test
	public static void main(String[] args) {
		// Test code goes here...
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter a string of digits: ");
		String digits = scanner.nextLine();

		List<String> ipAddresses = IPAddressGenerator.generateAllPossibleValidIPAddresses(digits);

		System.out.println("All possible valid IP addresses for the given string of digits are: ");
		for (String ipAddress : ipAddresses) {
			System.out.println(ipAddress);
		}
	}
}
