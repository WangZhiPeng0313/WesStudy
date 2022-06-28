package com.wes.study.leetcode.hot;

import java.util.Map;

public class Question49 {

    public static void solution(String[] strs){
        int size = strs.length;
        int strMaxLen = 0;
        for(String str : strs) if (str.length() > strMaxLen) strMaxLen = str.length();
    }
}
