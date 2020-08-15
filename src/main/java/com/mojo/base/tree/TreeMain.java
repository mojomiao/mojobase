package com.mojo.base.tree;

import com.google.common.collect.Lists;

import java.util.*;

public class TreeMain {
    
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l21 = new TreeNode(4);
        TreeNode l22 = new TreeNode(5);
        TreeNode r21 = new TreeNode(6);
        TreeNode r22 = new TreeNode(7);
        
        root.setChildList(Lists.newArrayList(l1, r1));
        
        l1.setChildList(Lists.newArrayList(l21, l22));
        r1.setChildList(Lists.newArrayList(r21, r22));
        
        
        dfs(root);
        
    }
    
    public static void dfs(TreeNode tree) {
        
        if (tree != null) {
            //1,3,7,6,2,5,4
            
            Stack<Map<TreeNode, Integer>> stack = new Stack<>();
            
            Map<TreeNode, Integer> root = new HashMap<>();
            root.put(tree, 0);
            stack.push(root);
            
            while (!stack.isEmpty()) {
                
                
                Map<TreeNode, Integer> item = stack.pop();
                TreeNode node = item.keySet().iterator().next();
                int depth = item.get(node);
                
                System.out.println(node.getValue() + ", " + depth);
                
                if (node.getChildList() != null && !node.getChildList().isEmpty()) {
                    for (TreeNode treeNode : node.getChildList()) {
                        Map<TreeNode, Integer> map = new HashMap<>();
                        map.put(treeNode, depth + 1);
                        stack.push(map);
                    }
                }
            }
        }
    }
    
    public static void bfs(TreeNode tree) {
        
        
        Queue<Map<TreeNode, Integer>> queue = new ArrayDeque<>();
        
        Map<TreeNode, Integer> root = new HashMap<>();
        
        root.put(tree, 0);
        
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            Map<TreeNode, Integer> itemMap = queue.poll();
            
            TreeNode itemTreeNode = itemMap.keySet().iterator().next();
            
            int depth = itemMap.get(itemTreeNode);
            
            System.out.println(itemTreeNode.getValue() + ", " + depth);
            
            if (itemTreeNode.getChildList() != null && !itemTreeNode.getChildList().isEmpty()) {
                for (TreeNode child : itemTreeNode.getChildList()) {
                    Map<TreeNode, Integer> map = new HashMap<>();
                    map.put(child, depth + 1);
                    queue.offer(map);
                }
            }
            
        }
    }
}
