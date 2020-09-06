package com.mojo.base.leetcode;

public class DupNum {
    
    
    public static void main(String[] args) {
    
        System.out.println(128105 /10);
    }
    
    public int findRepeatNumber(int[] nums) {
        boolean[] array = new boolean[100000];
        
        for (int i = 0; i < nums.length; i++) {
            if (array[nums[i]]) {
                return nums[i];
            } else {
                array[nums[i]] = true;
            }
        }
        return -1;
    }
    
    //翻译数字为字符串
//    public int translateNum(int num) {
//
//
//    }
    
    public int dfs3(String str, int index) {
        
        if (index >= str.length() - 1) {
            return 1;
        }
        
        int res = dfs3(str, index + 1);
        String temp = str.substring(index, index + 2);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
            res += dfs3(str, index + 2);
        }
        return res;
    }
}
