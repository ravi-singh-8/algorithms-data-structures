package org.example.tree;

import java.util.StringJoiner;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a
 * height-balanced binary search tree.
 */

class SortedListToBST {
    public static void main(String[] args) {
        SortedListToBST listToBST = new SortedListToBST();

        //Create LinkedList and pass to method
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);
        System.out.println(head);

        TreeNode root = listToBST.sortedListToBST(head);
        System.out.println(root);
    }


    public TreeNode sortedListToBST(ListNode head) {
        TreeNode root = findRoot(head);
        return root;
    }

    TreeNode findRoot(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode lEnd = findMiddle(head);
        ListNode mid = lEnd.next;
        ListNode rList = lEnd.next.next;
        lEnd.next = null;
        ListNode lList = head;

        TreeNode root = new TreeNode(mid.val);
        root.left = findRoot(lList);
        root.right = findRoot(rList);
        return root;

    }

    ListNode findMiddle(ListNode head) {
        ListNode ptr1 = new ListNode();
        ptr1.next = head;
        ListNode ptr2 = head;
        while(ptr2 != null && ptr2.next != null) {
            ptr2 = ptr2.next.next;
            ptr1 = ptr1.next;
        }
        return ptr1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return  val + "->" + next;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    @Override
    public String toString() {
        StringJoiner joiner = new StringJoiner("," , "[", "]");
        joiner.add(String.valueOf(left));
        joiner.add(String.valueOf(val));
        joiner.add(String.valueOf(right));
        return joiner.toString();
    }
}
