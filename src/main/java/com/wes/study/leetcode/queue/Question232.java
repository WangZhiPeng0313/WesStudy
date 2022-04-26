package com.wes.study.leetcode.queue;

import java.util.Stack;

/**
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 */
public class Question232 {

    public static class MyQueue {

        // 输入栈，数据压入都押金输入栈
        private Stack<Integer> inStack = null;
        // 输出栈，只负责出栈操作，并且只有在outStack为空时再去inStack进行数据填充
        private Stack<Integer> outStack = null;

        public MyQueue() {
            inStack = new Stack<>();
            outStack = new Stack<>();
        }

        public void push(int x) {
            inStack.push(x);
        }

        public int pop() {
            if(outStack.isEmpty()) {
                in2Out();
            }
            return outStack.pop();
        }

        public int peek() {
            if(outStack.isEmpty()) {
                in2Out();
            }
            return outStack.peek();
        }

        public boolean empty() {
            return inStack.isEmpty() && outStack.isEmpty();
        }

        private void in2Out(){
            // 只有在outStack为空时进行数据转移，否则顺序出现错误
            if(!inStack.isEmpty() && outStack.isEmpty()){
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }

        }
    }
}
