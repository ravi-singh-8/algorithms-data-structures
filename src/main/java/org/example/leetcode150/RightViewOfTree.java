package org.example.leetcode150;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/***
 * https://leetcode.com/problems/binary-tree-right-side-view/
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */
public class RightViewOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(6);

        List<Integer> rightViewNodes = new ArrayList<>();
        dfs(root, rightViewNodes, 0);
        System.out.println("RightView: " + rightViewNodes);

        List<Integer> rightViewWithQ = rightSideView(root);
        System.out.println("RightView:" + rightViewWithQ);

    }

    public static void dfs(TreeNode root, List<Integer> rightViewNodes, int level){
        if(root == null) return;
        if(rightViewNodes.size() == level){
            rightViewNodes.add(root.val);
        }
        dfs(root.right,rightViewNodes, level + 1);
        dfs(root.left,rightViewNodes, level + 1);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int N = q.size();
            TreeNode tNode = q.peek();
            list.add(tNode.val);
            for(int i=0;i<N;i++){
                TreeNode node = q.poll();
                if(node.right != null)q.offer(node.right);
                if(node.left != null)q.offer(node.left);
            }
        }
        return list;
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
