package org.example.leetcode150;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/min-stack/
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    Deque<Node> stack;
    public MinStack() {
        stack = new LinkedList<Node>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.offerLast(new Node(val, val));
        } else {
            stack.offerLast(new Node(val, Math.min(val, getMin())));
        }
    }

    public void pop() {
        stack.pollLast();
    }

    public int top() {
        return stack.peekLast().val();
    }

    public int getMin() {
        return stack.peekLast().min();
    }

    static record Node(int val, int min) {}

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println("getMin(): " + stack.getMin());
        stack.pop();
        System.out.println("top(): " + stack.top());
        System.out.println("getMin(): " + stack.getMin());
    }
}