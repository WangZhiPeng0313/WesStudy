package com.wes.study.leetcode.queue;

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

        }

        public boolean insertLast(int value) {

        }

        public boolean deleteFront() {

        }

        public boolean deleteLast() {

        }

        public int getFront() {

        }

        public int getRear() {

        }

        public boolean isEmpty() {

        }

        public boolean isFull() {

        }
    }
}
