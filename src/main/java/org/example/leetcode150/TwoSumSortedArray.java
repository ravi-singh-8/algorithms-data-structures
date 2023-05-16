package org.example.leetcode150;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int target = 9;
        int[] indices = twoSum(arr, target);
        System.out.println(Arrays.toString(indices));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int N = numbers.length;
        int low = 0;
        int high = N-1;
        while(low < high) {
            int sum = numbers[low] + numbers[high];
            if(sum == target) return new int[]{low+1, high+1};
            else if(sum < target) low++;
            else high--;
        }
        //Shouldn't reach here as there would be at least one solution
        return new int[]{-1,-1};
    }
}
