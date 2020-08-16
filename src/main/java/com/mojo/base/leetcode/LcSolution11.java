package com.mojo.base.leetcode;

public class LcSolution11 {
    
    
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            
            int pivot = low + (high - low) / 2;
            
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
    
    public int minArray2(int[] numbers) {
        for (int i = numbers.length - 1; i >= 1; i--) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {9, 10, 11}};
        int[] ints = new LcSolution11().spiralOrder2(matrix);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        //System.out.println();
    }
    
    public int[] spiralOrder(int[][] matrix) {
        
        int[] res = new int[matrix.length * matrix[0].length];
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                res[count++] = matrix[i][j];
            }
        }
        
        return res;
    }
    
    public int[] spiralOrder2(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        
        int rows = matrix.length, columns = matrix[0].length;
        
        int[] order = new int[rows * columns];
        
        int index = 0;
        
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        
        while (left <= right && top <= bottom) {
            
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];//处理最上边外圈的行
            }
            
            for (int row = top + 1; row <= bottom; row++) {//处理右侧外圈的列
                order[index++] = matrix[row][right];//右边的right不变，row向下移动
            }
            
            if (left < right && top < bottom) {
                for (int column = right - 1; column > left; column--) {//处理最下边外圈的行
                    order[index++] = matrix[bottom][column];//遍历至底部，向左移动，则bottom行不变，column向左挪动
                }
                
                for (int row = bottom; row > top; row--) {//处理最左侧外圈的列
                    order[index++] = matrix[row][left];//遍历至左下角，向上移动,则left不变，row--向上移动
                }
            }
            
            left++;//左边向右一格
            right--;//右边向左一格
            top++;//上边向下一格
            bottom--;//下面向上一格
            
            
        }
        return order;
        
        
    }
}
