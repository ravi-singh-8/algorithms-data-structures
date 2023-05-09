package org.example.linkedlist;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * <h2>Merge two sorted linked lists consisting of N and M nodes respectively.
 *
 * <p>The task is to merge both of the lists (in place) and return the head of the merged list. <br /><br />
 * <p> <b>Examples:</b> <br />
 *
 * Input: a: 5->10->15, b: 2->3->20 <br />
 * Output: 2->3->5->10->15->20 <br /> <br />
 *
 * Input: a: 1->1, b: 2->4 <br />
 * Output: 1->1->2->4 <br />
 *
 */
public class MergeTwoSortedLinkedList {

    public static void main(String[] args) {
        Node head1 = getLinkedList(new int[]{2, 6, 8, 10, 14, 18});
        System.out.println("List1: " + head1);

        Node head2 = getLinkedList(new int[]{1, 4, 5, 9, 11, 50, 60});
        System.out.println("List2: " + head2);

        Node head = mergeList(head1, head2);
        System.out.println("Merged List:" + head);

    }

    public static Node mergeList(Node head1, Node head2) {
        Node ptr = new Node(-1);
        Node newHead = ptr;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                ptr.next = head1;
                head1 = head1.next;
            } else {
                ptr.next = head2;
                head2 = head2.next;
            }
            ptr = ptr.next;
        }
        if (head1 == null) ptr.next = head2;
        else if (head2 == null) ptr.next = head1;

        return newHead.next;
    }

    static Node getLinkedList(int[] arr) {
        if (arr.length == 0) return null;
        Node head = null;
        Node tail = null;
        for (int element : arr) {
            tail = addNode(tail, element);
            if(head == null) {
                head = tail;
            }
        }
        return head;
    }

    static Node addNode(Node tail, int data) {
        Node newNode = new Node(data);
        if (tail == null) return newNode;

        tail.next = newNode;
        return newNode;
    }
}
