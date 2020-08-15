package com.mojo.base.leetcode;

public class LcDfs1 {
    
    
     int m, n, k;
    
     boolean[][] visited;
    
    public int movingCount(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0,0);
    }
    
    public int dfs(int i, int j) {
        if (i >= m || j >= n || visited[i][j] || count(i, j) > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i + 1, j) + dfs(i, j + 1);
    }
    
    public int count(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }
}
