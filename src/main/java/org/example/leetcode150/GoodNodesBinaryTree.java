package org.example.leetcode150;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/
 * Given a binary tree root, a node X in the tree is named good if in the path from root to X there are no nodes with a value greater than X.
 * Return the number of good nodes in the binary tree.
 */
public class GoodNodesBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);
        System.out.println("GoodNodes: " + goodNodes(root));
    }
    public static int goodNodes(TreeNode root) {
        int count = goodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    private static int goodNodes(TreeNode root, int max){
        if(root == null) return 0;

        if(root.val >= max) {
            max = root.val;
            return 1 + goodNodes(root.left, max) + goodNodes(root.right, max);
        }
        return goodNodes(root.left, max) + goodNodes(root.right, max);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    private static void print(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) System.out.print("null");
            else {
                System.out.print(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            System.out.print("\t");
        }
        System.out.println();
    }
}
