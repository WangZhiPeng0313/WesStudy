package com.wes.study.alg.list;

/**
 * 双向列表
 */
public class DoubleTrackList {

    public class ListNode {
        private String value;
        private ListNode pre;
        private ListNode next;

    }

    private ListNode head;
    private ListNode last;
    private int size;

    public DoubleTrackList(){
        this.head = new ListNode();
        this.head.pre = this.head;
        this.head.next = null;
        this.last = null;
        this.size = 0;
    }

    public void add(ListNode node){
        if(node == null) return;

        // 处理后一个节点
        ListNode next = this.head.next;
        next.pre = node;
        node.next = next;

        // 处理头结点
        this.head.next = node;
        node.pre = this.head;

        // 处理last节点
        if(this.last == null) {
            this.last = node;
        }

    }

    public void append(ListNode node) {
    }

}
