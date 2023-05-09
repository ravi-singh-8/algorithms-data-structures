package org.example.linkedlist;

import java.util.StringJoiner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

/**
 * A Utility class for Linked List
 */
public class Utility {

    /**
     * Generate a linked list from the array elements
     *
     * @param arr
     * @return Head of the Linked list
     */
    public static Node getLinkedList(int[] arr) {
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


    /**
     * Append an element in the list
     *
     * @param tail
     * @param data
     * @return Head of the Linked list, if Head is null then new Node is returned as head
     * otherwise new Node with data will be appended in list.
     */
    public static Node addNode(Node tail, int data) {
        Node newNode = new Node(data);
        if (tail == null) return newNode;

        tail.next = newNode;
        return newNode;
    }


    /**
     * check if list has cycles, if not print list
     *
     * @param node
     */
    public static void printList(Node node) {
        if (listHasCycles(node)) {
            System.out.println("List has Cycle");
        } else {
            printList0(node);
        }
    }


    /**
     * Print List
     *
     * @param node
     */
    private static void printList0(Node node) {
        StringJoiner joiner = new StringJoiner(",", "[", "]");
        while (node != null) {
            joiner.add(String.valueOf(node.data));
            node = node.next;
        }
        System.out.println(joiner);
    }


    /**
     * Check if list has cycles
     *
     * @param node
     * @return tru if list has cycle, otherwise false
     */
    public static boolean listHasCycles(Node node) {
        Set<Node> nodes = new HashSet<>();
        while (node != null) {
            if (nodes.contains(node)) return true;
            nodes.add(node);
            node = node.next;
        }
        return false;
    }

    public static int[] toArray(Node head) {
        if (listHasCycles(head)) {
            System.out.println("List has Cycle");
            return new int[]{};
        } else {
            List<Integer> elements = new ArrayList<>();
            while (head != null) {
                elements.add(head.data);
                head = head.next;
            }
            return elements.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
}