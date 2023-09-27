package eng.parsaloi.ipgenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class IPAddressGenerator {

    public static List<String> generateAllPossibleValidIPAddresses(String digits) {
        // Check if the string is valid.
        if (digits.length() < 4 || digits.length() > 12) {
            return List.of();
        }

        // Generate all possible combinations of dots.
        return List.of(0, 1, 2, 3)
                .stream()
                .flatMap(i -> List.of(i + 1, i + 2, i + 3).stream())
                .flatMap(j -> List.of(j + 1, j + 2).stream())
                .flatMap(k -> List.of(k + 1).stream())
                .map(l -> digits.substring(0, i) + "." + digits.substring(i, j) + "." + digits.substring(j, k) + "." + digits.substring(k, l))
                .filter(ipAddress -> isValidIPAddress((String) ipAddress))
                .collect(Collectors.toList());
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

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string of digits: ");
        String digits = scanner.nextLine();

        IPAddressGenerator generator = new IPAddressGenerator();

        List<String> ipAddresses = generator.generateAllPossibleValidIPAddresses(digits);

        System.out.println("All possible valid IP addresses for the given string of digits are: ");
        for (String ipAddress : ipAddresses) {
            System.out.println(ipAddress);
        }
    }
}

