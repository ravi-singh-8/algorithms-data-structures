package org.example.leetcode150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *  Example 1:
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Example 2:
 * Input: nums = [1], k = 1
 * Output: [1]
 */
public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {4,-1,1,-1,2,2,3};
        int[] topK = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(topK));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        //Get frequencies
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) map.put(num, map.getOrDefault(num, 0) + 1);

        //Create PriorityQueue
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(k, Comparator.comparingInt(Map.Entry::getValue));
        for(var entry: map.entrySet()){
            if(q.size() < k) {
                q.offer(entry);
            } else {
                if(q.peek().getValue() < entry.getValue()){
                    if(q.size() == k) q.poll();
                    q.offer(entry);
                }
            }
        }

        //pop TopK elements
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty() && k-->0) {
            list.add(q.poll().getKey());
        }
        //Convert list to integer
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
