package org.example.leetcode150;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/daily-temperatures/
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperature {
    public static void main(String[] args) {
        int[] waitDays = nextWarmer(new int[]{73,74,75,71,69,72,76,73});
        System.out.println("Wait Days:" + Arrays.toString(waitDays));
    }

    static record Pair(int val, int index){}
    static int[] nextWarmer(int[] temp) {
        Deque<Pair> stack = new LinkedList<>();
        stack.offerLast(new Pair(temp[0], 0));
        int[] warmer = new int[temp.length];

        for(int i= 1; i<temp.length; i++) {
            while(!stack.isEmpty() && stack.peekLast().val() < temp[i]) {
                Pair prevTemp = stack.pollLast();
                warmer[prevTemp.index()] = i - prevTemp.index();
            }
            stack.offerLast(new Pair(temp[i], i));
        }
        while(!stack.isEmpty()) {
            Pair prevTemp = stack.pollLast();
            warmer[prevTemp.index()] = 0;
        }
        return warmer;
    }
}
