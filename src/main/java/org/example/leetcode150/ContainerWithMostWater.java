package org.example.leetcode150;

/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        int waterStored = findMaxWater(height);
        System.out.println("Water Stored "+ waterStored);
    }


    //O(N) solution
    static int findMaxWater(int[] height) {
        int N = height.length;
        int low = 0;
        int high = N - 1;
        int max = 0;
        while(low < high) {
            int water = Math.min(height[low], height[high]) * (high - low);
            max = Math.max(water, max);
            if( low < high) low++;
            else high --;
        }
        return max;
    }

    //O(N^2) Solution
    static int findMaxWater2(int[] height) {
        int max = 0;
        int N = height.length;
        for(int i=0; i<N-1; i++) {
            for(int j=i+1; j<N; j++) {
                max = Math.max(max, Math.min(height[i], height[j])* (j-i));
            }
        }
        return max;
    }
}
