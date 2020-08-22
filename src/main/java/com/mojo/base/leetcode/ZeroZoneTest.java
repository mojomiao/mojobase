package com.mojo.base.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ZeroZoneTest {
    
    public static void main(String[] args) {
        
        int[][] ma = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        
        setZeroes(ma);
    }
    
    public static void setZeroes(int[][] matrix) {
        //matrix.length代表有多少行
        //matrix[0].length代表有多少列
        
        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        
        for (Integer row : rows) {
            for (int i = 0; i < matrix.length; i++) {
                if (i == row) {
                    Arrays.fill(matrix[i], 0);
                }
            }
        }
        
        for (Integer col : columns) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
        
        System.out.println(matrix);
    }
    
    public static void setZeroes2(int[][] matrix) {
        boolean isFirstRowHaveZero = false;
        boolean isFirstColHaveZero = false;
        
        for (int i = 0; i < matrix.length; i++) {//遍历行
            if (matrix[i][0] == 0) {//遍历每一行的第一列
                isFirstColHaveZero = true;
            }
            
        }
        
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                isFirstRowHaveZero = true;//遍历每一列的第一行
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;//标记每列的开头为0
                    matrix[i][0] = 0;//标记每行的开头为0
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            if (isFirstColHaveZero) {
                matrix[i][0] = 0;
            }
        }
        
        for (int i = 0; i < matrix[0].length; i++) {
            if (isFirstRowHaveZero) {
                matrix[0][i] = 0;
            }
        }
        
    }
}
