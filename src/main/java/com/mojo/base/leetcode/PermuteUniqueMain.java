package com.mojo.base.leetcode;

import java.util.*;

public class PermuteUniqueMain {
    
    
    boolean[] vis;
    
    public static void main(String[] args) {
        
        //System.out.println(new PermuteUniqueMain().permuteUnique(new int[]{1,2}));
        
        
        System.out.println('b' - 'a');
    
        System.out.println(second(new int[]{1,8,9,2,3,7}));
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), 0, nums);
        return res;
    }
    
    
    public void dfs(List<List<Integer>> res, List<Integer> tempList, int index, int[] nums) {
        if (nums.length == index) {
            res.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            tempList.add(nums[i]);
            vis[i] = true;
            dfs(res, tempList, index + 1, nums);
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
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                res[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
    
    public int max = 0;
    
    public int diameterOfBinaryTree(MyTreeNode root) {
        
        getDep(root);
        return max;
    }
    
    private int getDep(MyTreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftDepth = getDep(root.left);
        int rightDepth = getDep(root.right);
        
        max = Math.max(leftDepth + rightDepth, max);
        return Math.max(leftDepth, rightDepth) + 1;
    }
    
    /**
     * https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (char c : chars.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        
        for (String word : words) {
            Map<Character, Integer> temp = (Map<Character, Integer>) map.clone();
            boolean flag = true;
            //
            char[] wordArray = word.toCharArray();
            
            for (char c : wordArray) {
                if (!temp.containsKey(c)) {
                    flag = false;
                    break;
                } else {
                    int integer = temp.get(c);
                    if (integer == 0) {
                        flag = false;
                        break;
                    } else {
                        integer--;
                        temp.put(c, integer);
                    }
                }
            }
            if (flag) {
                res += wordArray.length;
            }
        }
        return res;
    }
    
    public int countCharacters2(String[] words, String chars) {
        
        int[] chars_count = count(chars);
        
        int res = 0;
        
        for (String word : words) {
            int[] word_count = count(word);
            if (contains(chars_count, word_count)) {
                res += word.length();
            }
        }
        
        return res;
    }
    
    public boolean contains(int[] chars_count, int[] word_count) {
        for (int i = 0; i < 26; i++) {
            if (chars_count[i] < word_count[i]) {
                return false;
            }
        }
        return true;
    }
    
    public int[] count(String word) {//对字母-出现次数，做个映射
        int[] counter = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            counter[c - 'a']++;//每个字母-a既可以保证范围在int[26]中
        }
        return counter;
    }
    
    public static int second(int[] array){
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
    
        for (int num : array) {
            
            if (num > max){
                second = max;
                max = num;
            }else if (num > second){
                second = num;
            }
        }
        return second;
    }
}
