package com.mojo.base.leetcode;

public class HasValidPath1319Main {
    
    
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {2,4,3},
                {6,5,2}
        };
        System.out.println(new HasValidPath1319Main().hasValidPath(grid));
    }
    
    private int m;
    private int n;
    private int[][] grid;
    
    private boolean[][] used;
    //假设当前单元格是1，那么可以往左走，也可以往右走，如果往左走的话，则只有(1, 4, 6)可以接的上去。右边与其他数字同理
    private boolean isLeftOk(int i, int j) {
        return j > 0 && (grid[i][j - 1] == 1 || grid[i][j - 1] == 4 || grid[i][j - 1] == 6);
    }
    
    private boolean isRightOk(int i, int j) {
        return j + 1 < n && (grid[i][j + 1] == 1 || grid[i][j + 1] == 3 || grid[i][j + 1] == 5);
    }
    
    private boolean isUpOk(int i, int j) {
        return i > 0 && (grid[i - 1][j] == 2 || grid[i - 1][j] == 3 || grid[i - 1][j] == 4);
    }
    
    private boolean isBottomOk(int i, int j) {
        return i + 1 < m && (grid[i + 1][j] == 2 || grid[i + 1][j] == 5 || grid[i + 1][j] == 6);
    }
    
    private boolean dfs(int i, int j) {
        if (used[i][j]) {
            return false;
        }
        
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        
        used[i][j] = true;//
        
        int val = grid[i][j];
        /**
         * 1 表示连接左单元格和右单元格的街道。
         * 2 表示连接上单元格和下单元格的街道。
         * 3 表示连接左单元格和下单元格的街道。
         * 4 表示连接右单元格和下单元格的街道。
         * 5 表示连接左单元格和上单元格的街道。
         * 6 表示连接右单元格和上单元格的街道。
         *
         * 来源：力扣（LeetCode）
         * 链接：https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid
         * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
         */
        
        if (val == 1) {//1 表示连接左单元格和右单元格的街道,可以向左或向右
            //如果可以向左，isLeftOk(i, j)
            //就向左走dfs(i, j - 1)
            return isLeftOk(i, j) && dfs(i, j - 1) || isRightOk(i, j) && dfs(i, j + 1);
        } else if (val == 2) {
            return isUpOk(i, j) && dfs(i - 1, j) || isBottomOk(i, j) && dfs(i + 1, j);
        } else if (val == 3) {
            return isLeftOk(i, j) && dfs(i, j - 1) || isBottomOk(i, j) && dfs(i + 1, j);
        } else if (val == 4) {
            return isRightOk(i, j) && dfs(i, j + 1) || isBottomOk(i, j) && dfs(i + 1, j);
        } else if (val == 5) {
            return isLeftOk(i, j) && dfs(i, j - 1) || isUpOk(i, j) && dfs(i - 1, j);
        }
        
        return isUpOk(i, j) && dfs(i - 1, j) || isRightOk(i, j) && dfs(i, j + 1);
        
        
    }
    
    
    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        used = new boolean[m][n];
        return dfs(0, 0);
    }
    
}
