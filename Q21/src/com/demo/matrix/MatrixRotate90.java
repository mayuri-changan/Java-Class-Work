package com.demo.matrix;

import java.util.*;

public class MatrixRotate90 {

    // Method to rotate matrix 90° clockwise
    public static void rotate(int[][] matrix) {

        int n = matrix.length;

        // Step 1: Transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of matrix (n x n):");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        rotate(matrix);

        System.out.println("Rotated Matrix (90° clockwise):");
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
