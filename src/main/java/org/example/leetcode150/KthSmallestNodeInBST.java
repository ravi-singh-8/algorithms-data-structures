package org.example.leetcode150;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 * A Simple solution would be to do inorder traversal and collect all elements in list then print kth element by index
 * below solution is doesn't maintain a list but keeps track of number of nodes visited. once reach k, stop recursion and return root element
 */
public class KthSmallestNodeInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int nodeVal = kthSmallest(root, 3);
        System.out.println("3rd Smallest Node:" + nodeVal);
    }


    static class IntWrapper {
        int val;
        IntWrapper(int val) {
            this.val = val;
        }
    }


    public static int kthSmallest(TreeNode root, int k) {
        IntWrapper ans = new IntWrapper(-1);
        IntWrapper count = new IntWrapper(0);
        dfs(root, k, count, ans);
        return ans.val;
    }


    static void dfs(TreeNode root, int k, IntWrapper count, IntWrapper ans) {
        if(root == null) return;

        dfs(root.left, k, count, ans);
        count.val += 1;
        if(count.val == k) {
            ans.val = root.val;
            return;
        }
        dfs(root.right, k, count, ans);
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
