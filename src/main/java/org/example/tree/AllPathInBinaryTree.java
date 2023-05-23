package org.example.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class AllPathInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        print(root);
        List<LinkedList<TreeNode>> paths = getAllPath(root);
        paths.forEach(path-> {
            path.forEach(node-> {
                System.out.print(node.val+ "\t");
            });
            System.out.println();
        });
    }

    static List<LinkedList<TreeNode>> getAllPath(TreeNode root) {
        //Method1 recursive
        //return getAllPath1(root);

        //Method2 BackTrack
        return getAllPath2(root);
    }


    static List<LinkedList<TreeNode>> getAllPath2(TreeNode root) {
        List<LinkedList<TreeNode>> paths = new ArrayList<>();
        getAllPath2Recur(root, new LinkedList<>(), paths);
        return paths;
    }


    static void getAllPath2Recur(TreeNode root, LinkedList<TreeNode> path, List<LinkedList<TreeNode>> paths) {
        if(root.left == null && root.right == null) {
            path.add(root);
            paths.add(new LinkedList<>(path));
            return;
        }

        path.addLast(root);
        if(root.left != null) {
            getAllPath2Recur(root.left, path, paths);
            path.pollLast();
        }

        if(root.right != null) {
            getAllPath2Recur(root.right, path, paths);
            path.pollLast();
        }
    }

    static List<LinkedList<TreeNode>> getAllPath1(TreeNode root) {
        if(root.left == null && root.right == null){
            List<LinkedList<TreeNode>> paths = new ArrayList<>();
            paths.add(new LinkedList<>(List.of(root)));
            return paths;
        }

        List<LinkedList<TreeNode>> paths = new ArrayList<>();
        if(root.left != null) {
            List<LinkedList<TreeNode>> leftPaths = getAllPath1(root.left);
            for(LinkedList<TreeNode> path: leftPaths) {
                path.addFirst(root);
                paths.add(path);
            }
        }
        if(root.right != null) {
            List<LinkedList<TreeNode>> rightPaths = getAllPath1(root.right);
            for(LinkedList<TreeNode> path: rightPaths) {
                path.addFirst(root);
                paths.add(path);
            }
        }
        return paths;

    }

    static void traverse(TreeNode root, LinkedList<TreeNode> path, List<List<TreeNode>> paths) {
        if(root.left == null && root.right == null) {
            paths.add(new ArrayList<>(path));
            return;
        }
        path = new LinkedList<>(path);
        path.addLast(root);
        if(root.left != null)traverse(root.left, path, paths);
        if(root.right!= null)traverse(root.right, path, paths);
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
