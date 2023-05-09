package org.example.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;


public class MergeTwoSortedLinkedListTest {

    @TestFactory
    @DisplayName("Test Merge 100 times by generating two sorted list of random size(capped to 100)")
    List<DynamicTest> testMerge() {
        List<DynamicTest> tests = new ArrayList<>();
        for (int i=0; i < 100; i++) {
            final int arr1Size = new Random().nextInt(100);
            final int arr2Size = new Random().nextInt(100);
            int[] arr1 = new Random().ints(arr1Size, 0, 1_000).toArray();
            int[] arr2 = new Random().ints(arr2Size, 0, 1_000).toArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            Node head1= getLinkedList(arr1);
            Node head2= getLinkedList(arr2);
            Node head = MergeTwoSortedLinkedList.mergeList(head1, head2);

            //Perform test
            final int[] arr = toArray(head);
            final int[] sortedArray = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed())
                    .sorted()
                    .mapToInt(Integer::intValue)
                    .toArray();

            DynamicTest test = DynamicTest.dynamicTest(
                    "Test Merge input List1 size:" + arr1Size +"List2 size:" + arr2Size,
                    ()-> {
                        Assertions.assertArrayEquals(arr, sortedArray);
                    });
            tests.add(test);
        }
        return tests;
    }

    @Test
    @DisplayName("Test Merge on null lists")
    void testTwoNullList() {
        Assertions.assertEquals(MergeTwoSortedLinkedList.mergeList(null, null), null);
    }


    @Test
    @DisplayName("Test Merge if second list is null")
    void testFirstListNull() {
        Node head1 = getLinkedList(new int[] {1, 5, 7, 8});
        Node head = MergeTwoSortedLinkedList.mergeList(head1, null);
        Assertions.assertArrayEquals(toArray(head1), toArray(head));
    }

    @Test
    @DisplayName("Test Merge if first list is null")
    void testSecondListNull() {
        Node head2 = getLinkedList(new int[] {1, 5, 7, 8});
        Node head = MergeTwoSortedLinkedList.mergeList( null, head2);
        Assertions.assertArrayEquals(toArray(head), toArray(head));
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

    static int[] toArray(Node head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.data);
            head = head.next;
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
