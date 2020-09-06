package com.mojo.base.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum {
    
    
    public static void main(String[] args) {
    
    }
    
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//
//
//
//    }
    
    public void backtrack(int[] candidates, int begin, int len, int target, Deque<Integer> path, List<List<Integer>> res){
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
    
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0){
                break;
            }
            
            path.addLast(candidates[i]);
            backtrack(candidates, i, len, target - candidates[i], path, res);
            path.removeLast();
        }
        
    }
    
    
}
