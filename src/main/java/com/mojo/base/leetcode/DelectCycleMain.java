package com.mojo.base.leetcode;

import com.mojo.base.suanfa.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DelectCycleMain {
    
    public ListNode detectCycle(ListNode head) {
        
        if (head == null) {
            return null;
        }
        
        if (head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null) {
            
            if (slow.val == fast.val) {
                return slow;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }
    
    public ListNode detectCycle2(ListNode head) {
        
        Set<ListNode> visited = new HashSet<>();
        
        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }
    
    public ListNode detectCycle3(ListNode head) {
        
        ListNode fast = head, slow = head;
        
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
    
    public double myPow(double x, int n) {
        if (n >= 0) {
            return pow1(x, n);
        } else {
            return 1.0 / pow1(x, n * -1);
        }
    }
    
    public double pow1(double x, int n) {
        if (n != 0) {
            return x * pow1(x, n - 1);
        } else {
            return 1;
        }
        
    }
    
    public double pow2(double x, int n) {
        if (n != 0) {
            return 1.0 / (x * pow2(x, n + 1));
        } else {
            return 1.0;
        }
        
    }
    
    public static void main(String[] args) {

//        System.out.println(1.0/2.0);
//        System.out.println(new DelectCycleMain().pow2(2.0, -2));
        
        //System.out.println(new DelectCycleMain().myPow(2.0, -2));
        
        //System.out.println(qPow(2, 9));
    
        System.out.println(binaryPow(2,3));
    }
    
    public static int quickPow(int x, int pow) {
        int ans = 1, base = x;
        while (pow != 0) {
            if ((pow & 1) != 0) {
                ans *= base;
            }
            base *= base;
            pow >>= 1;
        }
        return ans;
    }
    
    /**
     * 快速幂
     *
     * @param num
     * @param pow
     * @return
     */
    public static int qPow(int num, int pow) {
        
        if (pow == 0) {
            return 1;
        } else if ((pow & 1) == 1) {//奇数，先计算num的pow-1次方，再乘以num
            return qPow(num, pow - 1) * num;
        } else {//偶数，先计算num的pow/2次方，再把结果平方
            int temp = qPow(num, pow / 2);
            return temp * temp;
        }
        
        
    }
    
    public static int myPow(int base, int pow){
        
        if (pow == 0){
            return 1;
        }else if((pow & 1) == 1){
            return myPow(base, pow - 1)* base;
        }else {
            int temp = myPow(base, pow/2);
            return temp*temp;
        }
        
        
        
    }
    
    public static int binaryPow(int num, int pow) {
        int ans = 1;
        while (pow != 0) {
            if ((pow & 1) == 1) {
                ans = ans * num;//奇数，乘以自己
            }
            num *= num;//无论如何都需要num^2
            pow >>= 1;//次方右移一位
        }
        return ans;
    }
}
