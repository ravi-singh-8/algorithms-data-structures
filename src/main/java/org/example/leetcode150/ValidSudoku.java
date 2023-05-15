package org.example.leetcode150;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/***
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        boolean valid = new ValidSudoku().isValidSudoku(new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        });
        System.out.println("Is valid Sudoku:"+ valid);
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Character, Set<String>> map = new HashMap<>();
        int N = board.length;
        for(int i=0; i<N; i++){
            for(int j=0;j<N;j++) {
                char ch = board[i][j];
                if(ch == '.') continue;
                String row = "R"+ i;
                String col =  "C" + j;
                String box = String.format("B%d%d", i/3, j/3);
                Set<String> place = map.getOrDefault(board[i][j], new HashSet<String>());

                if(place.contains(row) || place.contains(col) || place.contains(box)) return false;
                place.addAll(Set.of(row, col, box));
                map.put(board[i][j], place);
            }
        }
        return true;
    }
}
