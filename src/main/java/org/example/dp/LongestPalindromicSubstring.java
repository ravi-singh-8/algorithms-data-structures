package org.example.dp;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, return the longest palindromic substring in s.
 * Example 1:
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: s = "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String palindrome = findLongestPalindrome("malayalam");
        System.out.println("Palindrome " + palindrome);
    }

    static String findLongestPalindrome(String str) {
        char[] arr = str.toCharArray();
        int N = arr.length;
        boolean[][] isPal = new boolean[N][N];

        //find 1 length palindromes
        for(int i=0; i<N; i++) {
            isPal[i][i] = true;
        }
        //find 2 length pal
        for(int i=0; i<N-1; i++) {
            if(arr[i] == arr[i+1]) isPal[i][i+1] = true;
        }

        //find 3 or more length palindromes
        for(int k= 3; k<=N; k++) {
            for(int i=0; i <= N-k; i++) {
                int j = i + k -1;
                isPal[i][j] = isPal[i+1][j-1] && arr[i] == arr[j];
            }
        }

        //find max len pal
        int si=0; int sj=0; int maxLen = 1;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(isPal[i][j] && (j-i+1 > maxLen)) {
                    maxLen = j-i+1;
                    si = i;
                    sj = j;
                }
            }
        }
        return str.substring(si, sj+1);
    }
}
