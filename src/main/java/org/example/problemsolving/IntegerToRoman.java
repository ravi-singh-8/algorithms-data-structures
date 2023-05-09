package org.example.problemsolving;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * <h2>Given an integer, convert it to a roman numeral.
 * <p> Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M. <br />
 * Symbol       Value   <br />
 * (I, 1), (V, 5), (X, 10),(L, 50),(C, 100), (D, 500), (M, 1000)
 */


record Pair(int num, String roman){}

public class IntegerToRoman {

    static final List<Pair> romans = new ArrayList<>(
            List.of (
                    new Pair(1000, "M"), new Pair(900, "CM"), new Pair(500, "D"), new Pair(400, "CD"),
                    new Pair(100, "C"), new Pair(90, "XC"), new Pair(50, "L"),new Pair(40, "XL"), new Pair(10, "X"),
                    new Pair(9, "IX"), new Pair(5, "V"),new Pair(4, "IV"),new Pair(1, "I")
            )
    );


    public static void main(String[] args) {
        int number = 1200;
        String roman = integerToRoman(number);
        System.out.println(roman);
    }


    public static String integerToRoman(int number){
        StringBuilder sb = new StringBuilder();
        for(Pair roman: romans) {
            if(number == 0) break;
            while(number >= roman.num()) {
                sb.append(roman.roman());
                number -= roman.num();
            }
        }
        return sb.toString();
    }
}


