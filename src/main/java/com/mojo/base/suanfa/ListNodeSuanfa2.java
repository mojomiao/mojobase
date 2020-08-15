package com.mojo.base.suanfa;

public class ListNodeSuanfa2 {
    
    
    public static void main(String[] args) {
        
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
    
        ListNode rev = rev(n1);
        System.out.println(rev);
    
    }
    
    public static ListNode rev(ListNode head){
        
        ListNode prev = null;
        
        ListNode cur = head;
        
        while (cur != null){
            
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            
        }
        return prev;
        
        
    }
}
