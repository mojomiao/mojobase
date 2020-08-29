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
    
    public int maxProfit2(int[] prices) {
        
        if (prices.length == 0) {
            return 0;
        }
        
        int profit = 0, minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, prices[i] - minPrice);//计算最大收益
            minPrice = Math.min(minPrice, prices[i]);//找出最小的价格
        }
        return profit;
    }
    
    public int maxProfit2DP(int[] prices) {
        
        //前i日最大利润=max(前(i-1)日最大利润, 第i日价格 - 前i日最低价格)
        //dp[i] = max(dp[i-1],prices[i]-min(prices[0:i]))
        
        int max = 0;
        int min = prices[0];
        int[] dp = new int[prices.length];
    
        for (int i = 1; i < prices.length; i++) {
            
            min = Math.min(prices[i], min);
            dp[i] = Math.max(dp[i-1], prices[i]-min);
        }
        return dp[prices.length - 1];
        
        
        
    }
    
    public static int numBitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
    
    public static int secondNum(int[] array) {
        
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int num : array) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second) {
                second = num;
            }
        }
        return second;
    }
}
