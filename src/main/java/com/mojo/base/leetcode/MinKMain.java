package com.mojo.base.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinKMain {
    
    public static void main(String[] args) {
    
    }
    
    public int[] smallestK(int[] arr, int k){
    
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    
        for (int i : arr) {
            minHeap.offer(i);
        }
    
    
        int[] res = new int[k];
    
        for (int i = 0; i < k; i++) {
            res[i] = minHeap.poll();
        }
    
        return res;
    }
}
