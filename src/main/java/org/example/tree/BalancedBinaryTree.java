package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * Given a binary tree, determine if it is height-balanced
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);


        print(root);
        boolean isBalanced = new BalancedBinaryTree().isBalanced(root);
        System.out.println("IsBalanced: " +isBalanced);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        print(root1);
        isBalanced = new BalancedBinaryTree().isBalanced(root1);
        System.out.println("IsBalanced: " + isBalanced);

    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int lH = height(root.left);
        int rH = height(root.right);
        return Math.abs(lH - rH ) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
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
        System.out.print("Tree: ");
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
