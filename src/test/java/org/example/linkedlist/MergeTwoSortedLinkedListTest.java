package org.example.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;


public class MergeTwoSortedLinkedListTest {

    @Test
    @DisplayName("Test Merge 100 times by generating two sorted list of random size(capped to 100)")
    void testMerge() {
        for (int i=0; i < 100; i++) {
            int arr1Size = new Random().nextInt(100);
            int arr2Size = new Random().nextInt(100);
            int[] arr1 = new Random().ints(arr1Size, 0, 1_000).toArray();
            int[] arr2 = new Random().ints(arr2Size, 0, 1_000).toArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);

            Node head1= Utility.getLinkedList(arr1);
            Node head2= Utility.getLinkedList(arr2);
            Node mergedList = MergeTwoSortedLinkedList.mergeList(head1, head2);

            //Perform test
            int[] arr = Utility.toArray(mergedList);
            int[] sortedArray = Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed())
                    .sorted()
                    .mapToInt(Integer::intValue)
                    .toArray();
            Assertions.assertArrayEquals(arr, sortedArray);
        }
    }

    @Test
    @DisplayName("Test Merge on null lists")
    void testTwoNullList() {
        Assertions.assertEquals(MergeTwoSortedLinkedList.mergeList(null, null), null);
    }


    @Test
    @DisplayName("Test Merge if second list is null")
    void testFirstListNull() {
        Node head1 = Utility.getLinkedList(new int[] {1, 5, 7, 8});
        Node head = MergeTwoSortedLinkedList.mergeList(head1, null);
        Assertions.assertArrayEquals(Utility.toArray(head1), Utility.toArray(head));
    }

    @Test
    @DisplayName("Test Merge if first list is null")
    void testSecondListNull() {
        Node head2 = Utility.getLinkedList(new int[] {1, 5, 7, 8});
        Node head = MergeTwoSortedLinkedList.mergeList( null, head2);
        Assertions.assertArrayEquals(Utility.toArray(head), Utility.toArray(head));
    }
}
