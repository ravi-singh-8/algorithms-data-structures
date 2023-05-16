package org.example.leetcode150;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/3sum/
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSumToZero {
    public static void main(String[] args) {
        List<List<Integer>> triplets =threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(triplets);
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        Set<Triplet> set = new HashSet<>();

        for(int i = 0; i < arr.length - 2; i++) {
            int sum = -arr[i];

            Set<Integer> iset = new HashSet<>();
            for(int j = i+1; j < arr.length; j++) {
                if(iset.contains(sum - arr[j])) {
                    set.add(new Triplet(arr[i], sum -arr[j], arr[j]));
                } else {
                    iset.add(arr[j]);
                }
            }
        }

        return set.stream()
                .map(triplet -> Arrays.asList(triplet.a, triplet.b, triplet.c))
                .collect(Collectors.toList());

    }

    static class Triplet {
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

}


