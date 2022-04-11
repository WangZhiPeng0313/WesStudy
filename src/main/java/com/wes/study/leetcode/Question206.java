package com.wes.study.leetcode;

import java.util.List;

/**
 * 反转列表
 */
public class Question206 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }


    public ListNode reverseList(ListNode head) {
        // 当列表为空或者列表只有一个节点时，直接返回
        if(head == null || head.next == null ) return head;

        ListNode curr = head.next;
        // 先取出第一个节点，并置为最后一个节点
        ListNode pre = head;
        pre.next = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }

        head = pre;
        return head;
    }


}
