package ExceptionsAndErrorHandling.NumberInRange;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] range = scanner.nextLine().split("\\s+");
        int minValue = Integer.parseInt(range[0]);
        int maxValue = Integer.parseInt(range[1]);
        System.out.printf("Range: [%d...%d]%n", minValue, maxValue);

        int validNumber = readValidNumber(scanner, minValue, maxValue);
        System.out.printf("Valid number: " + validNumber);

    }

    private static int readValidNumber(Scanner scanner, int minValue, int maxValue) {
        for (; ; ) {
            String input = scanner.nextLine();
            try {
                int validNumber = Integer.parseInt(input);
                if (validNumber >= minValue && validNumber <= maxValue) {
                    return validNumber;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Invalid number: " + input);
        }
    }
}
