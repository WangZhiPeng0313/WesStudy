package com.wes.study.leetcode;

import java.util.List;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 */
public class Question2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode result = solution1(new ListNode(2), new ListNode(8));
        System.out.println(result.val);
        System.out.println(result.next.val);
    }

    public static ListNode solution1(ListNode l1, ListNode l2) {
        int addOneFlag = 0;
        ListNode result = null;
        ListNode lastNode = null;
        while(true){
            // 获取两个数字
            ListNode l1Ele = l1;
            ListNode l2Ele = l2;
            if(l1Ele == null && l2Ele == null) {
                if(addOneFlag == 1 ) {
                    lastNode.next = new ListNode(1);
                }
                break;
            }

            // 计算值
            int value1 = 0, value2 = 0;
            if(l1Ele != null) value1 = l1Ele.val;
            if(l2Ele != null) value2 = l2Ele.val;
            int tmp = value1 + value2 + addOneFlag;
            if(tmp >= 10) {
                tmp = tmp - 10;
                addOneFlag = 1 ;
            }
            else addOneFlag = 0;

            if(result == null) {
                result = new ListNode(tmp);
                lastNode = result;
            }
            else {
                lastNode.next = new ListNode(tmp);
                lastNode = lastNode.next;
            }

            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return result;
    }
}
