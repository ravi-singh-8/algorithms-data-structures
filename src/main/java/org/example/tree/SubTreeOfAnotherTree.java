package org.example.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 * Given the roots of two binary trees root and subRoot,
 * return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.
 * A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
 * The tree could also be considered as a subtree of itself.
 */
public class SubTreeOfAnotherTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        print(root);
        print(subRoot);
        boolean isSubTree = new SubTreeOfAnotherTree().isSubtree(root, subRoot);
        System.out.println("isSubTree(root, subRoot): " + isSubTree);

    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null) return false;

        return isSame(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public boolean isSame(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot==null) return false;

        return root.val == subRoot.val && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
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
