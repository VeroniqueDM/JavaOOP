package ExceptionsAndErrorHandling.EnterNumbers;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integerList = new LinkedList<>();
        int start = 1;
        int end = 101;

        while (integerList.size()<10) {
            try {

                int num = Integer.parseInt(scanner.nextLine());
                if (num<=start|num>end) {
                    throw new NumberNotInRangeException();
                }
                integerList.add(num);
                start=num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (NumberNotInRangeException e) {
                System.out.printf("Your number is not in range %d - 100!%n",start);
            }
        }
        System.out.println(integerList.toString().replace("[","").replace("]",""));
    }
    public static class NumberNotInRangeException extends Exception {
    }
}
