package org.example.leetcode150;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestorInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        print(root);

        System.out.println("LCA(2, 4):" + lca(root, root.left, root.left.right));
        System.out.println("LCA(5, 0):" + lca(root, root.left.right.right, root.left.left));
        System.out.println("LCA(8, 9):" + lca(root, root.right, root.right.right));

    }


    static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) return lca(root.left, p, q);
        if(root.val < p.val && root.val < q.val) return lca(root.right, p, q);
        return root;
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

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

}


