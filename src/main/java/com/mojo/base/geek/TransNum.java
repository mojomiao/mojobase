package com.mojo.base.geek;

import java.math.BigInteger;

public class TransNum {
    
    public static void main(String[] args) {
        
        System.out.println(decToBinary(100));
        int a = 11;
        int b = 11;
        if ((a ^ b) == 0) {
            System.out.println("hint");
        }
        
        
        System.out.println(decimalToBinary(10));
        
        System.out.println(11 / 2);
    
        System.out.println(getSq(10, 0.5, 1000));
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
            if (delta< deltaThreshold){
                return middle;
            }else {
                if (square>n){
                    max = middle;
                }else {
                    min = middle;
                }
            }
        }
        return -2.0;
    }
}
