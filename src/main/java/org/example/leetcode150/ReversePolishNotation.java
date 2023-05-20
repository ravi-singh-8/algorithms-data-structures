package org.example.leetcode150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * Note that:
 * The valid operators are '+', '-', '*', and '/'.
 * Each operand may be an integer or another expression.
 * The division between two integers always truncates toward zero.
 * There will not be any division by zero.
 * The input represents a valid arithmetic expression in a reverse polish notation.
 *
 * Example
 * Input: tokens = ["2","1","+","3","*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 */
public class ReversePolishNotation {

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }


    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();

        for (String token : tokens) {
            if (!isOperator(token)) {
                stack.offerLast(Integer.parseInt(token));
            } else {
                int b = stack.pollLast();
                int a = stack.pollLast();
                int val = apply(token, a, b);
                stack.offerLast(val);
            }
        }
        return stack.pollLast();
    }

    static int apply(String op, int a, int b) {
        if ("+".equals(op)) return a + b;
        else if ("-".equals(op)) return a - b;
        else if ("*".equals(op)) return a * b;
        else if ("/".equals(op)) return a / b;

        throw new IllegalArgumentException("op not supported");
    }

    static boolean isOperator(String token) {
        return "+".equals(token)
                || "-".equals(token)
                || "*".equals(token)
                || "/".equals(token);
    }
}

