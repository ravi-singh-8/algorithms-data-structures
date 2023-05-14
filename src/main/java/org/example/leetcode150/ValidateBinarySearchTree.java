package org.example.leetcode150;


public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);

        root.left = new TreeNode(10);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(15);

        root.right.right = new TreeNode(40);
        root.right.left = new TreeNode(25);

        ValidateBinarySearchTree validation = new ValidateBinarySearchTree();
        boolean isValidBST = validation.isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("IsValdiBST: " + isValidBST);
    }

    boolean isValidBST(TreeNode root, int minVal, int maxVal) {
        if(root== null) return true;
        if(root.val >maxVal || root.val <minVal) return false;

        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
