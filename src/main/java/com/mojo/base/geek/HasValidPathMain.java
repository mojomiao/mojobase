package com.mojo.base.geek;

public class HasValidPathMain {
    
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
     * @param grid
     * @return
     */
    public static boolean hasValidPath(int[][] grid) {
        
        return dfs(grid, 0, 0);
    
    }
    
    public static void main(String[] args) {
        
        int[][] grid = new int[][]{
                {2,4,3},
                {6,5,2}
        };
        
        System.out.println(hasValidPath(grid));
    }
    
    public static boolean dfs(int[][] grid, int row, int col){
        
        if (row <0 || col < 0){
            return false;
        }
        
        if (row == grid.length -1 && col == grid[0].length -1){
            return true;
        }
        
        if (grid[row][col] == 1){
            dfs(grid, row, col-1);
            dfs(grid, row, col+1);
        }
        if (grid[row][col] == 2){
            dfs(grid, row-1, col);
            dfs(grid, row+1, col);
        }
        if (grid[row][col] == 3){
            dfs(grid, row, col-1);
            dfs(grid, row+1, col);
        }
        if (grid[row][col] == 4){
            dfs(grid, row, col+1);
            dfs(grid, row+1, col);
        }
        if (grid[row][col] == 5){
            dfs(grid, row, col-1);
            dfs(grid, row+1, col);
        }
        if (grid[row][col] == 6){
            dfs(grid, row, col+1);
            dfs(grid, row+1, col);
        }
        return false;
    }
}
