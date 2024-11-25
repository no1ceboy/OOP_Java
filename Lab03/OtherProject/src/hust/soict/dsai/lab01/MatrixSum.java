import java.util.Scanner;
public class MatrixSum {
        public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the number of rows and columns for the matrices:");
        int rows = keyboard.nextInt();
        int cols = keyboard.nextInt();

        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];

        System.out.println("Enter the elements of A:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = keyboard.nextInt();
            }
        }

        System.out.println("Enter the elements of B:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("B[" + i + "][" + j + "]: ");
                B[i][j] = keyboard.nextInt();
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = A[i][j] + B[i][j];
            }
        }

        System.out.println("The sum of A and B is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sumMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}