package org.example.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/***
 * https://leetcode.com/problems/merge-intervals/
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */

record Pair(int start, int end){}

public class MergeIntervals {
    public static void main(String[] args) {
        MergeIntervals sol = new MergeIntervals();
        int[][] intervals = sol.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        for(int[] interval: intervals) {
            System.out.print(Arrays.toString(interval));
        }

    }

    public int[][] merge(int[][] intervals) {
        int N = intervals.length;
        if(N == 1) return intervals;

        Pair[] pairs = new Pair[N];
        for(int i=0; i<N ;i++) {
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(pairs, Comparator.comparing(Pair::start));

        Stack<Pair> stack = new Stack<Pair>();
        stack.push(pairs[0]);
        for(int i=1; i<N; i++) {
            Pair curr = pairs[i];
            Pair onTop = stack.peek();

            if(onTop.end() >= curr.start()){
                onTop = stack.pop();
                stack.push(new Pair(onTop.start(), Math.max(curr.end(), onTop.end())));
            } else {
                stack.push(curr);
            }
        }

        int M = stack.size();
        int[][] ans = new int[M][2];
        for(int i = M-1; i>=0; i--) {
            Pair p = stack.pop();
            ans[i] = new int[]{p.start(), p.end()};
        }
        return ans;
    }
}
