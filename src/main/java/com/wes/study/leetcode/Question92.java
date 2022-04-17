package com.wes.study.leetcode;

public class Question92 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode solition(ListNode head, int left, int right) {
        if(head == null || left == right) return head;

        // 设置无效头结点是因为有些操作直接从head起，会导致引用不准确
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;

        // 寻找left前的节点
        for(int i=1; i < left; i++){
            pre = pre.next;
        }

        // 寻找翻转部分的第一个节点
        ListNode firstNode = pre.next;
        ListNode curr = null;
        for(int i = left + 1; i <= right; i++){
            // 先获取下一个节点
            curr = firstNode.next;
            firstNode.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }

        return dummyHead.next;
    }
}
