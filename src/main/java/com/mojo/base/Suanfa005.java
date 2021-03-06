package com.mojo.base;

import com.mojo.base.suanfa.ListNode;

public class Suanfa005 {
    
    
    public static void main(String[] args) {
        
    
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
    
    }
    
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            curr = nextTemp;
        }
        return prev;
    }
    
}
