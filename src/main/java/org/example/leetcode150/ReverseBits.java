package org.example.leetcode150;

public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(-1));

    }

    public static int reverseBits(int n) {
        int res = 0;
        for(int i=0; i<32; i++) {
            int bit = n & (1 << i);
            System.out.println("i: " + i + ", bit:" + bit);
            if(bit > 0) {
                int newInt = bit << (32 - 2*i - 1) ;
                System.out.print("newInt:" + newInt);
                res = res | newInt;
                System.out.println("res:" + res);

            }

        }
        return res;
    }
}
