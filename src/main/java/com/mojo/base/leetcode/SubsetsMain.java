package com.mojo.base.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubsetsMain {
    
    public static void main(String[] args) {
        List<List<Integer>> lists = new SubsetsMain().subsets2(new int[]{1, 2, 3});
        System.out.println(lists);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> answers = new ArrayList<>();
        answers.add(new ArrayList<>());
        for (int num : nums) {
            int len = answers.size();
    
            for (int i = 0; i < len; i++) {
                List<Integer> lists = new ArrayList<>();
                lists.addAll(answers.get(i));//把之前的每一次结果加到本次中
                lists.add(num);//把当前的数字加进去
                answers.add(lists);
            }
        }
        return answers;
        
    }
    
    public List<List<Integer>> subsets2(int[] nums) {
        
        List<List<Integer>> answers = new ArrayList<>();
        
        backtrack(answers, new ArrayList<>(), nums, 0);
        return answers;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums,int start){
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
