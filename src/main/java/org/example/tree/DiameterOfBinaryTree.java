package org.example.tree;

/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = new DiameterOfBinaryTree().diameterOfBinaryTree(root);
        System.out.println("Diameter "+ diameter);

    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int lD = diameterOfBinaryTree(root.left);
        int rD = diameterOfBinaryTree(root.right);

        int lH = height(root.left);
        int rH = height(root.right);
        return Math.max(lH + rH, Math.max(lD, rD));
    }

    int height(TreeNode root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }
    }
}


