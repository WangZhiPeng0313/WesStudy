package com.wes.study.leetcode.queue;

public class Question622 {

    /**
     * 这题的核心关键在于，会根据循环队列的headIndex 和 count 计算尾队列修那
     * tailIndex = (headIndex + count - 1) % capacity;
     */
    public static class MyCircularQueue {

        private int[] cache = null;
        // 该循环队列的容量是多少
        private int capacity;
        // 已存储多少元素
        private int count;
        // 队列头元素在哪里
        private int headIndex;

        public MyCircularQueue(int k) {
            this.cache = new int[k];
            this.capacity = k;
            this.count = 0;
            this.headIndex = 0;
        }

        /**
         * 进队列
         * @param value
         * @return
         */
        public boolean enQueue(int value) {
            // 当队列是满的时候，不在进行填充
            if(this.count == this.capacity) return false;
            // 队列有空间，进行填充

            int tailIndex = (this.headIndex + count) % capacity;
            this.cache[tailIndex] = value;
            this.count++;
            return true;
        }

        /**
         * 出栈
         * @return
         */
        public boolean deQueue() {
            if(this.count == 0 ) return false;
            // 进行元素剔除
            headIndex = (headIndex + 1) % capacity;
            this.count--;
            return true;
        }

        /**
         * 从对手获取元素
         * @return
         */
        public int Front() {
            if(this.count == 0) return -1;
            int tmp = this.cache[headIndex];
            // 删除对头元素
            this.headIndex = (this.headIndex + 1) % this.capacity;
            this.count--;
            return tmp;
        }

        public int Rear() {
            if(this.count == 0) return -1;
            int tmp = this.cache[(this.headIndex + this.count - 1) % capacity];
            this.count --;
            return tmp;
        }

        public boolean isEmpty() {
            return this.count == 0;
        }

        public boolean isFull() {
            return this.count == this.capacity;
        }
    }
}
