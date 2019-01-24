package Shockwave;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ShockWave {
    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] matrixSize = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] matrix = new int[matrixSize[0]][matrixSize[1]];

        while (true) {
            String str = reader.readLine();
            if (str.equalsIgnoreCase("Here We Go"))
                break;

            String[] input = str.split("\\s+");

            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            for (int row = x1; row <= x2; row++) {
                for (int col = y1; col <= y2; col++) {
                    try {
                        matrix[row][col] += 1;
                    } catch (Exception e) {
                    }
                }
            }
        }

        printMatrix(matrix);

    }
}
