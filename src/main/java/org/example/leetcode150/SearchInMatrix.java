package org.example.leetcode150;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class SearchInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        boolean found = matrixSearch1(matrix, target);
        System.out.println("Found? "+ found);
    }

    static boolean matrixSearch1(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int low = 0;
        int high = M * N - 1;
        while(low <= high) {
            int mid = (low + high)/2;
            int row = mid / N;
            int col = mid % N;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    //O(M + N)
    static boolean matrixSearch2(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int down = 0;
        int left = N - 1;
        while(down < M && left >=0) {
            if(matrix[down][left] == target) return true;
            else if(matrix[down][left] < target) down++;
            else left--;
        }
        return false;
    }
}
