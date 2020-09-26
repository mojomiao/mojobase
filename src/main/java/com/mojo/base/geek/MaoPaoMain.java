package com.mojo.base.geek;

import com.google.common.base.Enums;

import java.util.HashMap;
import java.util.Map;

public class MaoPaoMain {
    
    
    public static void main(String[] args) {
        for (int arg : mao(new int[]{2, 7, 1, 3, 5})) {
            System.out.println(arg);
        }
        
        StaffType abc = Enums.getIfPresent(StaffType.class, "RD").orNull();
        System.out.println(abc);
    }
    
    private static final Map<String, StaffType> typeIndex =
            new HashMap<>(
                    StaffType.values().length
            );
    
    static {
        for (StaffType value : StaffType.values()) {
            typeIndex.put(value.name(), value);
        }
    }
    
    public static int[] mao(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return array;
    }
    
    public static enum StaffType {
        RD,
        QA,
        PM
    }
    
}

