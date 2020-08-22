package com.mojo.base.leetcode;

import java.util.*;

public class FindAndReplacePatternTest {

//    public static void main(String[] args) {
//        List<String> list = findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"}, "abb");
//        System.err.println(list);
//    }
    
    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        
        
        Map<Character, Integer> pMap = new LinkedHashMap<>();
        char[] chars = pattern.toCharArray();
        
        for (char aChar : chars) {
            pMap.put(aChar, pMap.getOrDefault(aChar, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Integer value : pMap.values()) {
            sb.append(value);
        }
        
        
        List<String> res = new ArrayList<>();
        String patterns = sb.toString();
        
        for (String word : words) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            char[] chars1 = word.toCharArray();
            for (char aChar : chars1) {
                map.put(aChar, map.getOrDefault(aChar, 0) + 1);
            }
            StringBuilder sb1 = new StringBuilder();
            
            for (Integer value : map.values()) {
                sb1.append(value);
            }
            if (sb1.toString().equals(patterns)) {
                res.add(word);
            }
            
        }
        
        return res;
    }
    
    public static List<String> findAndReplacePattern2(String[] words, String pattern) {
        
        
        List<String> res = new ArrayList<>();
        
        for (String word : words) {
            if (match(word, pattern)) {
                res.add(word);
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(match("xyy", "abc"));
    }
    
    public static boolean match(String word, String pattern) {
        
        Map<Character, Character> M = new HashMap<>();
        
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!M.containsKey(w)) {
                M.put(w, p);
                
            }
            if (M.get(w) != p) {
                return false;//xyy -> abc
            }
        }
        
        boolean[] seen = new boolean[26];//xyz->abb
        for (char p : M.values()) {
            if (seen[p - 'a']) {
                return false;
            } else {
                seen[p - 'a'] = true;
            }
        }
        return true;
    }
}
