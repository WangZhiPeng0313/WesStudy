package com.wes.study.alg.list;

import org.apache.flink.runtime.executiongraph.failover.AdaptedRestartPipelinedRegionStrategyNG;

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

        // 添加个数
        this.size++;
    }

    public void append(ListNode node) {
        if(node == null) return;
        // 如果链表为空
        if(this.size == 0) add(node);

        // 当链表不为空时
        this.last.next = node;
        node.pre = this.last;

        this.last = node;
        this.size++;
    }

    public void insert(int index, ListNode node){
        if(index < 0 || index > this.size || node == null) return;

        if(index == this.size) append(node);

        ListNode curr = this.head.next;
        int idx = 0;

        while(curr != null){
            if(index == idx) {
                ListNode pre = curr.pre;
                // 先处理后续的节点
                curr.pre = node;
                node.next = curr;
                // 在处理前序节点
                pre.next = node;
                node.pre = pre;
                this.size++;
            }
            else {
                curr = curr.next;
                idx++;
            }
        }
    }

    public ListNode remove(String value){
        if(value == null) return null;

        ListNode curr = this.head.next;
        while(curr != null){
            if(curr.value.equals(value)){
                ListNode pre = curr.pre, next = curr.next;
                pre.next = next;
                next.pre = pre;
                this.size--;
                return curr;
            }
            else curr = curr.next;
        }
        return null;
    }

    public void scanPrint(){
        ListNode curr = this.head.next;
        while(curr != null){
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    public void update(int index, String value){
        if(index < 0 || index >= this.size) return;

        ListNode curr = this.head.next;
        int idx = 0;

        while(curr != null){
            if(index == idx){
                curr.value = value;
                break;
            }
            else {
                curr = curr.next;
                idx ++;
            }
        }
    }
}
