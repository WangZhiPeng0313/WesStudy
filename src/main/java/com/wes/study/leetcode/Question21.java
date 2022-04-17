package com.wes.study.leetcode;

import java.util.List;

/**
 * 合并两个有序链表
 */
public class Question21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    /**
     * 迭代方法
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode solution1(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode last = head;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val) {
                last.next = list1;
                list1 = list1.next;
            }
            else {
                last.next = list2;
                list2 = list2.next;
            }
            last = last.next;
        }

        last.next = list1 == null? list2:list1;
        return head.next;
    }



    public static ListNode sulution2(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        else if(list2 == null) return list1;
        else if(list1.val <= list2.val){
            list1.next = sulution2(list1.next, list2);
            return list1;
        }
        else {
            list2.next = sulution2(list1, list2.next);
            return list2;
        }
    }
}
