package org.example.linkedlist;

public class Node {
    Node next;
    int data;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data + "->" + next;
    }
}