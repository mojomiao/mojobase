package com.mojo.base.geek;

import java.util.Arrays;

public class SuanMain {
    
    public static void main(String[] args) {
        
        int[] array = {2, 1};
        int[] res = mergeSort(array);
        
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        
    }
    
    public static int[] mergeSort(int[] array) {
        if (array == null) {
            return new int[0];
        }
        
        if (array.length == 1) {
            return array;//切分至只有一个元素时返回
        }
        
        int mid = array.length / 2;//切分数组的界限
        int[] left = Arrays.copyOfRange(array, 0, mid);//左边
        int[] right = Arrays.copyOfRange(array, mid, array.length);//右边
        
        left = mergeSort(left);//
        right = mergeSort(right);
        
        int[] merged = merge(left, right);
        return merged;
    }
    
    private static int[] merge(int[] left, int[] right) {
        if (left == null) {
            left = new int[0];
        }
        
        if (right == null) {
            right = new int[0];
        }
        
        int[] mergedOne = new int[left.length + right.length];
        int mi = 0, ai = 0, bi = 0;
        
        while (ai < left.length && bi < right.length) {
            if (left[ai] <= right[bi]) {
                mergedOne[mi] = left[ai];
                ai++;
            } else {
                mergedOne[mi] = right[bi];
                bi++;
            }
            mi++;
        }
        //处理剩余元素
        if (ai < left.length) {
            for (int i = ai; i < left.length; i++) {
                mergedOne[mi] = left[i];
                mi++;
            }
        } else {
            for (int i = bi; i < right.length; i++) {
                mergedOne[mi] = right[i];
                mi++;
            }
        }
        
        return mergedOne;
    }
}
