package org.example.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/description/
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 * Example 1:
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        List<List<String>> groups = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(groups);
    }

    static List<List<String>> groupAnagrams(String[] words){
        Map<String, List<String>> groups = new HashMap<>();
        for(String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> anagrams = groups.getOrDefault(sorted, new ArrayList<>());
            anagrams.add(word);
            groups.put(sorted, anagrams);
        }
        return new ArrayList<>(groups.values());
    }
}
