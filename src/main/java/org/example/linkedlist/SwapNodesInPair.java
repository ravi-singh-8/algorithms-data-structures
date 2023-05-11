package org.example.linkedlist;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class SwapNodesInPair {
    public static void main(String[] args) {
        SwapNodesInPair sol = new SwapNodesInPair();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head);
        ListNode head1 = sol.swapPairs(head);
        System.out.println(head1);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode ptr = dummy;
        while(ptr.next != null && ptr.next.next != null) {
            ListNode a = ptr.next;
            ListNode b = ptr.next.next;

            //Adjust pointer for a
            a.next = a.next.next;
            b.next = a;
            ptr.next = b;

            //Advance ptr
            ptr = ptr.next.next;
        }
        return dummy.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }
}
