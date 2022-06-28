package com.wes.study.leetcode.hot;

import sun.awt.HKSCS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Question20 {


    /**
     * 返回FALSE的条件
     * (1) 左括号匹配不到右括号
     * (2) 右括号匹配不到左括号
     * (3) 匹配到的括号不正确
     * @param s
     * @return
     */
    public static boolean solution(String s) {

        List<Character> START_FLAG = Arrays.asList('[', '{', '(');
        List<Character> END_FLAG = Arrays.asList(']', '}', ')');

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();

        for(char c : chars) {
            if(START_FLAG.contains(c)) {
                stack.push(c);
            }
            else if(END_FLAG.contains(c)) {
                // 右括号匹配不到左括号
                if(stack.size() == 0) return false;
                // 右括号匹配的左括号不相同
                char startChar = stack.pop();
                if(c == '[' && startChar != ']') return false;
                else if(c == '{' && startChar != '}') return false;
                else if(c == '(' && startChar != ')') return false;
            }
        }

        // 左括号匹配不到右括号
        if(stack.size() == 0) return true;
        else return false;
    }
}
