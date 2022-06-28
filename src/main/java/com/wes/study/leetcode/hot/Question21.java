package com.wes.study.leetcode.hot;

public class Question21 {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    /**
     *
     * @param list1
     * @param list2
     * @return
     */
    public static ListNode solution(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode head = new ListNode(-1);
        ListNode curr = head;

        // 两个做归并排序，直接一个结束，然后直接将另一个挂到尾部
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val) {
                curr.next = list1;
                curr = list1;
                list1 = list1.next;
                curr.next = null;
            }
            else {
                curr.next = list2;
                curr = list2;
                list2 = list2.next;
                curr.next = null;
            }
        }

        if(list1 != null) curr.next = list1;
        if(list2 != null) curr.next = list2;

        return head.next;
    }
}
