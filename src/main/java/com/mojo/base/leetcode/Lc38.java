package com.mojo.base.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc38 {
    
    
    public static void main(String[] args) {
        
        //System.out.println(addBinary("11", "1"));
        
        //int[] ints = maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        
        
        System.out.println(bitSum(19));
        
    }
    
    public int movingCount(int m, int n, int k) {
        
        
        return 1;
    }


//    public static int dfs(int i, int j){
//        if ()
//    }
    
    
    /**
     * 数位和方法
     *
     * @param n
     * @return
     */
    public static int bitSum(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + n % 10;//取余数
            n = n / 10;//消除一位数
        }
        return sum;
    }
    
    
    /**
     * 滑动窗口的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums.length == 0) {
            return new int[0];
        }
        
        int left = 0;
        int right = k - 1;
        
        int count = 0;
        int cap = nums.length - k + 1;
        
        int[] res = new int[cap];
        
        while (count != cap) {
            
            int max = Integer.MIN_VALUE;
            
            for (int i = left; i <= right; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                }
            }
            System.out.println(max);
            res[count] = max;
            left++;
            right++;
            count++;
        }
        
        return res;
    }
    
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        int j = 1;
        int sum = 0;
        List<int[]> res = new ArrayList<>();
        
        
        while (i <= target / 2) {
            if (sum < target) {
                sum += j;
                j++;
            } else if (sum > target) {
                sum -= i;
                i++;
            } else {
                int[] arr = new int[j - i];
                for (int k = i; k < j; k++) {
                    arr[k - i] = k;
                }
                res.add(arr);
                sum -= i;
                i++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
    
    public static String addBinary(String a, String b) {
        
        return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
    }
}
