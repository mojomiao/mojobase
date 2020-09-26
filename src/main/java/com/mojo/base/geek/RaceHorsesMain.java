package com.mojo.base.geek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RaceHorsesMain {
    
    public static void main(String[] args) {
        
        
        //System.out.println(all(new String[]{"下等", "中等", "上等"}));
        ArrayList horses = new ArrayList(Arrays.asList("t1", "t2"));
        win(horses, new ArrayList());
        
    }
    
    public static List<List<String>> all(String[] array) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), array, new boolean[array.length]);
        
        return res;
    }
    
    public static void backtrack(List<List<String>> res,
                                 List<String> tempList,
                                 String[] array,
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
            backtrack(res, tempList, array, visited);//递归
            visited[i] = false;//恢复
            tempList.remove(tempList.size() - 1);//恢复
        }
        
    }
    
    
    public static HashMap<String, Double> q_horses_time =
            new HashMap<String, Double>() {
                {
                    put("q1", 1.0);
                    put("q2", 2.0);
                    put("q3", 3.0);
                }
            };
    
    public static HashMap<String, Double> t_horses_time =
            new HashMap<String, Double>() {
                {
                    put("t1", 1.5);
                    put("t2", 2.5);
                    put("t3", 3.5);
                }
            };
    
    public static ArrayList<String> q_horses = new ArrayList<>(Arrays.asList("q1", "q2", "q3"));
    
    
    public static void win(ArrayList<String> horses, ArrayList<String> result){
        if (horses.size() == 0){
            System.out.println(result);
            //compare(result, q_horses);
            System.out.println();
            return;
        }
    
        for (int i = 0; i < horses.size(); i++) {
            ArrayList<String> new_result = (ArrayList<String>) result.clone();
            new_result.add(horses.get(i));
            
            ArrayList<String> rest_horses = (ArrayList<String>) horses.clone();
            rest_horses.remove(i);
            win(rest_horses, new_result);
        }
    }
    
    
    public static void compare(ArrayList t, ArrayList q) {
        int t_won_cnt = 0;
        for (int i = 0; i < t.size(); i++) {
            System.out.println(t_horses_time.get(t.get(i)) + " " + q_horses_time.get(q.get(i)));
            if (t_horses_time.get(t.get(i)) < q_horses_time.get(q.get(i))) t_won_cnt++;
        }
        if (t_won_cnt > (t.size() / 2)) System.out.println("田忌获胜！");
        else System.out.println("齐王获胜！");
        System.out.println();
    }
}
