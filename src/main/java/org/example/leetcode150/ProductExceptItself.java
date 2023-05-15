package org.example.leetcode150;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/product-of-array-except-self/description/
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductExceptItself {

    public static void main(String[] args) {
        int[] productArray = productExceptItself(new int[]{1,2,3,4});
        System.out.println("Product Array " + Arrays.toString(productArray));

        productArray = productExceptItself(new int[]{-1, 1, 0, -3, 3});
        System.out.println("Product Array " + Arrays.toString(productArray));
    }


    static int[] productExceptItself(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        res[0] = 1;
        for(int i=1; i<N; i++) res[i] =  nums[i-1]* res[i-1];

        int post = nums[N-1];
        for(int i= N-2; i>=0; i--) {
            res[i] *= post;
            post = nums[i] * post;
        }
        return res;
    }
}
