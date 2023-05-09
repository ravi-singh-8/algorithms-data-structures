package org.example.strings;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix amongst the input strings.
 *
 * Solution:
 *  1) Sort the String array
 *  2) Create an Empty string
 *  3) For first and last array iterate through each char
 *      2.1 If char matches then aad in string
 *      2.2 if doesn't match break loop
 *  3) return string
 */
public class LargestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = new String[]{"flower","flow","flight"};
        String commonPrefix = findCommonPrefix(strings);
        System.out.println(commonPrefix);
    }

    public static String findCommonPrefix(String[] strings) {
        Arrays.sort(strings);
        char[] str1 = strings[0].toCharArray();
        char[] strN = strings[strings.length - 1].toCharArray();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < str1.length && i < strN.length; i++) {
            if(str1[i] != strN[i]) break;
            sb.append(str1[i]);
        }

        return sb.toString();
    }
}
