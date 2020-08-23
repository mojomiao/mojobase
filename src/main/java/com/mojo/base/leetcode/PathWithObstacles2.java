package com.mojo.base.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathWithObstacles2 {
    
    private static List<List<Integer>> path = new LinkedList<>();
    
    int row = 0;
    int col = 0;
    
    public static void main(String[] args) {
        List<List<Integer>> lists = new PathWithObstacles2().pathWithObstacles(new int[][]{
            
                {0, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        });
        System.out.println(lists);
    }
    
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        row = obstacleGrid.length;
        if (row == 0){
            return path;
        }
        col = obstacleGrid[0].length;
        if (obstacleGrid[row-1][col-1] == 1){//终点有障碍，始终走不到
            return path;
        }
        boolean[][] visit = new boolean[row][col];
        backtrack(obstacleGrid, 0, 0, visit);
        return path;
    }
    
    public boolean backtrack(int[][] obstacleGrid, int x, int y, boolean[][] visit) {
        if (x >= row || y >= col || obstacleGrid[x][y] == 1 || visit[x][y]) {
            return false;
        }
        path.add(Arrays.asList(x, y));
        visit[x][y] = true;//标识已经访问过
        if (x == row - 1 && y == col - 1) {
            return true;
        }
        
        if (backtrack(obstacleGrid, x + 1, y, visit) || backtrack(obstacleGrid, x, y + 1, visit)) {
            return true;
        }
        //死胡同,撤销最后一步
        path.remove(path.size() - 1);
        return false;
    }
    
    
}
