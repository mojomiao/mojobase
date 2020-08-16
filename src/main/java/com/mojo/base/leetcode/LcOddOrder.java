package com.mojo.base.leetcode;

public class LcOddOrder {
    
    public static void main(String[] args) {
        int[] exchange = new LcOddOrder().exchange(new int[]{1, 2, 3, 4});
        for (int i : exchange) {
            System.out.println(i);
        }
    }
    
    
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int index = 0;
        
        //与运算，数字&1的话如果为1代表是奇数，如果是0的话代表是偶数
        
        for (int num : nums) {
            if ((num & 1) == 1) {//奇数
                res[index++] = num;
            }
        }
        
        for (int num : nums) {
            if ((num & 1) == 0) {//偶数
                res[index++] = num;
            }
        }
        return res;
    }
    
    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        
        
        int i = 0, j = nums.length - 1, temp;
        
        while (i < j) {
            while (i < j && (nums[i] & 1) == 1) i++;
            while (i < j && (nums[i] & 1) == 0) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }
}
