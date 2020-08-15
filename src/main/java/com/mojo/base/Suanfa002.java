package com.mojo.base;

import java.util.HashMap;
import java.util.Map;

public class Suanfa002 {
    
    
    public static void main(String[] args) {
        
        int[] array = new int[]{1, 2,6,7};
        int size = array.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            
            for (int j = i + 1; j < size; j++) {
                sum = array[i] + array[j];
                Integer integer = map.get(sum);
                if (integer != null) {
                    integer++;
                    map.put(sum, integer);
                    if (maxVal < integer){
                        maxVal = integer;
                    }
                } else {
                    map.put(sum, 1);
                    
                }
            }
            
        }
        System.out.println(map);
    
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(maxVal)){
                System.out.println(entry.getKey());
            }
        }
    }
    
}
