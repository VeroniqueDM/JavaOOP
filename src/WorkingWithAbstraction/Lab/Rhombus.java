package WorkingWithAbstraction.Lab;

import java.util.Scanner;

public class Rhombus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        printRhombus(size);
    }

    private static void printRhombus(int size) {
        printTopHalf(size);
        printBottomHalf(size);
    }

    private static void printBottomHalf(int size) {
        for (int starCount = size -1; starCount >0; starCount--) {
            printLine(size, starCount);

        }
    }

    private static void printTopHalf(int size) {
        for (int starCount = 1; starCount <= size; starCount++) {
            printLine(size, starCount);
        }
    }

    private static void printLine(int size, int starCount) {
        for (int j = 0; j < size - starCount; j++) {
            System.out.print(" ");
        }
        for (int i = 0; i < starCount -1; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
