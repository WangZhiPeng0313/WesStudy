package com.wes.study.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class Question350 {

    public static void main(String[] args) {

    }

    public static int[] solution1(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[]{};

        HashMap<Integer, Integer> cache = new HashMap<>();
        HashMap<Integer, Integer> index = new HashMap<>();
        for(int num : nums1){
            if(cache.containsKey(num)) cache.put(num, cache.get(num) + 1);
            else cache.put(num,1);
        }

        for(int num : nums2){
            if(cache.containsKey(num)) {
                int nums1Cnt = cache.get(num);
                if(!index.containsKey(num)) index.put(num, 1);
                else index.put(num, Math.min(nums1Cnt, index.get(num) +1));
            }
        }

        int resultLen = 0;
        for(int size : index.values()){
            resultLen += size;
        }
        int[] result = new int[resultLen];
        int idx = 0;
        for(Map.Entry<Integer, Integer> entry : index.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            for(int i = 0; i< value; i++){
                result[idx++] = key;
            }
        }
        return result;
    }


}
