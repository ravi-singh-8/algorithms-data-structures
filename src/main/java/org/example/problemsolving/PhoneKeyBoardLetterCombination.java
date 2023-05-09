package org.example.problemsolving;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *  key Map  = { 0:"",1:"",2:"abc", 3:"def", 4:"ghi", 5:"jkl", 6:"mno", 7:"pqrs", 8:"tuv", 9:"wxyz"};
 */

public class PhoneKeyBoardLetterCombination {

    static String[] map = { "","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) {
        PhoneKeyBoardLetterCombination combination = new PhoneKeyBoardLetterCombination();
        List<String> allComb = combination.combinations("234");
        System.out.println("234:" + allComb);

        allComb = combination.combinations("23");
        System.out.println("23:" +allComb);

        allComb = combination.combinations("4");
        System.out.println("4:" +allComb);

        allComb = combination.combinations("");
        System.out.println("" +allComb);
    }

    public List<String> combinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<String>();

        else if(digits.length() == 1) {
            List<String> combinations = new ArrayList();
            for(String  combination: map[Integer.valueOf(digits)].split("")) {
                combinations.add(combination);
            }
            return combinations;
        } else {
            List<String> combinations = combinations(digits.substring(1));
            List<String> allComb = new ArrayList<>();

            String keys = map[Integer.valueOf(digits.substring(0,1))];

            for(char ch : keys.toCharArray()) {
                for(String str: combinations) {
                    String newStr = ch +""+ str;
                    allComb.add(newStr);
                }
            }
            return allComb;
        }
    }
}
