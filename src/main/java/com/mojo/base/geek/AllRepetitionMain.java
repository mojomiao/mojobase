package com.mojo.base.geek;

import java.util.ArrayList;
import java.util.List;

public class AllRepetitionMain {
    
    public static void main(String[] args) {
        
        System.out.println(all(new int[]{1, 2}));
        
    }
    
    public static List<List<Integer>> all(int[] array) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), array, new boolean[array.length]);
        
        return res;
    }
    
    public static void backtrack(List<List<Integer>> res,
                                 List<Integer> tempList,
                                 int[] array,
                                 boolean[] visited) {
        
        if (tempList.size() == array.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = 0; i < array.length; i++) {
            
            if (visited[i]) {
                continue;
            }
            tempList.add(array[i]);
            visited[i] = true;
            backtrack(res, tempList, array, visited);
            visited[i] = false;
            tempList.remove(tempList.size() - 1);
        }
        
    }
}
