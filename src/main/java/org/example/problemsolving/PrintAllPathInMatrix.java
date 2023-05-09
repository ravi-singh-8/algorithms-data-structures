package org.example.problemsolving;

import java.util.ArrayList;
import java.util.List;

/***
 * Get all paths from top to bottom in a MXN Matrix
 * for e.g
 * 1,2,3
 * 4,5,6
 * All paths are [[1,4], [1,5], [1,6], [2,4], [2,5], [2,6]]
 * Algorithm
 * 1) if row is last then return a list of path for last row e.g [[4], [5], [6]]
 * 2) Else
 *      2.1) Call get All Path for row+1
 *      2.2) Create a new List<List<Integer> allPaths to store result
 *      2.3) for each element at current row
 *          2.3.1) for each path in the list from 2.1
 *              2.3.1.1) Create new List<Integer> newPath
 *              2.3.1.2) Add matrix element in newPath
 *              2.3.1.2) Add All elements of path from step 2.3.1
 *              2.3.1.3) Add newPath in allPaths
 *      2.4) return allPaths
 ***/

public class PrintAllPathInMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3},
                {4,5},
                {7,8,9}
        };
        List<List<Integer>> paths = getAllPath(matrix, 0);
        System.out.println(paths);
    }


    static List<List<Integer>> getAllPath(int[][] matrix, int row){
        if(row == matrix.length - 1) {
            List<List<Integer>> list = new ArrayList<>();
            for(int j=0; j<matrix[row].length; j++) {
                list.add(new ArrayList<>(List.of(matrix[row][j])));
            }
            return list;
        } else {
            List<List<Integer>> allPaths = new ArrayList<>();
            List<List<Integer>> paths = getAllPath(matrix, row+1);

            for(int j=0; j <matrix[row].length; j++) {
                for(List<Integer> path: paths) {
                    List<Integer> newPath = new ArrayList<>();
                    newPath.add(matrix[row][j]);
                    newPath.addAll(path);
                    allPaths.add(newPath);
                }
            }
            return allPaths;
        }
    }
}
