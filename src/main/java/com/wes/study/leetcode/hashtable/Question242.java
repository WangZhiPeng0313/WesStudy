package com.wes.study.leetcode.hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词
 */
public class Question242 {

    public static void main(String[] args) {

    }

    public static boolean solution1(String s, String t){
        if(s == null || s.isEmpty() || t == null || t.isEmpty()) return false;
        HashMap<Character, Integer> chars1 = new HashMap<>();
        for(char c : s.toCharArray()){
            if(chars1.containsKey(c)) {
                chars1.put(c, chars1.get(c) + 1);
            }
            else {
                chars1.put(c, 1);
            }
        }

        //
        for(char c : t.toCharArray()){
            if(chars1.containsKey(c)) {
                chars1.put(c, chars1.get(c) - 1);
            }
            else {
                return false;
            }
        }

        for(char c : chars1.keySet()){
            if(chars1.get(c) != 0 ) return false;
        }
        return true;
    }

    /**
     * 数组的 index + value 也可以组成HASHMAP的功能，并且速度更快
     * @param s
     * @param t
     * @return
     */
    public static boolean solution2(String s, String t){
        if(s.length() != t.length()) return false;
        int len = s.length();
        int[] cache = new int[26];
        for(int i = 0; i < len; i++){
            cache[s.charAt(i) - 'a']++;
            cache[t.charAt(i) - 'a']--;
        }

        for(int i : cache){
            if(i == 0) return false;
        }
        return true;
    }

}
