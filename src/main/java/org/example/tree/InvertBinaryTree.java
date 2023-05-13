package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 * Given the root of a binary tree, invert the tree(Mirror or Tree), and return its root.
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        print(root);

        TreeNode invertedRoot = invertTree(root);
        print(invertedRoot);
    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
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
