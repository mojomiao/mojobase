package com.mojo.base.leetcode;

import java.util.ArrayList;
import java.util.List;

public class QuanPailieCharMain {
    
    public static void main(String[] args) {
        List<String> stringList = new QuanPailieCharMain()
                .combStr("abc");
    
        System.out.println(stringList);
    
    }
    
    
    public List<String> combStr(String str){
            List<String> res = new ArrayList<>();
            
        backtrack(res, str, 0, new StringBuffer());
        return res;
        
    }
    
    public void backtrack(List<String> res, String olgStr, int index, StringBuffer sb){
        
        if (index == olgStr.length()){
            res.add(sb.toString());
        }else {
            int letterCount = olgStr.length();
            for (int i = 0; i < letterCount; i++) {
                if (sb.toString().contains(olgStr.charAt(i)+"")){
                    continue;
                }
                sb.append(olgStr.charAt(i));
                backtrack(res, olgStr, index+1, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}
