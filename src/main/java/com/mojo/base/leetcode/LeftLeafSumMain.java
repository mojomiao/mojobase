package com.mojo.base.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftLeafSumMain {
    
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                if (poll.left.left == null && root.right.right == null) {
                    sum += poll.left.val;
                }
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
        return sum;
        
    }
    
    public int sumOfLeftLeaves2(TreeNode root, boolean flag) {
        if (root == null) {
            return 0;
        }
        if (flag && root.left == null && root.right == null) {
            return root.val;
        }
        int left = sumOfLeftLeaves2(root.left, true);
        int right = sumOfLeftLeaves2(root.right, false);
        return left + right;
    }
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
}
