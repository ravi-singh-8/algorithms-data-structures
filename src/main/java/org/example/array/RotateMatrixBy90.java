package org.example.array;

import java.util.Arrays;

/**
 * Given a MXN Matrix rotate it by 90
 */
public class RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {1,2,1}
        };

        int[][] rotated = rotate(matrix);
        for(int[] row : rotated) {
            System.out.println(Arrays.toString(row));
        }
    }

    static int[][] rotate(int[][] src) {
        int M = src.length;
        int N = src[0].length;

        //create a new matrix of size NXM
        int[][] dest = new int[N][M];
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                dest[j][M-1-i] = src[i][j];
            }
        }
        return dest;
    }
}
