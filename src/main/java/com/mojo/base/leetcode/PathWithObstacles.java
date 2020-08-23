package com.mojo.base.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathWithObstacles {
    
    private static List<List<Integer>> list = new ArrayList<>();
    
    public static void main(String[] args) {
        pathWithObstacles(new int[][]{
                
                {0,0,0},
                {0,1,0},
                {0,0,0}
        });
    }
    
    public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        dfs(0, 0, obstacleGrid, obstacleGrid.length, obstacleGrid[0].length);
        return list;
    }
    
    public static void dfs(int i, int j, int[][] obstacleGrid, int maxI, int maxJ) {
        if (i == maxI-1 && j == maxJ-1) {
            return;
        }
        if (obstacleGrid[i][j] == 1) {
            return;
        }
        
        
        if (obstacleGrid[i][j] == 0) {
            List<Integer> l = new ArrayList<>();
            l.add(i);
            l.add(j);
            list.add(l);
        }
        dfs(i + 1, j, obstacleGrid, maxI, maxJ);
        dfs(i, j + 1, obstacleGrid, maxI, maxJ);
    }
    
    
}
