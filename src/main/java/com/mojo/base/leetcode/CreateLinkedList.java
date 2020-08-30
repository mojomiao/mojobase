package com.mojo.base.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CreateLinkedList {
    
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(7);
        TreeNode t6 = new TreeNode(8);
        
        
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.right = t5;
        t3.left = t6;
    
        ListNode[] listNodes = new CreateLinkedList().listOfDepth(root);
        System.out.println(listNodes);
    
    }
    
    public ListNode[] listOfDepth(TreeNode tree) {
        
        if (tree == null) {
            return new ListNode[]{};
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);
        List<ListNode> res = new ArrayList<>();
        ListNode dummy = new ListNode(0);
    
        
        while (!queue.isEmpty()) {
            int size = queue.size();//当前层的节点个数
            System.out.println(size);
            ListNode curr = dummy;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                curr.next = new ListNode(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
    
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                curr = curr.next;
            }
            res.add(dummy.next);
            dummy.next = null;
        }
        
        return res.toArray(new ListNode[]{});
    }
    
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode(int x) {
            val = x;
        }
    }
    
    public static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
        }
    }
}
