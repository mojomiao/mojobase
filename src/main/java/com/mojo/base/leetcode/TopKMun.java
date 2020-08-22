package com.mojo.base.leetcode;

import org.checkerframework.checker.units.qual.A;

import java.util.*;

public class TopKMun {
    
    
    public static void main(String[] args) {
        
        int[] ints = topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int anInt : ints) {
            System.err.println(anInt);
        }
        
    }
    
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
//        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
//
//        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
    
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        
        
        int[] res = new int[k];
        
        for (int i = 0; i < k; i++) {
            //res[i] = list.get(i).getKey();
            res[i] = maxHeap.poll().getKey();
        }
        
        return res;
    }
    
    static class Item {
        private int key;
        
        private int value;
        
        public int getKey() {
            return key;
        }
        
        public void setKey(int key) {
            this.key = key;
        }
        
        public int getValue() {
            return value;
        }
        
        public void setValue(int value) {
            this.value = value;
        }
    }
}
