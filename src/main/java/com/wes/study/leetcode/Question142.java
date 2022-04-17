package com.wes.study.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 环形链表2
 *
 */
public class Question142 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {

            val = x;

            next = null;

        }
    }

    public static void main(String[] args) {
    }

    /**
     * 使用hash表
     */
    public static ListNode solution1(ListNode head){
        if(head == null || head.next == null) return null;

        HashSet<ListNode> cache = new HashSet<>();
        ListNode curr = head;

        while(curr != null){
            if(cache.contains(curr)) {
                return curr;
            }
            cache.add(curr);
            curr = curr.next;
        }
        return null;
    }


    /**
     * 采用数学方法进行验证
     * 经过数学方法验证，当slow 和 fast指针在环内相遇时，
     * head到入环节点的距离 = slow 入环节点的距离 + n倍环长度
     * @return
     */
    public static ListNode solution2(ListNode head){
        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null){
            slow = slow.next;
            if(fast.next != null) fast = fast.next.next;

            if(slow == fast){
                ListNode res = head;
                while(res != null){
                    if(slow == res) return res;
                    else {
                        slow = slow.next;
                        res =res.next;
                    }
                }
            }
        }
        return null;
    }

}
