package com.wes.study.leetcode.hot;

import java.util.List;
import java.util.TreeMap;

public class Question23 {


    public static  class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[2];
        listNodes[0] = new ListNode(1);
        listNodes[1] = new ListNode(0);
        ListNode ans = solution(listNodes);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }


    public static ListNode solution(ListNode[] lists){
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while(true){
            // 遍历所有节点找到最小值
            int minVal = Integer.MAX_VALUE;
            int minIdx = -1;
            boolean isOver = true;
            for(int i = 0; i < lists.length; ++i) {
                if(lists[i] != null) {
                    if(lists[i].val < minVal) {
                        minVal = lists[i].val;
                        minIdx = i;
                    }
                    isOver = false;
                }
            }
            if(isOver) break;

            // 将最小值节点取出
            ListNode node = lists[minIdx];
            lists[minIdx] = node.next;
            node.next = null;
            // 将最小值节点放到curr上
            curr.next = node;
            curr = curr.next;
        }

        return head.next;
    }
}
