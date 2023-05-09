package org.example.problemsolving;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 * <pre>
 * Given a roman numeral, convert it to an integer.
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 * </pre>
 */


public class RomanToInteger {
    static RomanIntegerMap map = RomanIntegerMap.getInstance();

    public static void main(String[] args) {
        String roman = "MCMXCVIII";
        int val = romanToInteger(roman);
        System.out.println("Integer value of Roman Literal:" + roman + " is: " + val);
    }

    public static int romanToInteger(String roman) {
        char[] arr = roman.toCharArray();
        int val = 0;
        for(int i =0; i< arr.length; i++) {
            int curVal = map.getInteger(arr[i]);

            if(i+1 < roman.length()) {
                int nextVal = map.getInteger(arr[i+1]);
                if(nextVal > curVal) curVal = -curVal;
            }
            val += curVal;
        }
        return val;
    }
}

class RomanIntegerMap {
    private static RomanIntegerMap instance = new RomanIntegerMap();
    private Map<Character, Integer> map = new HashMap<>();

    static RomanIntegerMap getInstance()  {
        return instance;
    }

    int getInteger(char roman) {
        return map.get(roman);
    }

    private RomanIntegerMap(){
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
}
