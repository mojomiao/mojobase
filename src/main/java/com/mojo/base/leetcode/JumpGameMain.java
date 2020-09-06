package com.mojo.base.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JumpGameMain {
    
    public static void main(String[] args) {
        
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int pathSum = new JumpGameMain()
                .minPathSum(grid);
        System.err.println(pathSum);
    }
    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        
        for (int i = 0; i < n; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);//i+nums[i]是当前位置+当前位置可跳跃最大的位置
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public int minPathSum(int[][] grid) {
        
        
        //向下走i+1,j向右走i,j+1

//        List<List<Integer>> path = new ArrayList<>();
//
        int rowMax = grid.length;
        int colMax = grid[0].length;
        
        int[][] memo = new int[rowMax][colMax];
        for (int i = 0; i < rowMax; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs2(grid, 0, 0, memo, rowMax, colMax);
//
//        boolean[][] visited = new boolean[rowMax][colMax];
//
//
//        dfs(path, new ArrayList<>(), grid, 0, 0, rowMax, colMax, visited);
//
//        System.err.println(path);
//
//        return 1;
    
        
    }
    
    public void dfs(List<List<Integer>> path, List<Integer> temp, int[][] grid
            , int x, int y, int rowMax, int colMax, boolean[][] visited) {
        if (x == rowMax - 1 && y == colMax - 1) {
            temp.add(grid[x][y]);
            path.add(new ArrayList<>(temp));
            return;
        }
        
        if (x == rowMax || y == colMax) {
            return;
        }

//        if (visited[x][y]) {
//            return;
//        }
//
//        visited[x][y] = true;
        
        temp.add(grid[x][y]);
        
        dfs(path, temp, grid, x + 1, y, rowMax, colMax, visited);
        dfs(path, temp, grid, x, y + 1, rowMax, colMax, visited);
        
    }
    
    private int dfs2(int[][] grid, int row, int col, int[][] memo, int rowMax, int colMax) {
        if (row < 0 || row >= rowMax || col < 0 || col >= colMax) {
            return Integer.MAX_VALUE;
        }
        
        if (memo[row][col] > -1) {
            return memo[row][col];
        }
        
        if (row == rowMax - 1 && col == colMax - 1) {
            return grid[row][col];
        }
        
        int right = dfs2(grid, row, col + 1, memo, rowMax, colMax);
        int down = dfs2(grid, row + 1, col, memo, rowMax, colMax);
        int ans = Math.min(right, down) + grid[row][col];
        memo[row][col] = ans;
        return ans;
    }
    
    
    //dp
    
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
    
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
    
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
    
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])+grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }
}
