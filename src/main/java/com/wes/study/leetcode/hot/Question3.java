package com.wes.study.leetcode.hot;

import java.util.*;

public class Question3 {

    public static void main(String[] args) {

    }

    public static int solution(String s){
        if(s == null || s.length() == 0) return 0;

        int ans = 0;
        List<Character> charList = new ArrayList();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            char c = chars[i];
            if(charList.contains(c))  {
                int index = charList.indexOf(c);
                charList.removeAll(charList.subList(0, index + 1));
            }
            charList.add(c);
            ans = ans > charList.size() ? ans : charList.size();
        }

        return ans;
    }

    public static int solution2(String s){
        if(s == null || s.length() == 0) return 0;

        // 当KEY时char是，可以使用int数组代替Map函数
        int[] cache = new int[256];
        for(int i = 0; i < cache.length; i++) cache[i] = -1;

        char[] chars = s.toCharArray();
        int start = 0, ans = 0;
        for(int i = 0; i < chars.length; i++){
            // 计算这个CHAR是否在cache存在
            int index = cache[chars[i]];
            // 如果存在，则start = index + 1;
            // 如果不存在，则start保持原值;
            start = Math.max(start, index + 1);
            // 根据新计算的START，计算新的START
            ans = Math.max(ans, i - start + 1);
            // 将每一个字符的最新的INDEX放到数据中
            cache[index] = i;

        }

        return ans;
    }
}
