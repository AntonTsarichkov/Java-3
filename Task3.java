import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = generateRandomMatrix(5, 5, -10, 10); // Приклад матриці 5x5 зі значеннями від -10 до 10
        printMatrix(matrix);

        int z = 5; // Значення Z
        countElementsExceedingZ(matrix, z);

        int sumOfNegatives = sumOfNegativeElements(matrix);
        System.out.println("Сума від'ємних елементів матриці: " + sumOfNegatives);

        int N = 3; // Кількість матриць
        int maxSizeSum = findMaxSizeSum(N, 5, -10, 10); // Генеруємо 5x5 матриці N разів
        System.out.println("Максимальна сума елементів нижче головної діагоналі у " + N + " матрицях: " + maxSizeSum);
    }

    public static int[][] generateRandomMatrix(int rows, int cols, int min, int max) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(max - min + 1) + min;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }

    public static void countElementsExceedingZ(int[][] matrix, int z) {
        int cols = matrix[0].length;
        for (int j = 0; j < cols; j++) {
            int count = 0;
            for (int[] row : matrix) {
                if (row[j] > z) {
                    count++;
                }
            }
            System.out.println("Стовпець " + (j + 1) + ": " + count + " елементів перевищують " + z);
        }
    }

    public static int sumOfNegativeElements(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                if (num < 0) {
                    sum += num;
                }
            }
        }
        return sum;
    }

    public static int sumBelowMainDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }

    public static int findMaxSizeSum(int N, int size, int min, int max) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int[][] matrix = generateRandomMatrix(size, size, min, max);
            int sum = sumBelowMainDiagonal(matrix);
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
