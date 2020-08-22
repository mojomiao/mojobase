package com.mojo.base.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftMinTree {
    
    public static void main(String[] args) {
    
    }
    
    public int findBottomLeftValue(TreeNode root) {
        int target = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.right != null) {//先放右边
                queue.add(curr.right);
                target = curr.right.val;
            }
            if (curr.left != null) {//再放左边
                queue.add(curr.left);
                target = curr.left.val;
            }
        }
        return target;
    }
    
    public static void flatten(TreeNode root) {
        
        List<TreeNode> list = new ArrayList<>();
        
        preOrder(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
        
    }
    
    public static void preOrder(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preOrder(root.left, list);
            preOrder(root.right, list);
        }
    }
    
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
}
