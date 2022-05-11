package com.wes.study.leetcode.hashtable;

import java.util.HashMap;

public class Question383 {

    public static boolean solution1(String ransomNote, String magazine){
        HashMap<Character, Integer> cache = new HashMap<>();

        for(char c : magazine.toCharArray()){
            if(cache.containsKey(c)) cache.put(c, cache.get(c) + 1);
            else cache.put(c,1);
        }

        for(char c : ransomNote.toCharArray()) {
            if(cache.containsKey(c)) {
                int cnt = cache.get(c);
                if(cnt == 0) return false;
                else cache.put(c, cnt - 1);
            }
            else return false;
        }

        return true;
    }
}
