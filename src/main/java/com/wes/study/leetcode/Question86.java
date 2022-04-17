package com.wes.study.leetcode;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.List;

public class Question86 {


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public static ListNode solution1(ListNode head, int x){
        if(head == null || head.next == null) return head;

        ListNode small = new ListNode(-1);
        ListNode smallHead = small;
        ListNode large = new ListNode(-1);
        ListNode largeHead = large;

        ListNode curr = head;
        head = head.next;
        while(curr != null){
            curr.next = null;
            if(curr.val < x){
                smallHead.next = curr;
                smallHead = curr;
            }
            else {
                largeHead.next = curr;
                largeHead = curr;
            }
            curr = head;
            if(head != null) head = head.next;
        }

        smallHead.next = large.next;
        return small.next;
    }


}
