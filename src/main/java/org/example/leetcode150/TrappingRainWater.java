package org.example.leetcode150;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] blocks = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
        int waterTrapped =  trap(blocks);
        System.out.println("Trapped Water: " + waterTrapped);
    }


    public static int trap(int[] height) {
        int N = height.length;
        int[] left = new int[N];
        int[] right = new int[N];
        int max = left[0];
        for(int i=1; i<N; i++) {
            max = Math.max(height[i-1], max);
            left[i] = max;
        }

        max = right[N-1];
        for(int i = N-2; i>=0; i--) {
            max = Math.max(max, height[i+1]);
            right[i] = max;
        }

        int allTrap = 0;
        for(int i=1; i<N-1; i++) {
            int trap = Math.min(left[i], right[i]) - height[i];
            if(trap > 0) allTrap += trap;
        }
        return allTrap;
    }
}
