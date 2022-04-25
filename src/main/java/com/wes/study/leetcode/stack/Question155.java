package com.wes.study.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Question155 {

    public static void main(String[] args) {

    }


    public static class MinStack {

        private Deque<Integer> xStack = null;
        private Deque<Integer> minStack = null;

        public MinStack() {
            this.xStack = new LinkedList<>();
            this.minStack = new LinkedList<>();
            this.minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            // 值放入到数值栈中
            xStack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }


}


