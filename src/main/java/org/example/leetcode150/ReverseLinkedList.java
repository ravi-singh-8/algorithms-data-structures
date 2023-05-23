package org.example.leetcode150;

/**
 Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
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

    public static void main(String[] args) {
        Node head = getList(new int[]{1,2,3,4,5,6});
        System.out.println("List:" + head);
        Node rHead = reverse(head);
        System.out.println("Reverse List:" + rHead);
    }

    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
