package com.mojo.base.leetcode;

import com.mojo.base.tree.TreeNode;
import org.checkerframework.checker.units.qual.A;

import java.util.*;

/**
 * 64最小路径和
 */
public class MinPathSumMain {
    
    public static void main(String[] args) {
    
    }
    
    public int minPathSum(int[][] grid){
        //dp[i][j] = min(dp[i-1][j],dp[i][j+1]
        
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        
        return dp[grid.length-1][grid[0].length-1];
        
        
    }
    
    public boolean isUnique(String astr) {
        Set<Character> set = new HashSet<>();
        char[] chars = astr.toCharArray();
    
        for (char aChar : chars) {
            if (set.contains(aChar)){
                return false;
            }else {
                set.add(aChar);
            }
        }
        return true;
    
    
    }
    
    public List<List<Integer>> levelOrderBottom(MyTreeNode root){
        if (root == null){
            return new ArrayList<>();
        }
    
        LinkedList<List<Integer>> res = new LinkedList<>();
        
        Queue<MyTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                MyTreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            res.add(0, temp);
        }
        return res;
    }
}
