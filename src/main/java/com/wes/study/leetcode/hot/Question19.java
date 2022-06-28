package com.wes.study.leetcode.hot;

import java.util.List;

public class Question19 {

public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
 }

    public static ListNode solution(ListNode head, int n){

        ListNode pre = head, curr = head;
        for(int i = 0; i < n; ++i){
            curr = curr.next;
        }

        while(curr.next != null){
            curr = curr.next;
            pre = pre.next;
        }

        ListNode ans = pre.next;
        pre.next = ans.next;
        ans.next = null;
        return head;
    }
}
