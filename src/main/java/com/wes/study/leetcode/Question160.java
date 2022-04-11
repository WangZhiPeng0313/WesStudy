package com.wes.study.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 求两个链表的首个相交节点
 */
public class Question160 {

    public class ListNode {
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
     * 方法1，使用哈希表进行快速检索
     */
    public static ListNode solution1(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;
        // 把链表A进行缓存
        Set<ListNode> cache = new HashSet<>();
        ListNode curr = headA;
        while(curr != null){
            cache.add(curr);
            curr = curr.next;
        }
        // 链表B进行遍历
        curr = headB;
        while(curr != null){
             if(cache.contains(curr)) return curr;
             else curr = curr.next;
        }
        return null;
    }

    public static ListNode solution2(ListNode headA, ListNode headB){
        if(headA == null || headB == null) return null;


        return null;
    }

}
