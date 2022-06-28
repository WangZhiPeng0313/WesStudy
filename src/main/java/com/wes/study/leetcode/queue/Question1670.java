package com.wes.study.leetcode.queue;

import java.sql.Array;
import java.util.ArrayList;

/**
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 *
 * 请你完成 FrontMiddleBack 类：
 *
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 *
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 */
public class Question1670 {

    public static void main(String[] args) {

    }

    public static class FrontMiddleBackQueue {

        class ListNode {
            private int value;
            private ListNode pre;
            private ListNode next;

            ListNode(int value) {
                this.value = value;
            }

        }

        private ListNode head;
        private ListNode middle;
        private int middleIndex;
        private ListNode tail;
        private int count;

        public FrontMiddleBackQueue() {
            this.head = new ListNode(-1);
        }

        public void pushFront(int val) {
            ListNode tmp = new ListNode(val);
            tmp.next = this.head.next;
            this.head.next = tmp;
            this.count ++;
            moveMiddle();
        }

        private void moveMiddle(){
            if((this.count - 1) /2 > middleIndex){
                middleIndex = (this.count + 1) / 2;
                middle = middle.next;
            }
        }

        public void pushMiddle(int val) {
            ListNode tmp = new ListNode(val);
            ListNode prep = this.middle.pre;
            tmp.next = this.middle;
            this.middle.pre = tmp;
            prep.next = tmp;
            tmp.pre = prep;

            moveMiddle();
        }

        public void pushBack(int val) {
            ListNode tmp = new ListNode(val);
            this.tail.next = tmp;
            tmp.pre = this.tail;
            this.tail = tmp;
            moveMiddle();
        }

        public int popFront() {
            ListNode tmp = this.head.next;
            this.head.next = tmp.next;
            tmp.next.pre = this.head;
            moveMiddle();
            return tmp.value;
        }

        public int popMiddle() {
            return 0;
        }

        public int popBack() {
            ListNode tmp = this.head.next;
            this.head.next = tmp.next;
            tmp.next.pre = this.head;
            moveMiddle();
            return tmp.value;
        }
    }
}
