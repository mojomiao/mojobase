package com.mojo.base.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/solution/javaban-3chong-jie-fa-by-wang_dong/
 * 695. 岛屿的最大面积
 */
public class MaxAreaOfIslandMain {
    
    public static void main(String[] args) {
    
    
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int a = dfs(grid, i, j);
                    res = Math.max(res, a);
                }
            }
        }
        
        return res;
    }
    
    public static int dfs(int[][] grid, int row, int col) {
        
        if (!(0 <= row && row < grid.length && 0 <= col && col < grid[0].length)) {
            return 0;
        }
        
        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        return 1 + dfs(grid, row - 1, col) +
                dfs(grid, row + 1, col) +
                dfs(grid, row, col - 1) +
                dfs(grid, row, col + 1);//右方
    }
    
    public static int maxArea(int[][] grid) {
        Deque<int[]> queue = new LinkedList<>();
        
        int[][] moveIndexArray = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int maxArea = 0;
        
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                queue.offer(new int[]{row, col});
                int currMaxArea = 0;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int k = 0; k < size; k++) {
                        int[] poll = queue.poll();
                        int curI = poll[0];
                        int curJ = poll[1];
                        if (curI < 0 || curI >= grid.length || curJ < 0
                                || curJ >= grid[0].length || grid[curI][curJ] == 0) {
                            continue;
                        }
                        currMaxArea++;
                        grid[curI][curJ] = 0;
                        for (int[] moveIndex : moveIndexArray) {
                            queue.offer(new int[]{curI + moveIndex[0], curJ + moveIndex[1]});
                        }
                    }
                }//end while
                maxArea = Math.max(currMaxArea, maxArea);
            }
        }
        return maxArea;
    }
}
