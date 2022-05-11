package com.wes.study.leetcode.hashtable;

import com.sun.prism.PresentableState;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question349 {

    public static int[] solution1(int[] nums1, int[] nums2){
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return null;

        Set<Integer> cache = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for(int num : nums1) cache.add(num);
        for(int num : nums2) {
            if(cache.contains(num)) result.add(num);
        }
        int[] res = new int[result.size()];
        int index = 0;
        for(int num : result) res[index++] = num;
        return res;
    }
}
