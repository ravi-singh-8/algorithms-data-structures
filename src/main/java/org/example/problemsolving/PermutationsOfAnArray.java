package org.example.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/permutations/
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * Example 2:
 *
 * Input: nums = [0,1]
 * Output: [[0,1],[1,0]]
 * Example 3:
 *
 * Input: nums = [1]
 * Output: [[1]]
 */
public class PermutationsOfAnArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        PermutationsOfAnArray permutations = new PermutationsOfAnArray();
        List<List<Integer>> permutes = permutations.findPermutations(nums);
        System.out.println(permutes);
    }

    public List<List<Integer>> findPermutations(int[] nums) {
        List<List<Integer>> permutes =  permutations(nums, 0);
        return permutes;
    }


    private List<List<Integer>> permutations(int[] nums, int i) {
        //Handle if there is only 1 element
        if(i == nums.length - 1 ) {
            List<Integer> permute = new ArrayList<>(Arrays.asList(nums[i]));
            List<List<Integer>> permutes = new ArrayList<>(Arrays.asList(permute));
            return permutes;
        }


        //get permute for including ith element if we already have permutations till (i+1)th index
        List<List<Integer>> permutes = permutations(nums, i + 1);
        List<List<Integer>> allPermutes = new ArrayList<>();

        for(List<Integer> permute: permutes) {
            for(int j=0; j <= permute.size(); j++) {
                List<Integer> newPermute = new ArrayList<>();
                newPermute.addAll(permute);
                newPermute.add(j, nums[i]);
                allPermutes.add(newPermute);
            }
        }
        return allPermutes;
    }





}
