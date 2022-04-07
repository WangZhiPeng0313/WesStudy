package com.wes.study.alg.list;

import com.sun.javafx.charts.Legend;

public class SingleTrackList {

    // 单向列表的节点中含且只含有下一个节点的引用地址
    public class ListNode{
        private String value;
        private ListNode next;
    }

    // 初始化单向列表
    private int size;
    private ListNode head;
    private ListNode last;

    public SingleTrackList() {
        this.size = 0;
        head = new ListNode();
        last = null;
    }

    /**
     * 在头部添加一个元素
     */
    public void add(ListNode node) {
        // 当node节点为空时
        if(node == null) return;

        // 增加的节点添加到头部
        node.next = head.next;
        // 将头节点指向新增的节点
        head.next = node;
        // 长度+1
        size++;

        // 增加尾部节点
        if(this.last == null) this.last = node;
    }

    /**
     * 在尾部增加一个节点
     * @param node
     */
    public void append(ListNode node){
        if(node == null) return;
        // 判断链表是否进行了初始化
        if(this.head.next == null) add(node);
        // 在尾节点进行添加
        this.last.next = node;
        this.last = node;
        this.size++;
    }

    /**
     * 指定位置添加NODE
     * @param index
     * @param node
     */
    public void insert(int index, ListNode node) {
        if (index < 0 || node == null) return;
        // 当列表为空时，则直接添加到第一个位置
        if (head.next == null) add(node);
        // 定义链表的位置
        ListNode pre = this.head, curr = head.next;
        int idx = 0;
        while (curr != null) {
            if (idx == index) {
                pre.next = node;
                node.next = curr;
            } else {
                pre = pre.next;
                curr = pre.next;
                idx++;
            }
        }
    }

    /**
     * 删除指定节点
     * 删除指定节点时，需要用两个指针
     * @return
     */
    public ListNode remove(String  value){
        if(this.head.next == null) return null;
        ListNode pre = head, curr = pre.next;
        while(curr != null){
            if(!curr.value.equals(value)) {
                pre = pre.next;
                curr = pre.next;
            }
            else {
                pre.next = curr.next;
                break;
            }
        }
        return curr;
    }

    public void scan() {
        if (this.head.next == null) return;
        ListNode curr = this.head.next;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }

    public void update(int index, String value) {
        if(index < 0 || this.size < index+1) return ;
        int idx = 0;
        ListNode curr = this.head.next;
        while(curr != null){
            if(idx == index) curr.value = value;
            else {
                curr = curr.next;
                idx++;
            }
        }
    }
}
