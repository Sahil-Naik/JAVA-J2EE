/*12. Matrix Operations:
	Perform matrix operations like addition, multiplication, or transpose.*/


// Dummy Input
/*Enter number of rows and columns for Matrix A: 2 3
Enter Matrix A:
1 2 3
4 5 6

Enter number of rows and columns for Matrix B: 2 3
Enter Matrix B:
7 8 9
10 11 12*/

package sunday.practice;

import java.util.Scanner;

public class MatrixOperations {

    // Function to add two matrices
    public static int[][] addMatrices(int[][] A, int[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Function to multiply two matrices
    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length, colsA = A[0].length;
        int rowsB = B.length, colsB = B[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Matrix multiplication not possible! Columns of A must match rows of B.");
        }

        int[][] result = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }

    // Function to find the transpose of a matrix
    public static int[][] transposeMatrix(int[][] A) {
        int rows = A.length, cols = A[0].length;
        int[][] result = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }

    // Function to print a matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for matrices
        System.out.print("Enter number of rows and columns for Matrix A: ");
        int rowsA = sc.nextInt();
        int colsA = sc.nextInt();
        int[][] A = new int[rowsA][colsA];

        System.out.println("Enter Matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter number of rows and columns for Matrix B: ");
        int rowsB = sc.nextInt();
        int colsB = sc.nextInt();
        int[][] B = new int[rowsB][colsB];

        System.out.println("Enter Matrix B:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        // Matrix Addition (only if dimensions match)
        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("\nMatrix Addition:");
            printMatrix(addMatrices(A, B));
        } else {
            System.out.println("\nMatrix addition not possible (different dimensions)!");
        }

        // Matrix Multiplication (only if colsA == rowsB)
        if (colsA == rowsB) {
            System.out.println("\nMatrix Multiplication:");
            printMatrix(multiplyMatrices(A, B));
        } else {
            System.out.println("\nMatrix multiplication not possible (columns of A must match rows of B)!");
        }

        // Matrix Transpose
        System.out.println("\nTranspose of Matrix A:");
        printMatrix(transposeMatrix(A));

        System.out.println("\nTranspose of Matrix B:");
        printMatrix(transposeMatrix(B));

        sc.close();
    }
}
