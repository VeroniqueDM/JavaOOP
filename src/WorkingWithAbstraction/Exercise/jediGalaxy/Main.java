package WorkingWithAbstraction.Exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(rows, cols, matrix);

        String command = scanner.nextLine();
        long sum = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] heroCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int rowEvil = evilCoordinates[0];
            int colEvil = evilCoordinates[1];

            evilPath(matrix, rowEvil, colEvil);

            int heroRow = heroCoordinates[0];
            int heroCol = heroCoordinates[1];

            sum = getSum(matrix, sum, heroRow, heroCol);

            command = scanner.nextLine();
        }
        System.out.println(sum);
    }

    private static void evilPath(int[][] matrix, int xE, int yE) {
        while (xE >= 0 && yE >= 0) {
            if (xE < matrix.length && yE < matrix[0].length) {
                matrix[xE][yE] = 0;
            }
            xE--;
            yE--;
        }
    }

    private static long getSum(int[][] matrix, long sum, int xI, int yI) {
        while (xI >= 0 && yI < matrix[1].length) {
            if (xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
                sum += matrix[xI][yI];
            }
            yI++;
            xI--;
        }
        return sum;
    }

    private static void fillMatrix(int rows, int cols, int[][] matrix) {
        int value = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = value++;
            }
        }
    }
}
