package com.wes.study.leetcode.hot;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Question22 {

    public static List<String> solution(int n){
        int len = n * 2;

        Stack<String> cache = new Stack<>();
        List<String> ans = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        dfs(cache, ans, sb, 0, len);

        return ans;
    }

    public static void dfs(Stack<String> cache, List<String> ans, StringBuffer sb, int index, int len){
        if(index == len * 2) {
            ans.add(sb.toString());
            return;
        }

        // 当栈里头没有有括号时，则必须写左括号
        if(cache.size() == 0) {
            sb.append("(");
            cache.push(")");
            dfs(cache, ans, sb, index + 1, len);
            cache.pop();
            sb.deleteCharAt(sb.length() - 1);
        }
        // 必须添加右括号
        else if((len * 2 - index - 1) == cache.size()) {
            sb.append(")");
            cache.pop();
            dfs(cache, ans, sb, index + 1, len);
            cache.push(")");
            sb.deleteCharAt(sb.length() - 1);
        }
        else {
            // 添加左括号
            sb.append("(");
            cache.push(")");
            dfs(cache, ans, sb, index + 1, len);
            cache.pop();
            sb.deleteCharAt(sb.length() - 1);

            // 添加有括号
            sb.append(")");
            cache.pop();
            dfs(cache, ans, sb, index + 1, len);
            cache.push(")");
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static List<String> solution2(int n){
        StringBuffer sb = new StringBuffer();
        List<String> ans = new ArrayList<>();

        dfs2(ans, sb, 0, n);

        return ans;
    }

    public static void dfs2(List<String> ans, StringBuffer sb, int index, int len){
        if(index == len) {
            if(!ans.contains(sb.toString())) ans.add(sb.toString());
            return;
        }

        // 在前面增加一对括号
        String tmpBefore = sb.toString();
        sb.delete(0, sb.length()).append("()").append(tmpBefore);
        dfs2(ans, sb, index + 1, len);
        sb.delete(0, sb.length()).append(tmpBefore);


        // 在后面增加一对括号
        sb.append("()");
        dfs2(ans, sb, index + 1, len);
        sb.delete(sb.length() - 2, sb.length());

        // 在sb外面在天及一个括号
        String tmp = sb.toString();
        sb.delete(0, sb.length()).append("(").append(tmp).append(")");
        dfs2(ans, sb, index + 1, len);
        sb.delete(0, sb.length()).append(tmp);

    }
}
