package com.wes.study.leetcode.hot;

import java.util.List;

public class Question2 {

public static class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}


    public static void main(String[] args) {

    }

    public static ListNode solution(ListNode l1, ListNode l2 ){
        ListNode head = new ListNode();
        ListNode last = head;
        int addFlag = 0;

        // 两个链表每次移动以为向后移动
        while(l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int tmpSum = val1 + val2 + addFlag;

            // 除以的方式计算
            addFlag = tmpSum / 10;
            tmpSum = tmpSum % 10;

            ListNode tmpNode = new ListNode(tmpSum);
            last.next = tmpNode;
            last = tmpNode;

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }

        if(addFlag == 1) last.next = new ListNode(1);

        return head.next;
    }
}
