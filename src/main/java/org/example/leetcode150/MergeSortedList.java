package org.example.leetcode150;

/**
 *  * https://leetcode.com/problems/merge-two-sorted-lists/
 *  * You are given the heads of two sorted linked lists list1 and list2.
 *  * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *  * Return the head of the merged linked list.
 */
public class MergeSortedList {

    public static void main(String[] args) {
        Node head1 = getList(new int[]{20, 30, 40, 50});
        Node head2 = getList(new int[]{10, 12, 31, 45, 60, 80});
        Node merged = merge(head1, head2);
        System.out.println("Head1:" + head1);
        System.out.println("Head2:" + head2);
        System.out.println("Merged:" + merged);
    }

    static Node merge(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node ptr = dummy;

        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                ptr.next = head1;
                head1 = head1.next;
            } else {
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;
        }

        if(head1 == null) ptr.next = head2;
        else if(head2 == null) ptr.next = head1;
        return dummy.next;
    }

    static class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    static Node getList(int[] arr){
        Node head = new Node(arr[0]);
        Node tail = head;
        for(int i=1; i<arr.length; i++) {
            tail.next = new Node(arr[i]);
            tail = tail.next;
        }
        return head;
    }
}
