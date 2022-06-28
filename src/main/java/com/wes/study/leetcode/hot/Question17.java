package com.wes.study.leetcode.hot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question17 {

    private static String[] NUM_CHARS = new String[] {
            // 0 - 1
            "", "",
            //2 - 9
            "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public static List<String> solution(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();

        List<String> res = new ArrayList<>();
        StringBuffer sb = new StringBuffer();

        dfs(digits, res, sb, 0);

        return res;
    }

    public static void dfs(String digits, List<String> res, StringBuffer sb, int index){
        // 已经超出字符串长度时，进行收缩
        // index 从0开始，每个index增加一个字符，当INDEX = digits.length()，表示所有字符遍历完了，返回结果
        if(index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        int num = Integer.parseInt(digits.charAt(index) + "");
        char[] chars = NUM_CHARS[num].toCharArray();

        for(char c : chars) {
            sb.append(c);
            dfs(digits, res, sb, index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
