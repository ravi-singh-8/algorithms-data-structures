package org.example.algorithms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Huffman coding is a lossless data compression algorithm.
 * The idea is to assign variable-length codes to input characters, lengths of the assigned codes are based on the frequencies of corresponding characters.
 * The variable-length codes assigned to input characters are Prefix Codes,
 * means the codes (bit sequences) are assigned in such a way that the code assigned to one character is not the prefix of code assigned to any other character.
 * This is how Huffman Coding makes sure that there is no ambiguity when decoding the generated bitstream.
 */
public class HuffmanCoding {
    static Map<Character, List<Character>> codes = new HashMap<>();
    public static void main(String[] args) {
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        Node huffmanNode = buildHuffmanTree(charArray, charfreq);
        huffmanCodes(huffmanNode, new LinkedList<Character>());
        System.out.println(codes);
    }

    static void huffmanCodes(Node root, LinkedList<Character> code) {
        if(root.left == null && root.right == null) {
            codes.put(root.ch, new ArrayList<>(code));
            return;
        }
        code.addLast('0');
        huffmanCodes(root.left, code);
        code.pollLast();
        code.addLast('1');
        huffmanCodes(root.right, code);
    }

    static Node buildHuffmanTree(char[] str, int[] freq) {
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(Node::getFreq));
        for(int i=0; i<str.length; i++) {
            q.offer(new Node(str[i], freq[i]));
        }
        while(q.size() > 1) {
            Node n1 = q.poll();
            Node n2 = q.poll();
            Node newNode = new Node('/', n1.getFreq() + n2.getFreq());
            newNode.left = n1;
            newNode.right = n2;
            q.offer(newNode);
        }
        return q.peek();
    }

    static class Node {
        char ch;
        int freq;
        Node left;
        Node right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        int getFreq() {
            return freq;
        }
    }
}
