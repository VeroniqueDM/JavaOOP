package WorkingWithAbstraction;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        StringBuilder message = new StringBuilder();

        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            char leftChar = word.charAt(left);
            char rightChar = word.charAt(right);

            char newChar;
            if (leftChar == ' ' || rightChar == ' ') {
                newChar = ' ';
            } else {
                int diff = Math.abs(leftChar - 'a' - (rightChar - 'a'));
                newChar = (char) ('a' + diff);
            }

            message.append(newChar);
            left++;
            right--;
        }

        if (word.length() % 2 == 1) {
            // Add the middle character if the word length is odd
            message.append(word.charAt(left));
        }

        System.out.println(message);
        scanner.close();
    }
}
