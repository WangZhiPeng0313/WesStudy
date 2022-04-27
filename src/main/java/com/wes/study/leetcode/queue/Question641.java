package com.wes.study.leetcode.queue;

/**
 * 设计双端循环队列
 */
public class Question641 {

    public static class MyCircularDeque {

        private int[] cache;
        private int capacity;
        private int count;
        private int headIndex;
        private int tailIndex;

        public MyCircularDeque(int k) {
            this.cache = new int[k];
            this.capacity = k;
            this.count = 0;
            this.headIndex = 0;
            this.tailIndex = 0;
        }

        public boolean insertFront(int value) {
            if(this.count == capacity) return false;

            this.headIndex = (headIndex - 1 + this.capacity) % capacity;
            this.cache[headIndex] = value;
            this.count++;
            return true;
        }

        public boolean insertLast(int value) {
            if(this.count == this.capacity) return false;
            this.cache[this.tailIndex] = value;
            this.tailIndex = (this.tailIndex + 1) % this.capacity;
            this.count ++ ;
            return true;
        }

        public boolean deleteFront() {
            if(this.count == 0) return false;
            this.headIndex = ( headIndex + 1 ) % capacity;
            this.count --;
            return true;
        }

        public boolean deleteLast() {
            if(this.count == 0) return false;
            this.tailIndex = (this.tailIndex - 1 + this.capacity) % this.capacity;
            this.count --;
            return true;
         }

        public int getFront() {
            if(this.count == 0) return -1;
            return this.cache[this.headIndex];
        }

        public int getRear() {
            if(this.count == 0) return -1;
            return this.cache[(this.tailIndex - 1 + this.capacity) % this.capacity];
        }

        public boolean isEmpty() {
            return this.count == 0;
        }

        public boolean isFull() {
            return this.count == this.capacity;
        }
    }
}
