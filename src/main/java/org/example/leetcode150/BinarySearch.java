package org.example.leetcode150;

/**
 * https://leetcode.com/problems/binary-search/
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int index = search(new int[]{-1,0,3,5,9,12}, 9);
        System.out.println("Index :" + index);
    }

    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (high + low) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
