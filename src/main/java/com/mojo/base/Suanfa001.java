package com.mojo.base;

import java.util.List;

public class Suanfa001 {
    
    
    public static void main(String[] args) {
        
        
        int[] array = new int[]{5, 5, 7, 2};
        
        int[] tempArray = new int[4];
        
        int k = 2;
        while (k > 0) {
            
            tempArray = array;
            
            
            //找出最小的数
    
            int min = min(tempArray);
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0){
                    array[i] = tempArray[i] - min;
                }
            }
            System.out.println(min);
            k--;
        }
    
        //System.out.println(min(array));
        
    }
    
    public static int min(int[] array) {
        
        
        int res = Integer.MAX_VALUE;
        
        for (int i : array) {
            if (i < res) {
                res = i;
            }
        }
        return res;
        
    }
    
}
