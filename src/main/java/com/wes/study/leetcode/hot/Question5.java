package com.wes.study.leetcode.hot;

public class Question5 {


    /**
     * 中心扩散法
     * @param s
     */
    public static String solution1(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        String ans = "";

        for(int i = 0 ; i < len; i++){

            // 以该字符中心进行扩散
            int left = i, right = i;
            while(left >= 0 && right < len){
                if(s.charAt(left) == s.charAt(right)) {
                    if(right - left + 1 > ans.length()) ans = s.substring(left, right + 1);
                }
                else break;
                left--;
                right++;
            }

            // 以该字符和前一个字符为中心进行扩散
            left = i - 1;
            right = i;
            while(left >= 0 && right < len ) {
                if(s.charAt(left) == s.charAt(right)) {
                    if(right - left + 1 > ans.length()) ans = s.substring(left, right + 1);
                }
                else break;
                left--;
                right++;
            }
        }
        return ans;
    }
}
