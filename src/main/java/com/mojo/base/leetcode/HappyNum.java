package com.mojo.base.leetcode;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class HappyNum {
    
    
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    
        System.out.println(firstUniqChar("aaa"));
        int s = 'z';
        System.out.println(s);
    }
    
    public static boolean isHappy(int n) {
        
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;//取数位，各个数位的数字
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
    
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int max = Integer.MIN_VALUE;
        
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        
        int[] temp = new int[candies.length];
        System.arraycopy(candies, 0, temp, 0, candies.length);
        
        List<Boolean> res = new ArrayList<>();
        
        for (int i : temp) {
            
            if (max - i > extraCandies) {
                res.add(false);
            } else {
                res.add(true);
            }
            
            
        }
        return res;
    }
    
    public static char firstUniqChar(String s) {
    
        char[] chars = s.toCharArray();
    
        Map<Character, Boolean> map = new HashMap<>();
    
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
    
        for (char aChar : chars) {
            if (map.get(aChar)){
                return aChar;
            }
        }
        return ' ';
    }
}
