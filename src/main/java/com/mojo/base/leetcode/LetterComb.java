package com.mojo.base.leetcode;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class LetterComb {
    
    public static void main(String[] args) {
        //System.out.println(new LetterComb().letterCombinations("23"));
    
    
        //System.out.println(new LetterComb().isSubsequence("bb","ahbgdc"));
    
        int contentChildren = new LetterComb().findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8});
        System.out.println(contentChildren);
    }
    
    public List<String> letterCombinations(String digits) {
        
        List<String> combs = new ArrayList<>();
        if (digits.length() == 0) {
            return combs;
        }
        
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        
        backtrack(combs, phoneMap, digits, 0, new StringBuffer());
        return combs;
    }
    
    public void backtrack(List<String> combs, Map<Character, String> phoneMap,
                          String digits, int index, StringBuffer combStr) {
        //终止条件
        if (index == digits.length()) {
            combs.add(combStr.toString());
        } else {
            char digit = digits.charAt(index);//取出第一个字符
            String letters = phoneMap.get(digit);//取出对应的数字字符串
            int letterCount = letters.length();
            for (int i = 0; i < letterCount; i++) {
                combStr.append(letters.charAt(i));
                backtrack(combs, phoneMap, digits, index + 1, combStr);
                combStr.deleteCharAt(index);
            }
        }
    }
    
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        
        int i = 0, j = 0;
        while (i< n && j<m){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        return i == n;
    }
    
    public static int secondNum(int[] nums) {
        
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int num : nums) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second) {
                second = num;
            }
        }
        return second;
        
        
    }
    
    public int findContentChildren(int[] g, int[] s) {
    
        int n = g.length, m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i< n && j<m){
            if (g[i] <= s[j]){
                i++;
            }
            j++;
        }
        return i;
        
    }
    
//    public int findContentChildren(int[] g, int[] s) {
//
//        int count = 0;
//
//        for (int i = 0; i < ; i++) {
//
//        }
//
//    }
}
