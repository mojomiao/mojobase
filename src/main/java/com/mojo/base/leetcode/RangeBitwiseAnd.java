package com.mojo.base.leetcode;

public class RangeBitwiseAnd {
    
    public static void main(String[] args) {
    
        System.out.println(new RangeBitwiseAnd().rangeBitwiseAnd(5,7));
    }
    
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for (int i = m+1; i <= n; i++) {
            res = res & i;
        }
        return res;
    }
}
