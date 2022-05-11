package com.wes.study.leetcode.hashtable;

import java.util.HashMap;

public class Question454 {

    public static int solution1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for(int num1 : nums1) {
            for (int num2 : nums2) {
                int sum1 = num1 + num2;
                if(cache.containsKey(sum1)) cache.put(sum1, cache.get(sum1) + 1);
                else cache.put(sum1, 1);
            }
        }

        int res = 0;
        for(int num3 : nums3) {
            for(int num4 :nums4){
                int sum2 = num3 + num4;
                res += cache.getOrDefault(sum2, 0);
            }
        }
        return res;
    }
}
