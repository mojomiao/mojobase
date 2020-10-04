package com.mojo.base.leetcode;

import java.util.*;

public class PermuteUniqueMain {
    
    
    boolean[] vis;
    
    public static void main(String[] args) {
        
        System.out.println(new PermuteUniqueMain().permuteUnique(new int[]{1,2}));
        
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(),0, nums);
        return res;
    }
    
    
    public void dfs(List<List<Integer>> res, List<Integer> tempList, int index,int[] nums) {
        if (nums.length == index) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i-1] && !vis[i-1])){
                continue;
            }
            tempList.add(nums[i]);
            vis[i] = true;
            dfs(res, tempList, index+1, nums);
            vis[i] = false;
            tempList.remove(index);
        }
    }
    
    public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[Math.min(len1, len2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < len1 && index2 < len2){
            if (nums1[index1] < nums2[index2]){
                index1++;
            }else if (nums1[index1] > nums2[index2]){
                index2++;
            }else {
                res[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
