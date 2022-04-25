package com.wes.study.leetcode.stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Question20 {

    public static void main(String[] args) {
        String s = "[)";
        System.out.println(solution1(s));
    }

    /**
     *
     * @param s
     * @return
     */
    public static boolean solution1(String s){
        if(s == null || s.length() == 0) return true;

        boolean startFlag = true;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '(') {
                if (startFlag) {
                    stack.push(c);
                } else {
                    startFlag = false;
                }
            }
            else {
                if(c == '{' || c == '[' || c == '(') return false;
                else {
                    if(stack.isEmpty()) return false;
                    char c1 = stack.pop();
                    if(c == '}' && c1 != '{') return false;
                    else if(c == ']' && c1 != '[') return false;
                    else if(c == ')' && c1 != '(') return false;
                }
            }
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}
