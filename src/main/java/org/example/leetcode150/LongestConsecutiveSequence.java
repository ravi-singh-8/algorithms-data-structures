package org.example.leetcode150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        int maxLength = findLongestConsecutiveSequenceLength(arr);
        System.out.println("Longest Consecutive Sequence Length: " + maxLength);

        arr = new int[]{0,3,7,2,5,8,4,6,0,1};
        maxLength = findLongestConsecutiveSequenceLength(arr);
        System.out.println("Longest Consecutive Sequence Length: " + maxLength);

        arr = new int[]{0,3,7,2,5,8,4,6,0,1};
        maxLength = findLongestConsecutiveSequenceLengthBySort(arr);
        System.out.println("Longest Consecutive Sequence Length: " + maxLength);

        arr = new int[]{100, 4, 200, 1, 3, 2};
        maxLength = findLongestConsecutiveSequenceLength(arr);
        System.out.println("Longest Consecutive Sequence Length: " + maxLength);

    }

    //O(N) Solution
    private static int findLongestConsecutiveSequenceLength(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int e: arr) set.add(e);

        int max = 0;
        for(int e: arr) {
            if(!set.contains(e-1)) {
                //Found start of sequence
                int seqLen = 1;
                while(set.contains(e + 1)){
                   seqLen++;
                   e += 1;
                }
                max = Math.max(seqLen, max);
            }
        }
        return max;
    }

    private static int findLongestConsecutiveSequenceLengthBySort(int[] arr) {
        Arrays.sort(arr);
        int max = 0;
        int seqLen = 1;
        for(int i =0; i< arr.length-1; i++ ) {
            if(arr[i] < arr[i+1]) {
                seqLen++;
            } else {
                max = Math.max(max, seqLen);
                seqLen = 1;
            }
        }
        return Math.max(max, seqLen);
    }
}
