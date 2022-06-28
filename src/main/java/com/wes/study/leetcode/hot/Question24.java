package com.wes.study.leetcode.hot;

public class Question24 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode solution(ListNode head){
        // 创建一个为伪头节点
        ListNode dummp = new ListNode(-1);
        ListNode listEnd = dummp;

        ListNode first = head;
        while(first != null && first.next != null){
            // 拿出FIRST和SECOND两个节点
            ListNode second = first.next;
            head = second.next;

            // FIRST 和 SECOND 开始交换
            second.next = first;
            first.next = null;
            listEnd.next = second;
            listEnd = first;

            //
            first = head;
        }

        if(first != null) listEnd.next = first;

        return dummp.next;
    }
}
