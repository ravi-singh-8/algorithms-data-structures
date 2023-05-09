package org.example.problemsolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/***
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums,
 * return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSumToZero {
    public static void main(String[] args) {
        ThreeSumToZero sol = new ThreeSumToZero();
        // Find triplets , duplicates not allowed (-1,0,1) same as (0,1,-1)
        List<List<Integer>> result =  sol.threeSumUsingHash(new int[]{-1,0,1,2,-1,-4});
        System.out.println(result);
    }

    public List<List<Integer>> threeSumUsingHash(int[] arr) {
        Set<Triplet> set = new HashSet<>();
        for(int i = 0; i < arr.length - 2; i++) {
            int sum = -arr[i];
            set.addAll(findTriplets(arr, i, sum));
        }

        return set.stream()
                .map(triplet -> Arrays.asList(triplet.a, triplet.b, triplet.c))
                .collect(Collectors.toList());
    }

    private static Set<Triplet> findTriplets(int[] arr, int i, int sum){
        Set<Triplet> triplets = new HashSet<>();
        Set<Integer> iset = new HashSet<>();
        for(int j = i+1; j < arr.length; j++) {

            if(iset.contains(sum - arr[j])) {
                triplets.add(new Triplet(arr[i], sum -arr[j], arr[j]));
            } else {
                iset.add(arr[j]);
            }
        }
        return triplets;
    }
}


class Triplet {

    Map<Integer, Integer> map = new HashMap<>();
    int a;
    int b;
    int c;
    Triplet(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
    }

    @Override
    public int hashCode() {
        return a ^ b ^ c;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Triplet)) {
            return false;
        }

        Triplet other = (Triplet)obj;
        return other.map.get(a) == map.get(a)
                && other.map.get(b)  == map.get(b)
                && other.map.get(c) == map.get(c);
    }
}