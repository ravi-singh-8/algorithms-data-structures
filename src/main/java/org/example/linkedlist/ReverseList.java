package org.example.linkedlist;

public class ReverseList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("List: " + head);
        Node newHead = reverse(head);
        System.out.println("Reverse:" + newHead);

        newHead = reverseRecur(newHead, null);
        System.out.println("Reverse:" + newHead);
    }

    static Node reverse(Node head){
        Node currNode = head;
        Node prevNode = null;
        while(currNode != null) {
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }

    static Node reverseRecur(Node curr, Node prev) {
        if(curr == null) return prev;

        Node nextNode = curr.next;
        curr.next = prev;
        return reverseRecur(nextNode, curr);
    }
}
