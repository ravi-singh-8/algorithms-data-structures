package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/same-tree/
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);

        print(root);
        print(root1);
        boolean isSameTree = new SameTree().isSameTree(root, root1);
        System.out.println("isSameTree(root, root1):" + isSameTree);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(2);
        print(root2);
        isSameTree = new SameTree().isSameTree(root, root2);
        System.out.println("isSameTree(root, root2):" + isSameTree);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
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
