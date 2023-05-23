package org.example.leetcode150;

import java.util.Stack;

/***
 * https://leetcode.com/problems/valid-parentheses/
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 * Example 2:
 *
 * Input: s = "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: s = "(]"
 * Output: false
 */
public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("({}[])"));
        System.out.println(isValid("({[])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if(stack.empty()){
                return false;
            } else {
                char open = stack.pop();
                if( !isMatching(open, ch)) return false;
            }
        }
        if(stack.empty()) return true;
        return false;
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}
