package org.example.leetcode150;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contains-duplicate/
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums ){
            if(set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
