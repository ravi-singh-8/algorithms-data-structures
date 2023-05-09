package org.example.linkedlist;

/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <h2>Given a linked list and an integer N, the task is to delete the Nth node from the end of the given linked list.
 * <p>
 * <b>Examples:</b><br/>
 *
 * Input: 2 -> 3 -> 1 -> 7 -> NULL, N = 1 <br/>
 * Output: The created linked list is: 2 3 1 7  <br/>
 * The linked list after deletion is: 2 3 1 <br />
 *
 * <p>
 * Input: 1 -> 2 -> 3 -> 4 -> NULL, N = 4 <br/>
 * Output: The created linked list is: 1 2 3 4 <br />
 * The linked list after deletion is: 2 3 4 <br />
 */

/***
 * Algorithm:
 * Create Two Pointers
 * 1) One pointer ptr1 will point to head
 * 2) Another pointer will point to a dummny node which is pointing to the head of list
 * 3) increment ptr1 to N Times
 * 5) At this stage start incrementing both pointers(ptr1 and ptr2) till ptr1 reaches past tail(null)
 * 6) Now ptr2 is pointing to just before the node which we have to delete
 * 7) skip the next node by making ptr2.next to the ptr2.next.next
 * 8) return head by dummyNode.next
 */
public class DeleteNthNodeFromEnd {
    public static void main(String[] args) {
        Node head = Utility.getLinkedList(new int[]{2, 3, 1, 7});
        Node  newHead = deleteNth(head, 1);
        Utility.printList(newHead);

        Node head2 = Utility.getLinkedList(new int[]{2, 3, 1, 7});
        newHead = deleteNth(head2, 4);
        Utility.printList(newHead);
    }

    private static Node deleteNth(Node head, int N) {
        Node temp = new Node(-1);
        temp.next = head;
        Node ptr1 = head;
        Node ptr2 = temp;

        for(; N > 0; N--) ptr1 = ptr1.next;
        while(ptr1 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr2.next.next;
        return temp.next;
    }
}
