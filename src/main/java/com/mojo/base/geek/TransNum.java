package com.mojo.base.geek;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TransNum {
    
    public static void main(String[] args) {

//        System.out.println(decToBinary(100));
//        int a = 11;
//        int b = 11;
//        if ((a ^ b) == 0) {
//            System.out.println("hint");
//        }
//
//
//        System.out.println(decimalToBinary(10));
//
//        System.out.println(11 / 2);
//
//        System.out.println(getSq(10, 0.5, 1000));


//        ArrayList<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2);
//
//        ArrayList<Integer> l2 = (ArrayList<Integer>) l1.clone();
//        l1.add(3);
//        System.out.println(l2);
    
        recursion(2, new ArrayList<>());
    
        
        
    }
    
    public static String decToBinary(int dec) {
        BigInteger bi = new BigInteger(String.valueOf(dec));
        return bi.toString(2);
    }
    
    public static String decimalToBinary(int decimalSource) {
        StringBuilder sb = new StringBuilder();
        while (decimalSource != 0) {
            sb.append(decimalSource % 2);
            decimalSource = decimalSource >> 1;
        }
        return sb.reverse().toString();
    }
    
    public static long getNumberOfWheat(int grid) {
        long sum = 0;
        int res = 0;
        
        res = 1;
        sum += res;
        for (int i = 2; i <= grid; i++) {
            res *= 2;
            sum += res;
        }
        return sum;
    }
    
    /**
     * n-待求的数, deltaThreshold-误差的阈值, maxTry-二分查找的最大次数
     *
     * @param n
     * @param deltaThreshold
     * @param maxTry
     * @return
     */
    public static double getSq(int n, double deltaThreshold, int maxTry) {
        if (n <= 1) {
            return -1.0;
        }
        
        double min = 1.0, max = (double) n;
        for (int i = 0; i < maxTry; i++) {
            double middle = (min + max) / 2;
            double square = middle * middle;
            double delta = Math.abs((square / n) - 1);
            if (delta < deltaThreshold) {
                return middle;
            } else {
                if (square > n) {
                    max = middle;
                } else {
                    min = middle;
                }
            }
        }
        return -2.0;
    }
    
    public static long[] rewards = {1, 2};
    
    public static void get(long total, ArrayList<Long> result) {
        if (total == 0) {
            System.out.println(result);
            return;
        } else if (total < 0) {
            return;
        } else {
            for (int i = 0; i < rewards.length; i++) {
                ArrayList<Long> newResult = (ArrayList<Long>) result.clone();
                newResult.add(rewards[i]);
                get(total - rewards[i], newResult);
            }
        }
    }
    
    public static void recursion(int total, ArrayList<Integer> result) {
        if (total == 1) {
            if (!result.contains(1)){
                result.add(1);
            }
            
            System.out.println(result);
            return;
        } else {
            for (int i = 1; i <= total; i++) {
                if ((i == 1) && result.contains(1)){
                    continue;
                }
                ArrayList<Integer> newList = (ArrayList<Integer>) result.clone();
                newList.add(i);
                if (total % i != 0) {
                    continue;
                }
                recursion(total/i, newList);
            }
        }
    }
}
