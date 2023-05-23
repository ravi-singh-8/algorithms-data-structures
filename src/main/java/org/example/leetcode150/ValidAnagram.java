package org.example.leetcode150;

/**
 * https://leetcode.com/problems/valid-anagram/
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 */
public class ValidAnagram {

    public static void main(String[] args) {
        boolean isAnagram = isAnagram("anagram", "nagaram");
        System.out.println("isAnagram :" + isAnagram);
    }

    public static boolean isAnagram(String s, String t) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(char ch: s.toCharArray()) freq1[ch - 'a']++;
        for(char ch: t.toCharArray()) freq2[ch - 'a']++;

        for(int i=0; i<26; i++){
            if(freq1[i] != freq2[i]) return false;
        }
        return true;
    }
}
