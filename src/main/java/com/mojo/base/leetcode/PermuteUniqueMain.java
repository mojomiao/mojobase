package com.mojo.base.leetcode;

import java.util.*;

public class PermuteUniqueMain {
    
    
    boolean[] vis;
    
    public static void main(String[] args) {
        
        //System.out.println(new PermuteUniqueMain().permuteUnique(new int[]{1,2}));
        
        
        System.out.println('b' - 'a');
        
        System.out.println(second(new int[]{1, 8, 9, 2, 3, 7}));
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
    
    public static int second(int[] array) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        
        for (int num : array) {
            
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second) {
                second = num;
            }
        }
        return second;
    }
    
    /**
     * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
     * 如果当前元素大于目标值，则移到左边一列。如果当前元素小于目标值，则移到下边一行。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length, columns = matrix[0].length;
        int row = 0, column = columns - 1;
        
        while (row < rows && column >= 0) {
            int num = matrix[row][column];
            if (num == target) {
                return true;
            } else if (num > target) {
                column--;
            } else {
                row++;
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0
                || board[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        
        char temp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1)
                || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = temp;
        return res;
        
        
    }
    
    private int getNext(int n){
        int total = 0;
        while (n > 0){
            int d = n % 10;
            n = n / 10;
            total += d *d;
        }
        return total;
    }
    
    public boolean isHappy(int n){
        Set<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)){
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    
    public static void preOrderND(MyTreeNode node){
        
        
        Stack<MyTreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            
            MyTreeNode temp = stack.pop();
    
            System.out.println(temp.val);
            if (temp.right != null){
                stack.push(temp.right);
            }
            if (temp.left != null){
                stack.push(temp.left);
            }
        }
        
    }
    
    public double myPow1(double x, long n) {
        if(n == 0){
            return 1.0;
        }
        if ((n & 1) == 1){
            return x * myPow1(x, n -1);
        }else{
            double temp = myPow1(x, n/2);
            return temp * temp;
        }
    }
    
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0? myPow1(x, N):1.0/myPow1(x, -N);
    }
    
    public int cnt = 0;
    
    public int search(int[] nums, int target){
        helper(nums, target, 0, nums.length-1);
        return cnt;
    }
    
    public void helper(int[] nums, int target, int low, int high){
        if (low <= high){
            int mid = (high - low)/2+low;
            if (nums[mid] == target){
                cnt++;
                helper(nums, target, low, mid-1);
                helper(nums, target, mid+1, high);
            }else if (nums[mid] > target){
                helper(nums, target, low, mid-1);
            }else {
                helper(nums, target, mid+1, high);
            }
        }
    }
    
}
