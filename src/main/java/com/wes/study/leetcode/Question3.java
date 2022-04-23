package com.wes.study.leetcode;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 更悠久需要理解
 */
public class Question3 {

    public static void main(String[] args) {
        String s = "aabaab!bb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
    }

    /**
     * 这种要使用动态规划算法
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        // char[] chars = s.toCharArray();
        List<Character> charLists = new ArrayList<>();
        int result = 0;

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!charLists.contains(c)) {
                charLists.add(c);
                if(charLists.size() > result) result = charLists.size();
            }
            else {
                int index = charLists.indexOf(c);
                charLists.removeAll(charLists.subList(0, index + 1 ));
                charLists.add(c);
                if(charLists.size() > result) result = charLists.size();
            }
        }

        return result;
    }

    public static int solution1(String s ){
        if(s == null || s.length() == 0) return 0;
        int result = 0;

        return result;
    }

}
