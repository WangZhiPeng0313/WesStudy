package com.wes.study.leetcode.hashtable;

import java.util.*;

/**
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案
 */
public class Question1002 {

    public static void main(String[] args) {

    }

    public static List<String> solution1(String[] words){
        if(words == null || words.length == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        int[] cache = new int[26];
        int[] chars = new int[26];

        for(char c : words[0].toCharArray()){
            cache[c - 'a']++;
        }

        for(int i =1;i < words.length; i++){
            String word = words[i];
            // 清0
            for(int j = 0; j < chars.length; j++) chars[j] = 0;
            for(char c: word.toCharArray()) chars[c - 'a']++;

            for(int j =0;i< 26;j++) if(cache[j] > chars[j]) cache[j] = chars[j];
        }

        for(int i = 0; i< 26; i++){
            int size = cache[i];
            for(int m = 0; m < size; m++) result.add(('a' + i) + "");
        }

        return result;
    }


}
