package com.mojo.base.leetcode;

public class MaxProfitMain {
    
    public static void main(String[] args) {
    
    }
    
    public int maxProfit(int[] prices) {
        
        int res = 0;
        int len = prices.length;
        
        for (int i = 0; i < len - 1; i++) {
            res += Math.max(prices[i + 1] - prices[i], 0);//只加正数,今天-昨天=正数，0，负数
        }
        return res;
    }
}
