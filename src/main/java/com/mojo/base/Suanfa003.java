package com.mojo.base;

import java.util.HashMap;
import java.util.Map;

public class Suanfa003 {
    
    
    public static void main(String[] args) {
        
        int[] array = new int[]{1, 2, 6, 7};
        
        
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int curVal : array) {
            
            if (curVal >= max) {
                second = max;//second赋值为之前的最大值
                max = curVal;//当前值大于max则把max更新为当前值
            } else if (curVal > second) {
                second = curVal;//进入这里表示second<curVal<max
            }
            
            
        }
        
        System.out.println(second);
    }
    
}
