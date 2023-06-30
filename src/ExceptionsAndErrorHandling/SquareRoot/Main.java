package ExceptionsAndErrorHandling.SquareRoot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            findSquareRoot(scanner);
        } catch (NumberFormatException | NumberIsNegativeException e) {
            System.out.println("Invalid");
        }finally {
            System.out.println("Goodbye");
        }
    }

    private static void findSquareRoot(Scanner scanner) throws NumberIsNegativeException {
        int num = Integer.parseInt(scanner.nextLine());
        if (num<0) {
            throw new NumberIsNegativeException();
        }
        double res = Math.sqrt(num);
        System.out.printf("%.2f%n",res);
    }
     private static class NumberIsNegativeException extends Exception{    }


}

